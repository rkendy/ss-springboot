package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.uff.ihs.ss.model.Veiculo;

public class VeiculoRepositoryTest extends CrudRepositoryTest<VeiculoRepository, Veiculo> {

    @Test
    public void givenNewVeiculo_whenInsert_thenSuccess() {
        // final Veiculo s = Veiculo.builder() //
        // .codigo(Veiculo.Codigo.ALMOXARIFADO.name()) //
        // .nome("Almoxarifado") //
        // .ativo(true) //
        // .email("email@email.com").lotacao("01").build();

        // final Veiculo novo = repository.save(s);

        // assertNotNull(novo);
        // assertNotNull(novo.getId());
        // assertEquals(Veiculo.Codigo.ALMOXARIFADO.name(), novo.getCodigo());
        // assertEquals("Almoxarifado", novo.getNome());
        // assertEquals(true, novo.getAtivo());
        // assertEquals("email@email.com", novo.getEmail());
        // assertEquals("01", novo.getLotacao());
    }

}