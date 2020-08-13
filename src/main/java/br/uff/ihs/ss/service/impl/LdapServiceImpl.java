package br.uff.ihs.ss.service.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.LdapService;

@Service
public class LdapServiceImpl implements LdapService {

    @Autowired
    private Environment env;

    public boolean authenticate(final String login, final String password) throws Exception {
        try {
            authenticateUser(login, password);
        } catch (NamingException e) {
            throw new Exception();
        }
        return true;
    }

    public void setEnvironment(Environment env) {
        this.env = env;
    }

    public String LOGIN = "sAMAccountName";
    public String MAIL = "mail";
    public String CN = "cn";
    public String TELEFONE = "telephoneNumber";
    public String UNIQUENAME = "distinguishedName";

    private String ldap_hosts;
    private String ldap_domain;
    private String ldap_DN;
    private String ldap_create_user_base_OU;
    private String ldap_so_admin_user;
    private String ldap_so_admin_password;

    private void setup() {
        ldap_hosts = env.getRequiredProperty("ldap.hosts");
        ldap_domain = env.getRequiredProperty("ldap.domain");
        ldap_DN = env.getRequiredProperty("ldap.DN");
        ldap_create_user_base_OU = env.getRequiredProperty("ldap.create.user.base.OU");
        ldap_so_admin_user = env.getRequiredProperty("ldap.so.admin.user");
        ldap_so_admin_password = env.getRequiredProperty("ldap.so.admin.password");
    }

    private boolean isEnabled() {
        return "S".equals(env.getProperty("ldap.enabled"));
    }

    private LdapContext authenticateUser(String username, String password) throws NamingException {
        if (isEnabled()) {
            setup();
            return getValidContext(username, password);
        }
        return null;
    }

    private SearchControls getSearchControl(String[] returnedAtts) {
        // Create the search controls
        SearchControls searchCtls = new SearchControls();
        searchCtls.setReturningAttributes(returnedAtts);
        // Specify the search scope
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        return searchCtls;
    }

    private Hashtable getUserInfo(String user, LdapContext ctxGC) throws NamingException {
        // Search for objects in the GC using the filter
        String ldapDN = ldap_DN;
        String searchFilter = "(&(objectClass=user)(" + LOGIN + "=" + user + "))";
        String returnedAtts[] = { CN, MAIL, TELEFONE, UNIQUENAME };

        Hashtable<String, Object> atributos = new Hashtable<String, Object>();
        NamingEnumeration answer = ctxGC.search(ldapDN, searchFilter, getSearchControl(returnedAtts));
        while (answer.hasMoreElements()) {
            SearchResult sr = (SearchResult) answer.next();
            atributos = extraiInformacoes((SearchResult) answer.next(), returnedAtts);
        }
        return atributos;
    }

    private List getUsers(LdapContext ctxGC) throws NamingException {
        String ldapDN = ldap_DN;
        String searchFilter = "(&(objectClass=user))";
        String returnedAtts[] = { CN, MAIL, TELEFONE, "sAMAccountName" };

        List<Hashtable> resultado = new ArrayList<>();
        NamingEnumeration answer = ctxGC.search(ldapDN, searchFilter, getSearchControl(returnedAtts));
        while (answer.hasMoreElements()) {
            resultado.add(extraiInformacoes((SearchResult) answer.next(), returnedAtts));
        }
        return resultado;
    }

    private Hashtable<String, Object> extraiInformacoes(SearchResult sr, String[] returnedAtts) throws NamingException {
        Hashtable<String, Object> atributos = new Hashtable<>();
        Attributes attrs = sr.getAttributes();
        for (int i = 0; i < returnedAtts.length; i++) {
            Attribute atributo = attrs.get(returnedAtts[i]);
            if (atributo != null) {
                atributos.put(returnedAtts[i], (String) atributo.get());
            }
        }
        return atributos;
    }

    /**
     * Criar contexto com usuario administrador, caso contrario nao serah possivel
     * criar usuario/senha O endereco sargento.puro.uff tambem deve ser utilizado
     * para a conexao SSL
     *
     * @param ctxGC
     * @throws NamingException
     */
    private void createUser(LdapContext ctxGC, Usuario usuario) throws Exception {
    }

    // "CN=" + usuario.getLogin() + /*"," + ldapBaseOU + */ "," + ldapDN;
    private String uniqueLdapUserName(String login, String ldapBaseOU, String ldapDN) {
        return "CN=" + login + (ldapBaseOU == null || ldapBaseOU.trim().isEmpty() ? "" : "," + ldapBaseOU) + ","
                + ldapDN;
    }

    private void modifyUser(LdapContext ctxGC, Usuario usuario) throws Exception {
    }

    // @SuppressWarnings("unchecked")
    private Hashtable setEnv(String username, String password) {

        String ldapHosts = ldap_hosts;
        String ldapDomain = ldap_domain;
        String adminName = ldap_so_admin_user;
        String adminPassword = ldap_so_admin_password;

        Hashtable<String, String> environment = new Hashtable<>();

        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, ldapHosts);
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, username + "@" + ldapDomain);
        environment.put(Context.SECURITY_CREDENTIALS, password);

        return environment;
    }

    /**
     * Faz login. Cria um LdapContext
     *
     * @param username
     * @param password
     * @return
     * @throws NamingException
     */
    private LdapContext getValidContext(String username, String password) throws NamingException {
        return new InitialLdapContext(setEnv(username, password), null);
    }
}