package br.uff.ihs.ss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.SolicitacaoDto;
import br.uff.ihs.ss.model.Solicitacao;

@RestController
@RequestMapping(SolicitacaoController.ENDPOINT)
public class SolicitacaoController extends BaseCrudController<Solicitacao, SolicitacaoDto> {

    public static final String ENDPOINT = "/api/solicitacao";

    @Override
    protected Class<SolicitacaoDto> getDtoClass() {
        return SolicitacaoDto.class;
    }

    @Override
    protected Class<Solicitacao> getModelClass() {
        return Solicitacao.class;
    }

}