package br.uff.ihs.ss.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;

    @NotBlank(message = "Login obrigatório")
    private String login;
    @NotBlank(message = "Nome obrigatório")
    private String nome;
    @NotBlank(message = "Email obrigatório")
    private String email;
    private String lotacao;
    private String localizacao;

}