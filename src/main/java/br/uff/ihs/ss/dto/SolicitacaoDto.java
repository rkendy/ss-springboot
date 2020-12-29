package br.uff.ihs.ss.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Data;

@Data
public class SolicitacaoDto {
    private Long id;

    @NotBlank(message = "Titulo obrigatorio")
    private String titulo;
    @NotBlank(message = "Descricao obrigatorio")
    private String descricao;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime criacao;

    private UsuarioDto criador;
    private UsuarioDto responsavel;

    private SetorDto setor;
    private StatusDto status;

}