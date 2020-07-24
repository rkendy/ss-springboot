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

    @Autowired
    private CrudService<MODEL> service;

    abstract protected Class<MODEL> getModelClass();

    abstract protected Class<DTO> getDtoClass();

    @GetMapping
    public ResponseEntity<List<DTO>> findAll() {
        List<MODEL> list = service.findAll();
        List<DTO> listDto = new ArrayList<>();
        list.forEach(e -> {
            listDto.add(MapperUtil.convertToDto(e, getDtoClass()));
        });
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(ENDPOINT_ID)
    public ResponseEntity<DTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok( //
                MapperUtil.convertToDto( //
                        service.findById(id), getDtoClass()));
    }

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody @Valid DTO dto) {
        MODEL created = service.create(MapperUtil.convertToEntity(dto, getModelClass()));
        return ResponseEntity.status(HttpStatus.CREATED).body(MapperUtil.convertToDto(created, getDtoClass()));
    }

    @PutMapping(ENDPOINT_ID)
    public ResponseEntity<DTO> update(@PathVariable Long id, @RequestBody @Valid DTO dto) {
        MODEL updated = service.update(id, MapperUtil.convertToEntity(dto, getModelClass()));
        return ResponseEntity.ok( //
                MapperUtil.convertToDto(updated, getDtoClass()));
    }

    @DeleteMapping(ENDPOINT_ID)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}