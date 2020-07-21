package br.uff.ihs.ss.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.SetorService;
import br.uff.ihs.ss.util.MapperUtil;

@RestController
// @RequestMapping(value = SetorController.ENDPOINT, consumes =
// "application/json", produces = "application/json")
@RequestMapping(SetorController.ENDPOINT)
public class SetorController {

    public static final String ENDPOINT = "/api/setor";
    public static final String ENDPOINT_ID = "/{id}";

    @Autowired
    private SetorService setorService;

    @GetMapping
    public ResponseEntity<List<SetorDto>> getAllSetor() {
        return ResponseEntity.ok(MapperUtil.convertToDtoList(setorService.getAll(), SetorDto.class));
    }

    @GetMapping(ENDPOINT_ID)
    public ResponseEntity<SetorDto> getSetor(@PathVariable Long id) {
        return ResponseEntity.ok(MapperUtil.convertToDto(setorService.getById(id), SetorDto.class));
        // return ResponseEntity.ok(setorService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SetorDto> createSetor(@RequestBody @Valid SetorDto setorDto) {
        Setor newSetor = setorService.create(MapperUtil.convertToEntity(setorDto, Setor.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(MapperUtil.convertToDto(newSetor, SetorDto.class));
    }

    @PutMapping(ENDPOINT_ID)
    public ResponseEntity<SetorDto> updateSetor(@PathVariable Long id, @RequestBody @Valid SetorDto setorDto) {
        Setor updatedSetor = setorService.update(id, MapperUtil.convertToEntity(setorDto, Setor.class));
        return ResponseEntity.ok(MapperUtil.convertToDto(updatedSetor, SetorDto.class));
    }

}