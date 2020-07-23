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

public class BaseCrudController<M extends CrudModel<D>, D extends CrudDto<M>> {

    final private String ENDPOINT_ID = "/{id}";

    @Autowired
    private CrudService<M> service;

    public void setService(CrudService<M> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<D>> getAllSetor() {
        List<M> list = service.findAll();
        List<D> listDto = new ArrayList<>();
        list.forEach(e -> {
            listDto.add((D) e.toDto());
        });
        return ResponseEntity.ok(listDto);
    }

    @GetMapping(ENDPOINT_ID)
    public ResponseEntity<D> getSetor(@PathVariable Long id) {
        return ResponseEntity.ok((D) service.findById(id).toDto());
    }

    @PostMapping
    public ResponseEntity<D> createSetor(@RequestBody @Valid D dto) {
        M newSetor = service.create(dto.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(newSetor.toDto());
    }

    @PutMapping(ENDPOINT_ID)
    public ResponseEntity<D> updateSetor(@PathVariable Long id, @RequestBody @Valid D dto) {
        M updatedSetor = service.update(id, dto.toModel());
        return ResponseEntity.ok(updatedSetor.toDto());
    }

    @DeleteMapping(ENDPOINT_ID)
    public void deleteSetor(@PathVariable Long id) {
        service.delete(id);
    }
}