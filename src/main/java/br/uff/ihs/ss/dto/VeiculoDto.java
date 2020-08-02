package br.uff.ihs.ss.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class VeiculoDto {
    private Long id;

    @NotBlank(message = "Placa is mandatory")
    private String placa;
    @NotBlank(message = "Modelo is mandatory")
    private String modelo;
    private Integer capacidade;
    private String lotacao;
    private Boolean ativo;
    private Integer quilometragem;

}