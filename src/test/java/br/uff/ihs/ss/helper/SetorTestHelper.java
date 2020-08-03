package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.util.MapperUtil;
import br.uff.ihs.ss.helper.SetorTestHelper;

@Component
public class SetorTestHelper implements TestHelper<Setor> {

    private Setor createOne(String nome, String codigo) {
        return Setor.builder().nome(nome).codigo(codigo).build();
    }

    @Override
    public Setor createOne() {
        return createOne("Nome Setor", "Codigo Setor");
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
                createOne("Nome1", "Codigo1"), //
                createOne("Nome2", "Codigo2"));
    }

}