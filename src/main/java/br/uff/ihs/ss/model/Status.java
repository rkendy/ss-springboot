package br.uff.ihs.ss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "status")
public class Status implements Serializable {

    private static final long serialVersionUID = -658790695456399059L;

    // Mudanca no Enum deve refletir mudanca na coluna Status.Codigo
    public static enum Codigo {
        CONCLUIDO, ABERTO, CANCELADO, PENDENTE_CLIENTE, EM_EXECUCAO, PENDENTE, EM_ANALISE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private Codigo codigo;

    private String nome;
}