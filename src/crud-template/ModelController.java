package br.uff.ihs.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.dto.$Model$Dto;
import br.uff.ihs.ss.model.$Model$;
import br.uff.ihs.ss.service.$Model$Service;

@RestController
@RequestMapping($Model$Controller.ENDPOINT)
public class $Model$Controller extends BaseCrudController<$Model$, $Model$Dto> {

    public static final String ENDPOINT = "/api/$model$";

    private $Model$Service service;

    @Autowired
    public $Model$Controller($Model$Service service) {
        this.service = service;
    }

    @Override
    protected CrudService<$Model$> getService() {
        return service;
    }

    @Override
    protected Class<$Model$Dto> getDtoClass() {
        return $Model$Dto.class;
    }

    @Override
    protected Class<$Model$> getModelClass() {
        return $Model$.class;
    }

}