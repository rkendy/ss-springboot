package br.uff.ihs.ss.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.helper.UsuarioTestHelper;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.service.UsuarioService;

public class UsuarioControllerTest extends CrudControllerTest<Usuario, UsuarioDto> {

    @InjectMocks
    UsuarioController usuarioController;

    @Mock
    private UsuarioService service;

    private TestHelper<Usuario> helper = new UsuarioTestHelper();

    @Override
    protected CrudService<Usuario> getService() {
        return service;
    }

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
        return helper;
    }

}