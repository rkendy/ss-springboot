package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.helper.UsuarioTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.impl.UsuarioServiceImpl;

public class UsuarioServiceTest extends CrudServiceTest<Usuario> {

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private TestHelper<Usuario> helper = new UsuarioTestHelper();

    @Override
    protected CrudService<Usuario> getServiceImpl() {
        return usuarioService;
    }

    @Override
    protected TestHelper<Usuario> getTestHelperImpl() {
        return helper;
    }

    @Override
    protected void assertAttributes(Usuario expected, Usuario actual) {
        // assertEquals(expected.getCodigo(), actual.getCodigo());
        // assertEquals(expected.getNome(), actual.getNome());
    }

}