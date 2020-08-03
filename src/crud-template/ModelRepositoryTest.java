package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.uff.ihs.ss.helper.$Model$TestHelper;
import br.uff.ihs.ss.model.$Model$;

public class $Model$RepositoryTest extends CrudRepositoryTest<$Model$Repository, $Model$> {

    private $Model$TestHelper helper = new $Model$TestHelper();

    @Test
    public void givenNew$Model$_whenInsert_thenSuccess() {
        final $Model$ e = helper.createOne();

        final $Model$ created = repository.save(e);

        assertNotNull(created);
        assertNotNull(created.getId());
        // include other asserts:
        // assertEquals(e.get(), created.get());
    }

}