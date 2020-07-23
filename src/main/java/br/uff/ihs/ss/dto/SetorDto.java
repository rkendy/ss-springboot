package br.uff.ihs.ss.dto;

import javax.validation.constraints.NotBlank;

import br.uff.ihs.ss.model.CrudModel;
import br.uff.ihs.ss.model.Setor;
import lombok.Data;

@Data
public class SetorDto implements CrudDto<Setor> {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String nome;
    @NotBlank(message = "Codigo is mandatory")
    private String codigo;
    private String email;
    private String lotacao;
    private Boolean ativo;

    @Override
    public Setor toModel() {
        return Setor.builder() //
                .id(this.id) //
                .nome(this.nome) //
                .codigo(this.codigo) //
                .email(this.email) //
                .lotacao(this.lotacao) //
                .ativo(this.ativo) //
                .build();
    }

}