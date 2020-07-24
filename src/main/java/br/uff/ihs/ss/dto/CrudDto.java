package br.uff.ihs.ss.dto;

public interface CrudDto<MODEL> {
    public MODEL toModel();
}