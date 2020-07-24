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

import br.uff.ihs.ss.dto.CrudDto;
import br.uff.ihs.ss.model.CrudModel;
import br.uff.ihs.ss.service.CrudService;

public class BaseCrudController<MODEL extends CrudModel<DTO>, DTO extends CrudDto<MODEL>> {

    final public String ENDPOINT_ID = "/{id}";

    @Autowired
    private CrudService<MODEL> service;

    @GetMapping
    public ResponseEntity<List<DTO>> findAll() {
        List<MODEL> list = service.findAll();
        List<DTO> listDto = new ArrayList<>();
        list.forEach(e -> {
            listDto.add(e.toDto());
        });
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(ENDPOINT_ID)
    public ResponseEntity<DTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok((DTO) service.findById(id).toDto());
    }

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody @Valid DTO dto) {
        MODEL created = service.create(dto.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(created.toDto());
    }

    @PutMapping(ENDPOINT_ID)
    public ResponseEntity<DTO> update(@PathVariable Long id, @RequestBody @Valid DTO dto) {
        MODEL updated = service.update(id, dto.toModel());
        return ResponseEntity.ok(updated.toDto());
    }

    @DeleteMapping(ENDPOINT_ID)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}