package br.uff.ihs.ss.service.impl;

import org.springframework.stereotype.Service;

import br.uff.ihs.ss.model.Veiculo;
import br.uff.ihs.ss.service.CrudService;

@Service
public class VeiculoServiceImpl extends CrudService<Veiculo> {

    @Override
    protected Class<?> getModelClass() {
        return Veiculo.class;
    }

    @Override
    protected void updateAttributes(Veiculo toUpdate, Veiculo updated) {
        // toUpdate.setAtivo(updated.getAtivo());
        // toUpdate.setCodigo(updated.getCodigo());
        // toUpdate.setEmail(updated.getEmail());
        // toUpdate.setLotacao(updated.getLotacao());
        // toUpdate.setNome(updated.getNome());
    }

}