package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.SolicitacaoDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.util.MapperUtil;
import br.uff.ihs.ss.helper.SolicitacaoTestHelper;

@Component
public class SolicitacaoTestHelper implements TestHelper<Solicitacao> {

    private Solicitacao createOne(String a, String b) {
        return Solicitacao.builder().titulo(a).descricao(b) //
                .setor(Setor.builder().id(1L).build()) //
                .criador(Usuario.builder().id(1L).build()).build();
    }

    @Override
    public Solicitacao createOne() {
        return createOne("Titulo", "Descricao");
    }

    @Override
    public Long getId(Solicitacao model) {
        return model.getId();
    }

    @Override
    public String convertToJson(Solicitacao model) {
        SolicitacaoDto dto = MapperUtil.convertToDto(model, SolicitacaoDto.class);
        return MapperUtil.convertToJson(dto);
    }

    @Override
    public List<Solicitacao> createList() {
        return List.of( //
                createOne("Titulo 1", "Descricao 1"), //
                createOne("Titulo 2", "Descricao 2"));
    }

}