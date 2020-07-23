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

import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.repository.SetorRepository;
import br.uff.ihs.ss.service.impl.SetorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SetorServiceTest {

    @Mock
    private SetorRepository setorRepository;

    @InjectMocks
    private SetorServiceImpl setorService;

    Setor setor;

    @BeforeEach
    public void setup() {
        setor = Setor.builder().codigo("CODIGOX").nome("Nome Setor").build();
    }

    @Test
    public void givenList_whenFindAll_thenReturnAllElements() {
        List<Setor> list = createList();
        when(setorRepository.findAll()).thenReturn(list);

        Iterable<Setor> result = setorService.findAll();

        assertEquals(list.size(), ((Collection<?>) result).size());

    }

    @Test
    public void givenValidId_whenFindById_thenReturnElement() {

        Optional<Setor> setorOp = Optional.of(setor);
        when(setorRepository.findById(anyLong())).thenReturn(setorOp);

        Setor result = setorService.findById(1L);

        assertNotNull(result);
        assertEquals(setor.getCodigo(), result.getCodigo());
        assertEquals(setor.getNome(), result.getNome());

    }

    @Test
    public void givenSetor_whenCreate_thenCreateSuccess() {

        when(setorRepository.save(any(Setor.class))).thenReturn(setor);

        Setor result = setorService.create(setor);

        assertNotNull(result);
        assertEquals(setor.getCodigo(), result.getCodigo());
        assertEquals(setor.getNome(), result.getNome());
    }

    @Test
    public void givenSetor_whenUpdate_thenUpdateSuccess() {

        Optional<Setor> setorOp = Optional.of(setor);
        when(setorRepository.findById(anyLong())).thenReturn(setorOp);
        when(setorRepository.save(any(Setor.class))).thenReturn(setor);

        setor.setEmail("email");
        setor.setAtivo(true);
        setor.setLotacao("lotacao");
        Setor result = setorService.update(1L, setor);

        assertNotNull(result);
        assertEquals(setor.getCodigo(), result.getCodigo());
        assertEquals(setor.getNome(), result.getNome());
    }

    @Test
    public void givenId_whenDelete_thenSuccess() {
        Optional<Setor> setorOp = Optional.of(setor);
        when(setorRepository.findById(anyLong())).thenReturn(setorOp);
        doNothing().when(setorRepository).delete(any(Setor.class));

        setorService.delete(1L);

        verify(setorRepository, times(1)).findById(anyLong());
        verify(setorRepository, times(1)).delete(any(Setor.class));
    }

    private List<Setor> createList() {
        return List.of( //
                Setor.builder().codigo(Setor.Codigo.ALMOXARIFADO.name()).nome("Almoxarifado").build(),
                Setor.builder().codigo(Setor.Codigo.INFORMATICA.name()).nome("Informática").build());
    }
}