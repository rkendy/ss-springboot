package br.uff.ihs.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.UsuarioService;

@RestController
@RequestMapping(UsuarioController.ENDPOINT)
public class UsuarioController extends BaseCrudController<Usuario, UsuarioDto> {

    public static final String ENDPOINT = "/api/usuario";

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Override
    protected Class<UsuarioDto> getDtoClass() {
        return UsuarioDto.class;
    }

    @Override
    protected Class<Usuario> getModelClass() {
        return Usuario.class;
    }

}