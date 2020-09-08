package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.util.MapperUtil;
import br.uff.ihs.ss.helper.SetorTestHelper;

@Component
public class SetorTestHelper implements TestHelper<Setor> {

    MapperUtil mapperUtil = new MapperUtil();

    private Setor createOne(String a, String b) {
        return Setor.builder().nome(a).codigo(b).build();
    }

    @Override
    public Setor createOne() {
        return createOne("Nome Setor", "Codigo");
    }

    @Override
    public Long getId(Setor model) {
        return model.getId();
    }

    @Override
    public String convertToJson(Setor model) {
        SetorDto dto = mapperUtil.convertToDto(model, SetorDto.class);
        return mapperUtil.convertToJson(dto);
    }

    @Override
    public List<Setor> createList() {
        return List.of( //
                createOne("Nome 1", "Codigo1"), //
                createOne("Nome 2", "Codigo2"));
    }

}