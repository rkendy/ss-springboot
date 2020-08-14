package br.uff.ihs.ss.security;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import br.uff.ihs.ss.model.Usuario;

@Component
public class JwtSecurityUtil {

    public static final String LOGIN_URL = "/login";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
    public static final String TOKEN_ROLES_STR = "rol";
    public static final String TOKEN_USER_NAME = "user-name";
    public static final String TOKEN_USER_ID = "user-id";

    public static JwtSecurityUtil getInstance(HttpServletRequest req) {
        ServletContext sc = req.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
        return wac.getBean(JwtSecurityUtil.class);
    }

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expiration}")
    private Long expiration;

    public Claims parseToken(HttpServletRequest request) {
        return parseTokenStr(request.getHeader(TOKEN_HEADER));
    }

    public Claims parseToken(String token) {
        return parseTokenStr(token);
    }

    public List<SimpleGrantedAuthority> getRoles(Claims body) {
        return ((List<?>) body.get(TOKEN_ROLES_STR)).stream()
                .map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());
    }

    public String getUsername(Claims body) {
        return body.getSubject();
    }

    public Date getExpirationDate(Claims body) {
        return body.getExpiration();
    }

    public Long getExpiration() {
        return expiration;
    }

    public String getUsuarioNome(Claims body) {
        return (String) body.get(JwtSecurityUtil.TOKEN_USER_NAME);
    }

    public Long getUsuarioId(Claims body) {
        return (Long) body.get(JwtSecurityUtil.TOKEN_USER_ID, Long.class);
    }

    public String createToken(Usuario usuario, List<String> roles) {
        return Jwts.builder().signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", JwtSecurityUtil.TOKEN_TYPE).setIssuer(JwtSecurityUtil.TOKEN_ISSUER)
                .setAudience(JwtSecurityUtil.TOKEN_AUDIENCE).setSubject(usuario.getLogin())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .claim(JwtSecurityUtil.TOKEN_ROLES_STR, roles).claim(JwtSecurityUtil.TOKEN_USER_NAME, usuario.getNome())
                .claim(JwtSecurityUtil.TOKEN_USER_ID, usuario.getId()).compact();
    }

    private Claims parseTokenStr(String token) {
        if (token != null && !token.isEmpty() && token.startsWith(TOKEN_PREFIX)) {
            return getParsedToken(token).getBody();
        }
        return null;
    }

    private Jws<Claims> getParsedToken(String token) {
        return Jwts.parser().setSigningKey(secret.getBytes())
                .parseClaimsJws(token.replace(JwtSecurityUtil.TOKEN_PREFIX, ""));
    }

}