package br.uff.ihs.ss.controller;

import java.util.List;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.helper.SetorTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Setor;

public class SetorControllerTest extends CrudControllerTest<Setor, SetorDto> {

    @InjectMocks
    SetorController setorController;

    private TestHelper<Setor> helper = new SetorTestHelper();

    @Override
    public String getEndPoint() {
        return SetorController.ENDPOINT;
    }

    @Override
    public BaseCrudController<Setor, SetorDto> getController() {
        return setorController;
    }

    @Override
    public TestHelper<Setor> getTestHelperImpl() {
        return helper;
    }

}