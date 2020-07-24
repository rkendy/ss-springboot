package br.uff.ihs.ss.dto;

import javax.validation.constraints.NotBlank;

import br.uff.ihs.ss.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDto implements CrudDto<Usuario> {
    private Long id;

    @NotBlank(message = "Login is mandatory")
    private String login;
    @NotBlank(message = "Name is mandatory")
    private String nome;
    @NotBlank(message = "Email is mandatory")
    private String email;

    private Boolean ativo;

    @Override
    public Usuario toModel() {
        return Usuario.builder() //
                .id(this.id) //
                .login(this.login) //
                .nome(this.nome) //
                .email(this.email) //
                .ativo(this.ativo) //
                .build();
    }

}