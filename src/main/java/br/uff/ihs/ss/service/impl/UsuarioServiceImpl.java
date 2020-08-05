package br.uff.ihs.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.BaseCrudService;
import br.uff.ihs.ss.service.UsuarioService;
import br.uff.ihs.ss.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends BaseCrudService<Usuario> implements UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
        super.setRepository(repository);
        super.setModelClass(Usuario.class);
    }

    @Override
    protected void updateAttributes(Usuario to, Usuario from) {
        // TODO Auto-generated method stub

    }

}