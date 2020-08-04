package br.uff.ihs.ss.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SolicitacaoDto {
    private Long id;

    @NotBlank(message = "Titulo obrigatorio")
    private String titulo;
    @NotBlank(message = "Descricao obrigatorio")
    private String descricao;

    private LocalDateTime criacao;

}