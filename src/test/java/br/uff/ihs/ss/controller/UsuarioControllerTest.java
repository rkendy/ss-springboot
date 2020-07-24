package br.uff.ihs.ss.controller;

import java.util.List;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.helper.UsuarioTestHelper;
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
    public TestHelper<Usuario> getTestHelperImpl() {
        return new UsuarioTestHelper();
    }

}