package br.uff.ihs.ss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.$Model$Dto;
import br.uff.ihs.ss.model.$Model$;

@RestController
@RequestMapping($Model$Controller.ENDPOINT)
public class $Model$Controller extends BaseCrudController<$Model$, $Model$Dto> {

    public static final String ENDPOINT = "/api/$model$";

    @Override
    protected Class<$Model$Dto> getDtoClass() {
        return $Model$Dto.class;
    }

    @Override
    protected Class<$Model$> getModelClass() {
        return $Model$.class;
    }

}