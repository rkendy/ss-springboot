package br.uff.ihs.ss.dto;

import lombok.Data;

@Data
public class SolicitacaoFilterDto {
    private Integer criadorId;
    private Integer responsavelId;
    private Integer statusId;
    private Integer setorId;
    private String titulo;
    private String descricao;
}
