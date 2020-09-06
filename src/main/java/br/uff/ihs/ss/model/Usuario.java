package br.uff.ihs.ss.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;
    private String nome;
    private String email;
    private String lotacao;
    private String localizacao;
    private Boolean admin;
    private Boolean ativo;

    @ManyToMany(mappedBy = "usuarios")
    private List<Setor> setores;

    @PrePersist
    void preInsert() {
        if (this.admin == null)
            this.admin = false;
        // Include default values:
        if (this.ativo == null)
            this.ativo = true;
    }

}