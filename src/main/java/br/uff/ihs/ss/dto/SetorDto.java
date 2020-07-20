package br.uff.ihs.ss.dto;

import lombok.Data;

@Data
public class SetorDto {
    private Long id;
    private String nome;
    private String codigo;
    private String email;
    private Boolean ativo;
}