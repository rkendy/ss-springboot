package br.uff.ihs.ss.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import br.uff.ihs.ss.model.Usuario;
import io.jsonwebtoken.Claims;

/**
 * Responsavel por verificar se o token está presente nas requisições.
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
    private JwtSecurityUtil jwtSecurityUtil;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        UsernamePasswordAuthenticationToken auth = getAuthentication(request);
        if (auth == null) {
            filterChain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        try {
            if (jwtSecurityUtil == null)
                jwtSecurityUtil = JwtSecurityUtil.getInstance(request);
            Claims body = jwtSecurityUtil.parseToken(request);
            Usuario u = buildUsuario(body);
            List<SimpleGrantedAuthority> roles = jwtSecurityUtil.getRoles(body);
            return new UsernamePasswordAuthenticationToken(u, null, roles);
        } catch (Exception e) {
            log.info(String.format("Erro na verificacao do token: %s. Excecao: %s",
                    request.getHeader(JwtSecurityUtil.TOKEN_HEADER), e.getStackTrace()));
        }
        return null;
    }

    private Usuario buildUsuario(Claims body) {
        String username = jwtSecurityUtil.getUsername(body);
        String nome = jwtSecurityUtil.getUsuarioNome(body);
        Long usuarioId = jwtSecurityUtil.getUsuarioId(body);
        return Usuario.builder().login(username).id(usuarioId).nome(nome).build();
    }

}