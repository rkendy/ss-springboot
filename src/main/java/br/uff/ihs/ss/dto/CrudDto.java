package br.uff.ihs.ss.dto;

public interface CrudDto<M> {
    public M toModel();
}