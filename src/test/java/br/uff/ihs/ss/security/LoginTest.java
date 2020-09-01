package br.uff.ihs.ss.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.uff.ihs.ss.helper.UsuarioTestHelper;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.UsuarioService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {

    @LocalServerPort
    int port;

    @Autowired
    private UsuarioTestHelper usuarioHelper;

    @MockBean
    private UsuarioService usuarioService;

    HttpHeaders headers = new HttpHeaders();
    TestRestTemplate restTemplate = new TestRestTemplate();

    @BeforeEach
    public void setUp() {
        headers.setContentType(MediaType.APPLICATION_JSON);
        Usuario usuario = Usuario.builder().login("login").nome("Nome").ativo(true).admin(false).build();
        when(usuarioService.findByLogin(anyString())).thenReturn(usuario);
    }

    @Test
    public void givenNotLoggedInWhenAccessApiShouldReturn401() throws Exception {
        ResponseEntity<String> response = makeGetRequest("/api/usuario");
        assertEquals(HttpStatus.UNAUTHORIZED.value(), response.getStatusCode().value());
    }

    @Test
    public void givenNotLoggedInWhenAccessLoginUrlShouldReturn200() throws Exception {
        String loginForm = "{\"username\": \"username\", \"password\": \"password\"}";
        ResponseEntity<String> response = makePostRequest(JwtSecurityUtil.LOGIN_URL, loginForm);
        String bearer = response.getHeaders().get(JwtSecurityUtil.TOKEN_HEADER).get(0);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(true, bearer.startsWith(JwtSecurityUtil.TOKEN_PREFIX));
        assertTrue(bearer.length() > JwtSecurityUtil.TOKEN_PREFIX.length());
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