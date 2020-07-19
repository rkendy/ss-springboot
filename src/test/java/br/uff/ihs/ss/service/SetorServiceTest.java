package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.uff.ihs.ss.SetorTestHelper;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.repository.SetorRepository;
import br.uff.ihs.ss.service.impl.SetorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SetorServiceTest {

    @Mock
    private SetorRepository setorRepository;

    @InjectMocks
    private SetorServiceImpl setorService;

    @Test
    public void givenList_whenFindAll_thenReturnAllElements() {
        List<Setor> list = SetorTestHelper.createList();

        when(setorRepository.findAll()).thenReturn(list);

        Iterable<Setor> result = setorService.getAll();

        assertEquals(list.size(), ((Collection<?>) result).size());

    }

    @Test
    public void givenValidId_whenFindById_thenReturnElement() {

        Optional<Setor> setor = Optional.of(SetorTestHelper.create(Setor.Codigo.ALMOXARIFADO, "Almoxarifado"));

        when(setorRepository.findById(anyLong())).thenReturn(setor);

        Setor result = setorService.getById(1L);

        assertNotNull(result);
        assertEquals(Setor.Codigo.ALMOXARIFADO, result.getCodigo());
        assertEquals("Almoxarifado", result.getNome());

    }
}