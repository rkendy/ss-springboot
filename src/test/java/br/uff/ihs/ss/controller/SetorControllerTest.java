package br.uff.ihs.ss.controller;

import java.util.List;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;

public class SetorControllerTest extends CrudControllerTest<Setor, SetorDto> {

    @InjectMocks
    SetorController setorController;

    @Override
    public String getEndPoint() {
        return SetorController.ENDPOINT;
    }

    @Override
    public BaseCrudController<Setor, SetorDto> getController() {
        return setorController;
    }

    @Override
    public List<Setor> createList() {
        return List.of( //
                Setor.builder().codigo(Setor.Codigo.ALMOXARIFADO.name()).nome("Almoxarifado").build(),
                Setor.builder().codigo(Setor.Codigo.INFORMATICA.name()).nome("Informática").build());
    }

    @Override
    public Setor createOne() {
        return Setor.builder().codigo("codigo").nome("nome").build();
    }

}