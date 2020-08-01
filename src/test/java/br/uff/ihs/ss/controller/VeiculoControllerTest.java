package br.uff.ihs.ss.controller;

import java.util.List;

import org.mockito.InjectMocks;

import br.uff.ihs.ss.dto.VeiculoDto;
import br.uff.ihs.ss.helper.VeiculoTestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.Veiculo;

public class VeiculoControllerTest extends CrudControllerTest<Veiculo, VeiculoDto> {

    @InjectMocks
    VeiculoController veiculoController;

    private TestHelper<Veiculo> helper = new VeiculoTestHelper();

    @Override
    public String getEndPoint() {
        return VeiculoController.ENDPOINT;
    }

    @Override
    public BaseCrudController<Veiculo, VeiculoDto> getController() {
        return veiculoController;
    }

    @Override
    public TestHelper<Veiculo> getTestHelperImpl() {
        return helper;
    }

}