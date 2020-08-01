package br.uff.ihs.ss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.VeiculoDto;
import br.uff.ihs.ss.model.Veiculo;

@RestController
@RequestMapping(VeiculoController.ENDPOINT)
public class VeiculoController extends BaseCrudController<Veiculo, VeiculoDto> {

    public static final String ENDPOINT = "/api/veiculo";

    @Override
    protected Class<VeiculoDto> getDtoClass() {
        return VeiculoDto.class;
    }

    @Override
    protected Class<Veiculo> getModelClass() {
        return Veiculo.class;
    }

}