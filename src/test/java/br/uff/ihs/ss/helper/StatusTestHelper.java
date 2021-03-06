package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.StatusDto;
import br.uff.ihs.ss.model.Status;
import br.uff.ihs.ss.model.StatusCodigo;

@Component
public class StatusTestHelper implements TestHelper<Status> {

    private Status createOne(String nome, StatusCodigo codigo) {
        return Status.builder().nome(nome).codigo(codigo).build();
    }

    @Override
    public Status createOne() {
        return createOne("Nome Status", StatusCodigo.EM_ANALISE);
    }

    @Override
    public Long getId(Status model) {
        return model.getId();
    }

    @Override
    public String convertToJson(Status model) {
        StatusDto dto = mapperUtil.convertToDto(model, StatusDto.class);
        return mapperUtil.convertToJson(dto);
    }

    @Override
    public List<Status> createList() {
        return List.of( //
                createOne("Nome1", StatusCodigo.EM_ANALISE), //
                createOne("Nome2", StatusCodigo.CANCELADO));
    }

}