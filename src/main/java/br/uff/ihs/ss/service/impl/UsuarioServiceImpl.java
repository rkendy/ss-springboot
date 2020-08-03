package br.uff.ihs.ss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.service.UsuarioService;
import br.uff.ihs.ss.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends CrudService<Usuario> implements UsuarioService {

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Class<?> getModelClass() {
        return Usuario.class;
    }

    @Override
    protected void updateAttributes(Usuario toUpdate, Usuario updated) {
        // toUpdate.setAtivo(updated.getAtivo());
        // toUpdate.setCodigo(updated.getCodigo());
        // toUpdate.setEmail(updated.getEmail());
        // toUpdate.setLotacao(updated.getLotacao());
        // toUpdate.setNome(updated.getNome());
    }

}