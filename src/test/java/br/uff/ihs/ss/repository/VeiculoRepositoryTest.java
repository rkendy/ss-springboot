package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.uff.ihs.ss.helper.VeiculoTestHelper;
import br.uff.ihs.ss.model.Veiculo;

public class VeiculoRepositoryTest extends CrudRepositoryTest<VeiculoRepository, Veiculo> {

    VeiculoTestHelper helper = new VeiculoTestHelper();

    @Test
    public void givenNewVeiculo_whenInsert_thenSuccess() {

        final Veiculo s = helper.createOne();

        final Veiculo novo = repository.save(s);

        assertNotNull(novo);
        assertNotNull(novo.getId());
        assertEquals(s.getModelo(), novo.getModelo());
        assertEquals(s.getPlaca(), novo.getPlaca());
        assertEquals(s.getCapacidade(), novo.getCapacidade());
        assertEquals(true, novo.getAtivo());
        assertEquals("01", novo.getLotacao());
    }

}