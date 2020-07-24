package br.uff.ihs.ss.service.impl;

import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.service.CrudService;

@Service
public class UsuarioServiceImpl extends CrudService<Usuario> {

    @Override
    protected Class<?> getModelClass() {
        return Usuario.class;
    }

    @Override
    protected void updateAttributes(Usuario toUpdate, Usuario updated) {
        toUpdate.setAtivo(updated.getAtivo());
        toUpdate.setEmail(updated.getEmail());
        toUpdate.setLotacao(updated.getLotacao());
        toUpdate.setNome(updated.getNome());
    }

}