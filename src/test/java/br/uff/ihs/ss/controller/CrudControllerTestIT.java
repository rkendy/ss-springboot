package br.uff.ihs.ss.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class CrudControllerTestIT {

    static HttpHeaders headers = new HttpHeaders();
    static TestRestTemplate restTemplate = new TestRestTemplate();

    @LocalServerPort
    int port;

    @BeforeAll
    static void setupAll() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    abstract public String getEndPoint();

    abstract public Long getId();

    abstract public String getJsonToCreate();

    abstract public String getJsonFromDto();

    abstract public void checkCreatedJson(String json);

    abstract public void createModel();

    abstract public int getCount();

    abstract public Long getIdToDelete();

    @Test
    public void givenValidId_whenGet_thenReturnSuccess() {

        ResponseEntity<String> response = makeGetRequest(getId());

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void givenInvalidId_whenGet_thenReturnNotFound() {
        ResponseEntity<String> response = makeGetRequest(123456L);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode().value());
    }

    @Test
    public void givenModel_whenCreate_thenSuccess() {
        int beforeCount = getCount();
        ResponseEntity<String> response = makePostRequest(getJsonToCreate());
        int afterCount = getCount();
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
        assertEquals(beforeCount + 1, afterCount);
        checkCreatedJson(response.getBody());
    }

    @Test
    public void givenValidModel_whenUpdate_thenReturnSuccess() {

        ResponseEntity<String> response = makePutRequest(getJsonFromDto(), getId());

        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    }

    @Test
    public void givenValidId_whenDelete_thenReturnSuccess() {
        createModel();
        int countBefore = getCount();

        ResponseEntity<String> response = makeDeleteRequest(getIdToDelete());

        int countAfter = getCount();
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