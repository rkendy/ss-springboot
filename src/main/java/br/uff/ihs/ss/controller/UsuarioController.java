package br.uff.ihs.ss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;

@RestController
@RequestMapping(UsuarioController.ENDPOINT)
public class UsuarioController extends BaseCrudController<Usuario, UsuarioDto> {

    public static final String ENDPOINT = "/api/usuario";

}