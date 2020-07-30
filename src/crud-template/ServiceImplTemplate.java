package br.uff.ihs.ss.service.impl;

import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.$Model$;
import br.uff.ihs.ss.service.CrudService;

@Service
public class $Model$ServiceImpl extends CrudService<$Model$> {

    @Override
    protected Class<?> getModelClass() {
        return $Model$.class;
    }

    @Override
    protected void updateAttributes($Model$ toUpdate, $Model$ updated) {
        // toUpdate.setAtivo(updated.getAtivo());
        // toUpdate.setCodigo(updated.getCodigo());
        // toUpdate.setEmail(updated.getEmail());
        // toUpdate.setLotacao(updated.getLotacao());
        // toUpdate.setNome(updated.getNome());
    }

}