package br.uff.ihs.ss.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.uff.ihs.ss.controller.SetorController;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.UsuarioService;
import io.jsonwebtoken.Claims;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {

    @LocalServerPort
    int port;

    @Autowired
    private JwtSecurityUtil jwtSecurityUtil;

    @MockBean
    private UsuarioService usuarioService;

    private Usuario usuarioNoAdmin;
    private Usuario usuarioAdmin;

    HttpHeaders headers;
    TestRestTemplate restTemplate = new TestRestTemplate();

    @BeforeEach
    public void setUp() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void givenNotLoggedInWhenAccessApiShouldReturn401() throws Exception {
        ResponseEntity<String> response = makeGetRequest("/api/solicitacao");
        assertEquals(HttpStatus.UNAUTHORIZED.value(), response.getStatusCode().value());
    }

    @Test
    public void givenNotLoggedInWhenAccessLoginUrlShouldReturn200() throws Exception {

        ResponseEntity<String> response = loginWithoutAdminAccess();
        String token = getToken(response);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertTrue(token.startsWith(JwtSecurityUtil.TOKEN_PREFIX));
        assertTrue(token.length() > JwtSecurityUtil.TOKEN_PREFIX.length());
    }

    @Test
    public void givenNotLoggedInWhenAccessLoginUrlShouldReturnCorrectClaims() throws Exception {
        Date expectedExpirationDate = new Date(System.currentTimeMillis() + jwtSecurityUtil.getExpiration() - 1000);
        ResponseEntity<String> response = loginWithoutAdminAccess();

        Claims claims = jwtSecurityUtil.parseToken(getToken(response));
        Date expirationDate = jwtSecurityUtil.getExpirationDate(claims);
        String username = jwtSecurityUtil.getUsername(claims);
        Long id = jwtSecurityUtil.getUsuarioId(claims);
        String nome = jwtSecurityUtil.getUsuarioNome(claims);

        assertEquals(usuarioNoAdmin.getLogin(), username);
        assertEquals(usuarioNoAdmin.getId(), id);
        assertEquals(usuarioNoAdmin.getNome(), nome);
        assertTrue(expirationDate.after(expectedExpirationDate));
    }

    @Test
    public void givenLoginWithAdminWhenAccessLoginUrlShouldReturnAdminClaim() throws Exception {
        Usuario admin = Usuario.builder().login("login").nome("Nome").ativo(true).admin(true).build();
        when(usuarioService.findByLogin(anyString())).thenReturn(admin);

        ResponseEntity<String> response = loginWithAdminAccess();

        Claims claims = jwtSecurityUtil.parseToken(getToken(response));
        List<SimpleGrantedAuthority> roles = jwtSecurityUtil.getRoles(claims);

        assertEquals(1, roles.size());
        assertEquals(JwtSecurityUtil.ROLE_ADMIN, roles.get(0).getAuthority());
    }

    @Test
    public void givenLoggedInWhenAccessAdminUrlShouldReturnOk() {
        Usuario admin = Usuario.builder().login("login").nome("Nome").ativo(true).admin(true).build();
        when(usuarioService.findByLogin(anyString())).thenReturn(admin);

        loginWithAdminAccess();
        ResponseEntity<String> response = makeGetRequest(SetorController.ENDPOINT);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    private ResponseEntity<String> loginWithoutAdminAccess() {
        String loginForm = "{\"username\": \"username\", \"password\": \"password\"}";
        usuarioNoAdmin = Usuario.builder().id(1L).login("login").nome("Nome").ativo(true).admin(false).build();
        when(usuarioService.findByLogin(anyString())).thenReturn(usuarioNoAdmin);

        return makePostRequest(JwtSecurityUtil.LOGIN_URL, loginForm);
    }

    private ResponseEntity<String> loginWithAdminAccess() {
        String loginForm = "{\"username\": \"username\", \"password\": \"password\"}";
        usuarioAdmin = Usuario.builder().id(1L).login("login").nome("Nome").ativo(true).admin(true).build();
        when(usuarioService.findByLogin(anyString())).thenReturn(usuarioAdmin);

        // Make login request
        ResponseEntity<String> response = makePostRequest(JwtSecurityUtil.LOGIN_URL, loginForm);

        // Set header with token:
        headers.set(JwtSecurityUtil.TOKEN_HEADER, getToken(response));

        return response;
    }

    private String getToken(ResponseEntity<String> response) {
        return response.getHeaders().get(JwtSecurityUtil.TOKEN_HEADER).get(0);
    }

    protected ResponseEntity<String> makeGetRequest(String url) {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        return restTemplate.exchange(createURLWithPort(url), HttpMethod.GET, entity, String.class);
    }

    protected ResponseEntity<String> makePostRequest(String url, String jsonObj) {
        HttpEntity<String> entity = new HttpEntity<String>(jsonObj, headers);
        return restTemplate.postForEntity(createURLWithPort(url), entity, String.class);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}