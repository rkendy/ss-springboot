package br.uff.ihs.ss.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitacao")
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDateTime criacao;

    @OneToOne
    private Usuario criador;

    @OneToOne
    private Usuario responsavel;

    @OneToOne
    private Setor setor;

    @OneToOne
    private Status status;

    @PrePersist
    void preInsert() {
        // Include default values:
        // if (this.ativo == null)
        // this.ativo = true;
    }

}