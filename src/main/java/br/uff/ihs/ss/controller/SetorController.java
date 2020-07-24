package br.uff.ihs.ss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;

@RestController
@RequestMapping(SetorController.ENDPOINT)
public class SetorController extends BaseCrudController<Setor, SetorDto> {

    public static final String ENDPOINT = "/api/setor";

    @Override
    protected Class<SetorDto> getDtoClass() {
        return SetorDto.class;
    }

    @Override
    protected Class<Setor> getModelClass() {
        return Setor.class;
    }

}