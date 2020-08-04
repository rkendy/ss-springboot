package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.util.MapperUtil;
import br.uff.ihs.ss.helper.SetorTestHelper;

@Component
public class SetorTestHelper implements TestHelper<Setor> {

    private Setor createOne(String a, String b) {
        return Setor.builder().nome(a).codigo(b).build();
    }

    @Override
    public Setor createOne() {
        return createOne("aaa", "bbb");
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
                createOne("aaa1", "bbb1"), //
                createOne("aaa2", "bbb2"));
    }

}