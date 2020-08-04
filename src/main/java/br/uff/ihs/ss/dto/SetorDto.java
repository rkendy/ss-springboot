package br.uff.ihs.ss.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SetorDto {
    private Long id;

    private String nome;
    private String codigo;
    private String email;
    private String lotacao;
    private Boolean ativo;

    // @NotBlank(message = "Name is mandatory")
    // private String nome;

}