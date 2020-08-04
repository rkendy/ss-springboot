package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.helper.UsuarioTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.repository.UsuarioRepository;
import br.uff.ihs.ss.service.impl.UsuarioServiceImpl;

public class UsuarioServiceTest extends CrudServiceTest<Usuario> {

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Mock
    private UsuarioRepository repository;

    private TestHelper<Usuario> helper = new UsuarioTestHelper();

    @Override
    protected CrudService<Usuario> getServiceImpl() {
        return usuarioService;
    }

    @Override
    protected CrudRepository<Usuario, Long> getRepository() {
        return repository;
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