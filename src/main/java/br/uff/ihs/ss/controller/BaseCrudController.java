package br.uff.ihs.ss.controller;

import java.lang.reflect.ParameterizedType;
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
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.CrudDto;
import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.CrudModel;
import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.util.MapperUtil;

public class BaseCrudController<B extends CrudDto, D extends CrudModel> {

    final private String ENDPOINT_ID = "/{id}";

    @Autowired
    private CrudService<B> service;

    public void setService(CrudService<B> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<D>> getAllSetor() {
        List<B> list = service.findAll();
        List<D> listDto = new ArrayList<>(); // = MapperUtil.convertToDtoList(list, dto.getClass().;
        list.forEach(e -> {
            listDto.add((D) e.toDto());
        });
        return ResponseEntity.ok(listDto);

        // return ResponseEntity.ok(MapperUtil.convertToDtoList(list, Setor.class ));
    }

    @GetMapping(ENDPOINT_ID)
    public ResponseEntity<D> getSetor(@PathVariable Long id) {
        return ResponseEntity.ok((D) service.findById(id).toDto());
        // return ResponseEntity.ok(MapperUtil.convertToDto(service.findById(id),
        // SetorDto.class));
        // return ResponseEntity.ok(setorService.getById(id));
    }

    @PostMapping
    public ResponseEntity<D> createSetor(@RequestBody @Valid D setorDto) {
        B newSetor = service.create((B) setorDto.toBean());
        return ResponseEntity.status(HttpStatus.CREATED).body((D) newSetor.toDto());
    }

    @PutMapping(ENDPOINT_ID)
    public ResponseEntity<SetorDto> updateSetor(@PathVariable Long id, @RequestBody @Valid SetorDto setorDto) {
        B updatedSetor = service.update(id, (B) setorDto.toBean());
        return ResponseEntity.ok(MapperUtil.convertToDto(updatedSetor, SetorDto.class));
    }

    @DeleteMapping(ENDPOINT_ID)
    public void deleteSetor(@PathVariable Long id) {
        service.delete(id);
    }
}