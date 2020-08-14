package br.uff.ihs.ss.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.LdapService;
import br.uff.ihs.ss.service.UsuarioService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    LdapService ldapService;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        Usuario usuario = null;
        try {
            ldapService.authenticate(username, password);
            usuario = usuarioService.findByLogin(username);
            if (usuario == null)
                throw new BadCredentialsException("Usuario nao encontrado no banco de dados");
            if (isAdmin(usuario)) {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        } catch (Exception e) {
            throw new BadCredentialsException("Falha na Autenticacao LDAP");
        }
        return new UsernamePasswordAuthenticationToken(usuario, password, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    private boolean isAdmin(Usuario usuario) {
        return usuario.getAtivo() && usuario.getAdmin();
    }

}