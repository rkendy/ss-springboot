package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.uff.ihs.ss.helper.TestHelper;
import br.uff.ihs.ss.util.MapperUtil;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public abstract class CrudControllerTestIT<MODEL> {

    static HttpHeaders headers = new HttpHeaders();
    static TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    int port;

    @Autowired
    CrudRepository<MODEL, Long> repository;

    @Autowired
    MapperUtil mapperUtil;

    @Autowired
    TestHelper<MODEL> helper;

    @BeforeAll
    static void setupAll() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    abstract public String getEndPoint();

    abstract public void checkCreatedJson(MODEL model, String json);

    @Test
    public void givenValidId_whenGet_thenReturnSuccess() throws Exception {

        MODEL model = repository.findAll().iterator().next();

        ResponseEntity<String> response = makeGetRequest(helper.getId(model));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void givenInvalidId_whenGet_thenReturnNotFound() {
        ResponseEntity<String> response = makeGetRequest(123456L);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());
    }

    @Test
    public void givenModel_whenCreate_thenSuccess() {
        long beforeCount = repository.count();
        MODEL model = helper.createOne();
        ResponseEntity<String> response = makePostRequest(helper.convertToJson(model));
        long afterCount = repository.count();
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
        assertEquals(beforeCount + 1, afterCount);
        checkCreatedJson(model, response.getBody());
    }

    @Test
    public void givenValidModel_whenUpdate_thenReturnSuccess() {

        MODEL model = repository.findAll().iterator().next();

        ResponseEntity<String> response = makePutRequest(helper.convertToJson(model), helper.getId(model));

        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    }

    @Test
    public void givenValidId_whenDelete_thenReturnSuccess() {

        MODEL newModel = repository.save(helper.createOne());
        long countBefore = repository.count();

        ResponseEntity<String> response = makeDeleteRequest(helper.getId(newModel));

        long countAfter = repository.count();
        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
        assertEquals(countBefore, countAfter + 1);
    }

    protected ResponseEntity<String> makeGetRequest(Long id) {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        return restTemplate.exchange(createURLWithPort(getEndPoint() + "/" + id), HttpMethod.GET, entity, String.class);
    }

    protected ResponseEntity<String> makePostRequest(String jsonObj) {
        HttpEntity<String> entity = new HttpEntity<String>(jsonObj, headers);
        return restTemplate.postForEntity(createURLWithPort(getEndPoint()), entity, String.class);
    }

    protected ResponseEntity<String> makePutRequest(String jsonStr, Long id) {
        HttpEntity<String> entity = new HttpEntity<String>(jsonStr, headers);
        return restTemplate.exchange(createURLWithPort(getEndPoint() + "/" + id), HttpMethod.PUT, entity, String.class);
    }

    protected ResponseEntity<String> makeDeleteRequest(Long id) {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        return restTemplate.exchange(createURLWithPort(getEndPoint() + "/" + id), HttpMethod.DELETE, entity,
                String.class);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}