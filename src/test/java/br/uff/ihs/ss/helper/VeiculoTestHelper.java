package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.VeiculoDto;
import br.uff.ihs.ss.model.Veiculo;
import br.uff.ihs.ss.util.MapperUtil;

@Component
public class VeiculoTestHelper implements TestHelper<Veiculo> {

    @Override
    public Veiculo createOne() {
        return Veiculo.builder().build();
    }

    @Override
    public Long getId(Veiculo model) {
        return model.getId();
    }

    @Override
    public String convertToJson(Veiculo model) {
        VeiculoDto dto = MapperUtil.convertToDto(model, VeiculoDto.class);
        return MapperUtil.convertToJson(dto);
    }

    @Override
    public List<Veiculo> createList() {
        return List.of( //
                Veiculo.builder().build(), Veiculo.builder().build());
    }

}