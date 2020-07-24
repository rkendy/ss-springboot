package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.util.MapperUtil;

@Component
public class SetorTestHelper implements TestHelper<Setor> {

    @Override
    public Setor createOne() {
        return Setor.builder().codigo("codigox").nome("nomex").build();
    }

    @Override
    public Long getId(Setor model) {
        return model.getId();
    }

    @Override
    public String convertToJson(Setor model) {
        SetorDto dto = MapperUtil.convertToDto(model, SetorDto.class);
        return MapperUtil.convertToJson(dto);
    }

    @Override
    public List<Setor> createList() {
        return List.of( //
                Setor.builder().codigo(Setor.Codigo.ALMOXARIFADO.name()).nome("Almoxarifado").build(),
                Setor.builder().codigo(Setor.Codigo.INFORMATICA.name()).nome("Informática").build());
    }

}