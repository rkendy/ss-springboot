package br.uff.ihs.ss.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.helper.SetorTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.service.SetorService;

public class SetorControllerTest extends CrudControllerTest<Setor, SetorDto> {

    @InjectMocks
    SetorController setorController;

    @Mock
    private SetorService service;

    private TestHelper<Setor> helper = new SetorTestHelper();

    @Override
    protected CrudService<Setor> getService() {
        return service;
    }

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