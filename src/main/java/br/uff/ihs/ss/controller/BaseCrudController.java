package br.uff.ihs.ss.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.util.MapperUtil;

public abstract class BaseCrudController<MODEL, DTO> {

    final public String ENDPOINT_ID = "/{id}";

    // protected CrudService<MODEL> service;

    protected abstract Class<MODEL> getModelClass();

    protected abstract Class<DTO> getDtoClass();

    protected abstract CrudService<MODEL> getService();

    @Autowired
    private MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<DTO>> findAll() {
        List<MODEL> list = getService().findAll();
        List<DTO> listDto = new ArrayList<>();
        list.forEach(e -> {
            listDto.add(mapperUtil.convertToDto(e, getDtoClass()));
        });
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(ENDPOINT_ID)
    public ResponseEntity<DTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok( //
                mapperUtil.convertToDto( //
                        getService().findById(id), getDtoClass()));
    }

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody @Valid DTO dto) {
        MODEL created = getService().create(mapperUtil.convertToEntity(dto, getModelClass()));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapperUtil.convertToDto(created, getDtoClass()));
    }

    @PutMapping(ENDPOINT_ID)
    public ResponseEntity<DTO> update(@PathVariable Long id, @RequestBody @Valid DTO dto) {
        MODEL updated = getService().update(id, mapperUtil.convertToEntity(dto, getModelClass()));
        return ResponseEntity.ok( //
                mapperUtil.convertToDto(updated, getDtoClass()));
    }

    @DeleteMapping(ENDPOINT_ID)
    public void delete(@PathVariable Long id) {
        getService().delete(id);
    }

}