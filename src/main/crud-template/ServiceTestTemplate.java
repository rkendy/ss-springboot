package br.uff.ihs.ss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.helper.$Model$TestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.$Model$;
import br.uff.ihs.ss.service.impl.$Model$ServiceImpl;

public class $Model$ServiceTest extends CrudServiceTest<$Model$> {

    @InjectMocks
    private $Model$ServiceImpl $Model$Service;

    private TestHelper<$Model$> helper = new $Model$TestHelper();

    @Override
    protected CrudService<$Model$> getServiceImpl() {
        return $Model$Service;
    }

    @Override
    protected TestHelper<$Model$> getTestHelperImpl() {
        return helper;
    }

    @Override
    protected void assertAttributes($Model$ expected, $Model$ actual) {
        assertEquals(expected.getCodigo(), actual.getCodigo());
        assertEquals(expected.getNome(), actual.getNome());
    }

}