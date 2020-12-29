package br.uff.ihs.ss.repository;

import org.springframework.data.jpa.domain.Specification;

import br.uff.ihs.ss.model.Solicitacao;

public class SolicitacaoSpecification {

    public static Specification<Solicitacao> likeTitulo(String titulo) {
        return likeSpecification("titulo", titulo);
    }

    public static Specification<Solicitacao> likeDescricao(String descricao) {
        return likeSpecification("descricao", descricao);
    }

    public static Specification<Solicitacao> equalSetor(Integer setorId) {
        return equalSpecification("setor", setorId);
    }

    public static Specification<Solicitacao> equalStatus(Integer statusId) {
        return equalSpecification("status", statusId);
    }

    public static Specification<Solicitacao> equalCriador(Integer usuarioId) {
        return equalSpecification("criador", usuarioId);
    }

    public static Specification<Solicitacao> equalResponsavel(Integer usuarioId) {
        return equalSpecification("responsavel", usuarioId);
    }

    private static Specification<Solicitacao> likeSpecification(String column, String value) {
        if (value == null)
            return null;
        return (root, query, cb) -> {
            return cb.like(root.get(column), "%" + value + "%");
        };
    }

    private static Specification<Solicitacao> equalSpecification(String column, Object value) {
        if (value == null)
            return null;
        return (root, query, cb) -> {
            return cb.equal(root.get(column), value);
        };
    }

}
