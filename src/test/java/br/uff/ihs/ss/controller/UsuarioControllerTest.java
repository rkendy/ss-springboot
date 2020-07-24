package br.uff.ihs.ss.controller;

import java.util.List;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;

public class UsuarioControllerTest extends CrudControllerTest<Usuario, UsuarioDto> {

    @InjectMocks
    UsuarioController usuarioController;

    @Override
    public String getEndPoint() {
        return UsuarioController.ENDPOINT;
    }

    @Override
    public BaseCrudController<Usuario, UsuarioDto> getController() {
        return usuarioController;
    }

    @Override
    public List<Usuario> createList() {
        return List.of( //
        Usuario.builder().login("login01").nome("Nome01").email("email01@email.com").build(),
        Usuario.builder().login("login02").nome("Nome02").email("email01@email.com").build());
    }

    @Override
    public Usuario createOne() {
        return Usuario.builder().login("login").nome("nome").email("email@email.com").build();
    }

}