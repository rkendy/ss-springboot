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
import br.uff.ihs.ss.service.SetorService;
import br.uff.ihs.ss.util.MapperUtil;

public class SetorControllerTestIT extends CrudControllerTestIT {
    @LocalServerPort
    int port;

    @Autowired
    SetorService setorService;

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

    // @Test
    // public void givenValidSetorId_whenGet_thenReturnSetor() {

    // ResponseEntity<String> response =
    // makeGetRequest(Long.toString(setor.getId()));

    // assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    // assertTrue(response.getBody().contains(setor.getNome()));
    // }

    // @Test
    // public void givenInvalidSetorId_whenGetthenReturnNotFound() {
    // ResponseEntity<String> response = makeGetRequest("123456");
    // assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());
    // }

    // @Test
    // public void givenSetor_whenCreate_thenSuccess() {
    // Setor newSetor = SetorTestHelper.create("Codigo", "Nome Setor");

    // ResponseEntity<String> response =
    // makePostRequest(MapperUtil.convertToJson(newSetor));
    // Setor result = MapperUtil.convertFromJson(response.getBody(), Setor.class);

    // // Check status code:
    // assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());

    // // Check returned values:
    // assertNotNull(result.getId());
    // assertEquals(newSetor.getCodigo(), result.getCodigo());
    // assertEquals(newSetor.getNome(), result.getNome());
    // assertEquals(newSetor.getEmail(), result.getEmail());

    // // Check default values:
    // assertEquals(true, result.getAtivo());
    // assertEquals("01", result.getLotacao());
    // }

    // @Test
    // public void givenValidSetor_whenUpdate_thenReturnSuccess() {
    // SetorDto setorDto = MapperUtil.convertToDto(setor, SetorDto.class);
    // setorDto.setCodigo("NOVOCODIGO");
    // setorDto.setLotacao("06");

    // ResponseEntity<String> response =
    // makePutRequest(MapperUtil.convertToJson(setorDto), "1");
    // Setor result = MapperUtil.convertFromJson(response.getBody(), Setor.class);

    // assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    // assertEquals(setorDto.getCodigo(), result.getCodigo());
    // assertEquals(setorDto.getNome(), result.getNome());
    // assertEquals(setorDto.getEmail(), result.getEmail());
    // assertEquals(setorDto.getLotacao(), result.getLotacao());
    // }

    // @Test
    // public void givenValidId_whenUpdate_thenReturnSuccess() {

    // setorService.create(SetorTestHelper.create("codigo", "nome"));
    // int countBefore = setorService.findAll().size();
    // Long id = setorService.findAll().get(countBefore - 1).getId();

    // ResponseEntity<String> response = makeDeleteRequest(id.toString());

    // int countAfter = setorService.findAll().size();
    // assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    // assertEquals(countBefore, countAfter + 1);
    // }

    // private ResponseEntity<String> makeGetRequest(String id) {
    // HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    // return restTemplate.exchange(createURLWithPort(SetorController.ENDPOINT + "/"
    // + id), HttpMethod.GET, entity,
    // String.class);
    // }

    // private ResponseEntity<String> makePostRequest(String jsonObj) {
    // HttpEntity<String> entity = new HttpEntity<String>(jsonObj, headers);
    // return
    // restTemplate.postForEntity(createURLWithPort(SetorController.ENDPOINT),
    // entity, String.class);
    // }

    // private ResponseEntity<String> makePutRequest(String jsonStr, String id) {
    // HttpEntity<String> entity = new HttpEntity<String>(jsonStr, headers);
    // return restTemplate.exchange(createURLWithPort(SetorController.ENDPOINT + "/"
    // + id), HttpMethod.PUT, entity,
    // String.class);
    // }

    // private ResponseEntity<String> makeDeleteRequest(String id) {
    // HttpEntity<String> entity = new HttpEntity<String>(null, headers);
    // return restTemplate.exchange(createURLWithPort(SetorController.ENDPOINT + "/"
    // + id), HttpMethod.DELETE, entity,
    // String.class);
    // }

    // private String createURLWithPort(String uri) {
    // return "http://localhost:" + port + uri;
    // }

}