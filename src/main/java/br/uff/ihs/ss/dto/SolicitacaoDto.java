package br.uff.ihs.ss.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SolicitacaoDto {
    private Long id;

    @NotBlank(message = "Titulo is mandatory")
    private String titulo;
    @NotBlank(message = "Descrição is mandatory")
    private String descricao;

    private Date criacao;
}