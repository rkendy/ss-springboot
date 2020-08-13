package br.uff.ihs.ss.service;

public interface LdapService {
    public boolean authenticate(final String login, final String password) throws Exception;
}