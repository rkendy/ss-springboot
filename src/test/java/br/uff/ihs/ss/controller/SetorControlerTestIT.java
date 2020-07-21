package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.uff.ihs.ss.SetorTestHelper;
import br.uff.ihs.ss.dto.SetorDto;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.SetorService;
import br.uff.ihs.ss.util.MapperUtil;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SetorControlerTestIT {
    @LocalServerPort
    int port;

    @Autowired
    SetorService setorService;

    List<Setor> list;
    Setor setor;

    static HttpHeaders headers = new HttpHeaders();
    static TestRestTemplate restTemplate = new TestRestTemplate();

    @BeforeAll
    static void setupAll() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @BeforeEach
    void setup() {
        list = setorService.getAll();
        setor = list.get(0);

    }

    @Test
    public void givenValidSetorId_whenGet_thenReturnSetor() {

        ResponseEntity<String> response = makeGetRequest(Long.toString(setor.getId()));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertTrue(response.getBody().contains(setor.getNome()));
    }

    @Test
    public void givenInvalidSetorId_whenGetthenReturnNotFound() {
        ResponseEntity<String> response = makeGetRequest("123456");
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());
    }

    @Test
    public void givenSetor_whenCreate_thenSuccess() {
        Setor newSetor = SetorTestHelper.create("Codigo", "Nome Setor");

        ResponseEntity<String> response = makePostRequest(MapperUtil.convertToJson(newSetor));
        Setor result = MapperUtil.convertFromJson(response.getBody(), Setor.class);

        // Check status code:
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());

        // Check returned values:
        assertNotNull(result.getId());
        assertEquals(newSetor.getCodigo(), result.getCodigo());
        assertEquals(newSetor.getNome(), result.getNome());
        assertEquals(newSetor.getEmail(), result.getEmail());

        // Check default values:
        assertEquals(true, result.getAtivo());
        assertEquals("01", result.getLotacao());
    }

    @Test
    public void givenValidProject_whenUpdate_thenReturnSuccess() {
        SetorDto setorDto = MapperUtil.convertToDto(setor, SetorDto.class);
        setorDto.setCodigo("NOVOCODIGO");
        setorDto.setLotacao("06");

        ResponseEntity<String> response = makePutRequest(MapperUtil.convertToJson(setorDto), "1");
        Setor result = MapperUtil.convertFromJson(response.getBody(), Setor.class);

        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals(setorDto.getCodigo(), result.getCodigo());
        assertEquals(setorDto.getNome(), result.getNome());
        assertEquals(setorDto.getEmail(), result.getEmail());
        assertEquals(setorDto.getLotacao(), result.getLotacao());
    }

    private ResponseEntity<String> makeGetRequest(String id) {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        return restTemplate.exchange(createURLWithPort(SetorController.ENDPOINT + "/" + id), HttpMethod.GET, entity,
                String.class);
    }

    private ResponseEntity<String> makePostRequest(String jsonObj) {
        HttpEntity<String> entity = new HttpEntity<String>(jsonObj, headers);
        return restTemplate.postForEntity(createURLWithPort(SetorController.ENDPOINT), entity, String.class);
    }

    private ResponseEntity<String> makePutRequest(String jsonStr, String id) {
        HttpEntity<String> entity = new HttpEntity<String>(jsonStr, headers);
        return restTemplate.exchange(createURLWithPort(SetorController.ENDPOINT + "/" + id), HttpMethod.PUT, entity,
                String.class);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}