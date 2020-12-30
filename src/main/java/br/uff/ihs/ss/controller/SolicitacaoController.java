package br.uff.ihs.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.SolicitacaoDto;
import br.uff.ihs.ss.dto.SolicitacaoFilterDto;
import br.uff.ihs.ss.model.Solicitacao;
import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.service.SolicitacaoService;

@RestController
@RequestMapping(SolicitacaoController.ENDPOINT)
public class SolicitacaoController extends BaseCrudController<Solicitacao, SolicitacaoDto> {

    public static final String ENDPOINT = "/api/solicitacao";

    private SolicitacaoService service;

    @Autowired
    public SolicitacaoController(SolicitacaoService service) {
        this.service = service;
    }

    @Override
    public CrudService<Solicitacao> getService() {
        return service;
    }

    @Override
    protected Class<SolicitacaoDto> getDtoClass() {
        return SolicitacaoDto.class;
    }

    @Override
    protected Class<Solicitacao> getModelClass() {
        return Solicitacao.class;
    }

    public ResponseEntity<SolicitacaoDto> getByFilter(@ModelAttribute SolicitacaoFilterDto filtro) {
        Pageable paging = PageRequest.of(0, 1);
        // Page<Solicitacao> result = service.f
        // service.
        return null;
    }

}