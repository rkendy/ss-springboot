package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.uff.ihs.ss.helper.StatusTestHelper;
import br.uff.ihs.ss.model.Status;

public class StatusRepositoryTest extends CrudRepositoryTest<StatusRepository, Status> {

    private StatusTestHelper helper = new StatusTestHelper();

    @Test
    public void givenNewStatus_whenInsert_thenSuccess() {
        final Status e = helper.createOne();

        final Status created = repository.save(e);

        assertNotNull(created);
        assertNotNull(created.getId());
        // include other asserts:
        assertEquals(e.getNome(), created.getNome());
        assertEquals(e.getCodigo(), created.getCodigo());
    }

}