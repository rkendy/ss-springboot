package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.repository.CrudRepository;

import br.uff.ihs.ss.helper.$Model$TestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.$Model$;
import br.uff.ihs.ss.repository.$Model$Repository;
import br.uff.ihs.ss.service.impl.$Model$ServiceImpl;

public class $Model$ServiceTest extends CrudServiceTest<$Model$> {

    @InjectMocks
    private $Model$ServiceImpl $model$Service;

    @Mock
    private $Model$Repository repository;

    private TestHelper<$Model$> helper = new $Model$TestHelper();

    @Override
    protected CrudService<$Model$> getServiceImpl() {
        return $model$Service;
    }

    @Override
    protected CrudRepository<$Model$, Long> getRepository() {
        return repository;
    }

    @Override
    protected TestHelper<$Model$> getTestHelperImpl() {
        return helper;
    }

    @Override
    protected void assertAttributes($Model$ expected, $Model$ actual) {
        // assertEquals(expected.getCodigo(), actual.getCodigo());
        // assertEquals(expected.getNome(), actual.getNome());
    }

}