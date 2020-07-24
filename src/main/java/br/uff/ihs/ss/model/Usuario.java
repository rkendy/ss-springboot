package br.uff.ihs.ss.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.util.MapperUtil;
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
public class Usuario implements Serializable, CrudModel<UsuarioDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;
    private String nome;
    private String email;
    private String localizacao;
    private String telefone;
    private String telefone2;
    private String ramal;
    private Boolean ativo;
    private String cpf;
    private String matricula;
    private String resetaSenha;
    private String endereco;
    private String endereco2;
    private Date dataIngresso;
    private String status;
    private String arquivoFoto;
    private Date dataNascimento;
    private Date dataAtualizacao;
    private String lotacao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(name = "setor_usuario", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "setor_id"))
    @OrderBy("nome ASC")
    List<Setor> setores;

    @PrePersist
    void preInsert() {
        if (this.lotacao == null)
            this.lotacao = "01";
        if (this.ativo == null)
            this.ativo = true;
    }

    @Override
    public UsuarioDto toDto() {
        return MapperUtil.convertToDto(this, UsuarioDto.class);
    }

    // @JsonIgnore
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "criador")
    // private List<Solicitacao> solicitacoesCriador;

    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "responsavel")
    // private List<Solicitacao> solicitacoesResponsavel;

    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    // private List<Acompanhamento> acompanhamentos;

    // @OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    // private List<UsuarioInteressado> usuarioInteressados;

    // @OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    // private List<Ferias> ferias;

    // @OneToOne (fetch=FetchType.LAZY, mappedBy="usuario")
    // private Motorista motorista;

    // @ManyToOne
    // private Cargo cargo;

    // @ManyToOne
    // private Funcao funcao;

    // @ManyToOne
    // private Uorg uorg;

}