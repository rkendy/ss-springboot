package br.uff.ihs.ss.controller;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.dto.$Model$Dto;
import br.uff.ihs.ss.helper.$Model$TestHelper;
import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.model.$Model$;
import br.uff.ihs.ss.service.$Model$Service;

public class $Model$ControllerTest extends CrudControllerTest<$Model$, $Model$Dto> {

    @InjectMocks
    $Model$Controller $model$Controller;

    @Mock
    private $Model$Service service;

    @Override
    protected CrudService<$Model$> getService() {
        return service;
    }

    private TestHelper<$Model$> helper = new $Model$TestHelper();

    @Override
    public String getEndPoint() {
        return $Model$Controller.ENDPOINT;
    }

    @Override
    public BaseCrudController<$Model$, $Model$Dto> getController() {
        return $model$Controller;
    }

    @Override
    public TestHelper<$Model$> getTestHelperImpl() {
        return helper;
    }

}