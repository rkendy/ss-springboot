package br.uff.ihs.ss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Setor>> getAllSetor() {
        return ResponseEntity.ok(setorService.getAll());
    }

    @GetMapping(ENDPOINT_ID)
    public ResponseEntity<Setor> getSetor(@PathVariable Long id) {
        return ResponseEntity.ok(setorService.getById(id));
    }

}