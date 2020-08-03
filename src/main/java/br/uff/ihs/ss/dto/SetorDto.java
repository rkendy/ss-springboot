package br.uff.ihs.ss.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SetorDto {
    private Long id;

    @NotBlank(message = "Nome is mandatory")
    private String nome;

    @NotBlank(message = "Codigo is mandatory")
    private String codigo;
    private String email;
    private String lotacao;
    private Boolean ativo;

}