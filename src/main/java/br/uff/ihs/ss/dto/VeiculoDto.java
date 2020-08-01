package br.uff.ihs.ss.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class VeiculoDto {
    private Long id;

    // @NotBlank(message = "Name is mandatory")
    // private String nome;

}