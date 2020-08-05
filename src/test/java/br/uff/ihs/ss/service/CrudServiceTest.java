package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.exception.NotFoundException;
import br.uff.ihs.ss.helper.TestHelper;

@ExtendWith(MockitoExtension.class)
public abstract class CrudServiceTest<MODEL> {

    private CrudRepository<MODEL, Long> repository;
    private TestHelper<MODEL> helper;
    private CrudService<MODEL> service;
    private MODEL expected;

    abstract protected CrudService<MODEL> getServiceImpl();

    abstract protected CrudRepository<MODEL, Long> getRepository();

    abstract protected void assertAttributes(MODEL expected, MODEL actual);

    abstract protected TestHelper<MODEL> getTestHelperImpl();

    @BeforeEach
    void setup() {
        service = getServiceImpl();
        repository = getRepository();
        helper = getTestHelperImpl();
        expected = helper.createOne();
    }

    @Test
    public void givenList_whenFindAll_thenReturnAllElements() {
        List<MODEL> list = helper.createList();
        when(repository.findAll()).thenReturn(list);

        Iterable<MODEL> result = service.findAll();

        assertEquals(list.size(), ((Collection<?>) result).size());
    }

    @Test
    public void givenValidId_whenFindById_thenReturnElement() {

        Optional<MODEL> modelOp = Optional.of(expected);
        when(repository.findById(anyLong())).thenReturn(modelOp);

        MODEL actual = service.findById(1L);

        assertNotNull(actual);
        assertAttributes(expected, actual);
    }

    @Test
    public void givenModel_whenCreate_thenCreateSuccess() {

        when(repository.save(any())).thenReturn(expected);

        MODEL actual = service.create(expected);

        assertNotNull(actual);
        assertAttributes(expected, actual);
    }

    @Test
    public void givenModel_whenUpdate_thenUpdateSuccess() {

        Optional<MODEL> expectedOp = Optional.of(expected);

        when(repository.findById(anyLong())).thenReturn(expectedOp);
        when(repository.save(any())).thenReturn(expected);

        MODEL actual = service.update(1L, expected);

        assertNotNull(actual);
        assertAttributes(expected, actual);
    }

    @Test
    public void givenId_whenDelete_thenSuccess() {
        Optional<MODEL> expectedOp = Optional.of(expected);
        when(repository.findById(anyLong())).thenReturn(expectedOp);
        doNothing().when(repository).delete(any());

        service.delete(1L);

        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).delete(any());
    }

    @Test
    void givenInvalidId_whenFindById_thenReturnNotFound() throws Exception {
        when(repository.findById(anyLong())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> service.findById(1L));
    }

    @Test
    void givenInvalidId_whenUpdate_thenReturnNotFound() throws Exception {
        when(repository.findById(anyLong())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> service.update(1L, any()));
    }

    @Test
    void givenInvalidId_whenDelete_thenReturnNotFound() throws Exception {
        when(repository.findById(anyLong())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> service.delete(1L));
    }

}