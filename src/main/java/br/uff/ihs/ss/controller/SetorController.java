package br.uff.ihs.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.SetorService;

@RestController
@RequestMapping(SetorController.ENDPOINT)
public class SetorController extends BaseCrudController<Setor, SetorDto> {

    public static final String ENDPOINT = "/api/setor";

    @Autowired
    public SetorController(SetorService service) {
        this.service = service;
    }

    @Override
    protected Class<SetorDto> getDtoClass() {
        return SetorDto.class;
    }

    @Override
    protected Class<Setor> getModelClass() {
        return Setor.class;
    }

}