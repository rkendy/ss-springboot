package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.uff.ihs.ss.model.Status;

public class StatusRepositoryTest extends RepositoryTest<StatusRepository, Status> {

    @Test
    public void givenNovoStatus_whenInsert_thenSuccess() {
        final Status s = Status.builder() //
                .codigo(Status.Codigo.ABERTO) //
                .nome("Aberto") //
                .build();

        final Status novo = repository.save(s);

        assertNotNull(novo);
        assertNotNull(novo.getId());
        assertEquals(Status.Codigo.ABERTO, novo.getCodigo());
        assertEquals("Aberto", novo.getNome());
    }

}