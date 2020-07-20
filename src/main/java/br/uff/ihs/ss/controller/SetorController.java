package br.uff.ihs.ss.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.ihs.ss.util.MapperUtil;
import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.SetorService;

@RestController
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

}