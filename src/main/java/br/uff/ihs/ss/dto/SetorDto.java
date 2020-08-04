package br.uff.ihs.ss.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SetorDto {
    private Long id;

    @NotBlank(message = "Nome obrigatorio")
    private String nome;
    @NotBlank(message = "Codigo obrigatorio")
    private String codigo;
    private String email;
    private String lotacao;
    private Boolean ativo;

    // private String nome;

}