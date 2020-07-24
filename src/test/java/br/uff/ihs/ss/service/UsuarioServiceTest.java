package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.repository.UsuarioRepository;
import br.uff.ihs.ss.service.impl.UsuarioServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    Usuario usuario;

    @BeforeEach
    public void setup() {
        usuario = Usuario.builder().login("login").nome("Nome Usuario").build();
    }

    @Test
    public void givenList_whenFindAll_thenReturnAllElements() {
        List<Usuario> list = createList();
        when(usuarioRepository.findAll()).thenReturn(list);

        Iterable<Usuario> result = usuarioService.findAll();

        assertEquals(list.size(), ((Collection<?>) result).size());

    }

    @Test
    public void givenValidId_whenFindById_thenReturnElement() {

        Optional<Usuario> usuarioOp = Optional.of(usuario);
        when(usuarioRepository.findById(anyLong())).thenReturn(usuarioOp);

        Usuario result = usuarioService.findById(1L);

        assertNotNull(result);
        assertEquals(usuario.getLogin(), result.getLogin());
        assertEquals(usuario.getNome(), result.getNome());

    }

    @Test
    public void givenUsuario_whenCreate_thenCreateSuccess() {

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario result = usuarioService.create(usuario);

        assertNotNull(result);
        assertEquals(usuario.getLogin(), result.getLogin());
        assertEquals(usuario.getNome(), result.getNome());
    }

    @Test
    public void givenUsuario_whenUpdate_thenUpdateSuccess() {

        Optional<Usuario> usuarioOp = Optional.of(usuario);
        when(usuarioRepository.findById(anyLong())).thenReturn(usuarioOp);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        usuario.setEmail("email");
        usuario.setAtivo(true);
        usuario.setLotacao("lotacao");
        Usuario result = usuarioService.update(1L, usuario);

        assertNotNull(result);
        assertEquals(usuario.getLogin(), result.getLogin());
        assertEquals(usuario.getNome(), result.getNome());
    }

    @Test
    public void givenId_whenDelete_thenSuccess() {
        Optional<Usuario> UsuarioOp = Optional.of(usuario);
        when(usuarioRepository.findById(anyLong())).thenReturn(UsuarioOp);
        doNothing().when(usuarioRepository).delete(any(Usuario.class));

        usuarioService.delete(1L);

        verify(usuarioRepository, times(1)).findById(anyLong());
        verify(usuarioRepository, times(1)).delete(any(Usuario.class));
    }

    private List<Usuario> createList() {
        return List.of( //
                Usuario.builder().login("login01").nome("Nome01").email("email01@email.com").build(),
                Usuario.builder().login("login02").nome("Nome02").email("email01@email.com").build());
    }
}