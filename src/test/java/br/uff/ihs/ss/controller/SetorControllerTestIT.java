package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.impl.SetorServiceImpl;
import br.uff.ihs.ss.util.MapperUtil;

public class SetorControllerTestIT extends CrudControllerTestIT {
    @LocalServerPort
    int port;

    @Autowired
    SetorServiceImpl setorService;

    List<Setor> list;
    Setor setor;
    Setor setorToDelete;
    Setor setorToCreate;

    @BeforeEach
    void setup() {
        list = setorService.findAll();
        setor = list.get(0);
        setorToCreate = Setor.builder().codigo("codigo").nome("nome").build();
    }

    @Override
    public String getEndPoint() {
        return SetorController.ENDPOINT;
    }

    @Override
    public Long getId() {
        return setor.getId();
    }

    @Override
    public String getJsonToCreate() {
        return MapperUtil.convertToJson(setorToCreate);
    }

    @Override
    public String getJsonFromDto() {
        return MapperUtil.convertToJson(setor.toDto());
    }

    @Override
    public void checkCreatedJson(String json) {
        SetorDto expected = setorToCreate.toDto();
        SetorDto returned = MapperUtil.convertFromJson(json, SetorDto.class);
        assertNotNull(returned.getId());
        assertEquals(expected.getCodigo(), returned.getCodigo());
        assertEquals(expected.getNome(), returned.getNome());
        assertEquals(expected.getEmail(), returned.getEmail());
        assertEquals("01", returned.getLotacao());
        assertTrue(returned.getAtivo());
    }

    @Override
    public void createModel() {
        setorToDelete = setorService.create(Setor.builder().codigo("codigox").nome("nomex").build());
    }

    @Override
    public int getCount() {
        return setorService.findAll().size();
    }

    @Override
    public Long getIdToDelete() {
        return setorToDelete.getId();
    }

    @Test
    public void teste() {
        ResponseEntity<String> response = makePostRequest(getJsonFromDto());
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
    }

}