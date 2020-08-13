package br.uff.ihs.ss.service;

import br.uff.ihs.ss.model.Usuario;

public interface UsuarioService extends CrudService<Usuario> {
    public Usuario findByLogin(String login);
}