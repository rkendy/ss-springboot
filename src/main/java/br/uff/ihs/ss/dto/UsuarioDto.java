package br.uff.ihs.ss.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;

    // @NotBlank(message = "Name is mandatory")
    // private String nome;

    private String login;
    private String nome;
    private String email;
    private Boolean ativo;

}