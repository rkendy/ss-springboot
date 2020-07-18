package br.uff.ihs.ss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.uff.ihs.ss.model.Setor;

public class SetorRepositoryTest extends RepositoryTest<SetorRepository, Setor> {

    @Test
    public void givenNovoSetor_whenInsert_thenSuccess() {
        final Setor s = Setor.builder() //
                .codigo(Setor.Codigo.ALMOXARIFADO) //
                .nome("Almoxarifado") //
                .ativo(true) //
                .email("email@email.com").lotacao("01").build();

        final Setor novo = repository.save(s);

        assertNotNull(novo);
        assertNotNull(novo.getId());
        assertEquals(Setor.Codigo.ALMOXARIFADO, novo.getCodigo());
        assertEquals("Almoxarifado", novo.getNome());
        assertEquals(true, novo.getAtivo());
        assertEquals("email@email.com", novo.getEmail());
        assertEquals("01", novo.getLotacao());
    }

}