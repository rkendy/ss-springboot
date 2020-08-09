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
    protected void updateCrudAttributes(Usuario to, Usuario from) {
        to.setEmail(from.getEmail());
        to.setLocalizacao(from.getLocalizacao());
        to.setLotacao(from.getLotacao());
        to.setNome(from.getNome());

    }

}