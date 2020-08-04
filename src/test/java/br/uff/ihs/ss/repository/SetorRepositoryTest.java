package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.uff.ihs.ss.helper.SetorTestHelper;
import br.uff.ihs.ss.model.Setor;

public class SetorRepositoryTest extends CrudRepositoryTest<SetorRepository, Setor> {

    private SetorTestHelper helper = new SetorTestHelper();

    @Test
    public void givenNewSetor_whenInsert_thenSuccess() {
        final Setor e = helper.createOne();

        final Setor created = repository.save(e);

        assertNotNull(created);
        assertNotNull(created.getId());
        // include other asserts:
        assertEquals(e.getNome(), created.getNome());
        assertEquals(e.getCodigo(), created.getCodigo());
        assertEquals(e.getEmail(), created.getEmail());
        assertEquals("01", created.getLotacao());
    }

}