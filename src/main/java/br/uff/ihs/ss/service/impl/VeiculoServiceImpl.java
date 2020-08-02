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

        toUpdate.setPlaca(updated.getPlaca());
        toUpdate.setModelo(updated.getModelo());
        toUpdate.setCapacidade(updated.getCapacidade());
        toUpdate.setLotacao(updated.getLotacao());
        toUpdate.setAtivo(updated.getAtivo());
        toUpdate.setQuilometragem(updated.getQuilometragem());

    }

}