package br.uff.ihs.ss.security;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.uff.ihs.ss.model.Usuario;

/**
 * JwtAuthenticationFilter. Intercepta quando a url "/login" eh chamada,
 * enviando a autenticacao para o responsavel (no caso
 * CustomAuthenticationProvider). Em caso de sucesso, chama o metodo
 * successfulAuthentication, gerando o token na resposta. Em caso de erro, chama
 * o default do Spring (ou componente que implemente
 * AuthenticationFailureHandler, setado no SecurityConfig
 * (http.failureHandler(...)))
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private JwtSecurityUtil jwtSecurityUtil;

    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    public JwtAuthenticationFilter(AuthenticationManager authManager) {
        this.authenticationManager = authManager;
        setFilterProcessesUrl(JwtSecurityUtil.LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String username, password;
        try {
            String body = request.getReader().lines().collect(Collectors.joining());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode obj = mapper.readTree(body);
            username = obj.get("username").textValue();
            password = obj.get("password").textValue();
        } catch (Exception e) {
            log.error("Erro ao ler usuario/senha da requisicao", e);
            return null;
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain, Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        if (jwtSecurityUtil == null)
            jwtSecurityUtil = JwtSecurityUtil.getInstance(request);
        String token = jwtSecurityUtil.createToken(usuario, roles);
        response.setHeader(JwtSecurityUtil.TOKEN_HEADER, JwtSecurityUtil.TOKEN_PREFIX + token);
    }
}