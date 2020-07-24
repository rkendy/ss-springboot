package br.uff.ihs.ss.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;

    @NotBlank(message = "Login is mandatory")
    private String login;
    @NotBlank(message = "Name is mandatory")
    private String nome;
    @NotBlank(message = "Email is mandatory")
    private String email;

    private Boolean ativo;

}