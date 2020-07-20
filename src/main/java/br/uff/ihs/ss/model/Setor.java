package br.uff.ihs.ss.model;

import java.io.Serializable;

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
@Table(name = "setor")
public class Setor implements Serializable {

    private static final long serialVersionUID = 6523249791587614649L;

    public static enum Codigo {
        INFORMATICA, TRANSPORTE, ALMOXARIFADO, PATRIMONIO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigo;
    private String email;
    private String lotacao;
    private Boolean ativo;

    // @ManyToMany
    // @JoinTable(
    // name = "setor_status",
    // joinColumns = @JoinColumn(name = "setor_id"),
    // inverseJoinColumns = @JoinColumn(name = "status_id")
    // )
    // @JsonIgnore
    // @JsonManagedReference
    // List<Status> status;

    // @ManyToMany(mappedBy = "setores")
    // List<Usuario> usuarios;
}