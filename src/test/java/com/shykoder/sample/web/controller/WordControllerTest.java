package com.shykoder.sample.web.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WordControllerTest {
    @LocalServerPort
    int randomServerPort;

    @Test
    public void checkIfPyramidWord() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort + "/svc/v1/sample/word/check-pyramid/banana";
        URI uri = new URI(baseUrl);

        ResponseEntity<Boolean> result = restTemplate.getForEntity(uri, Boolean.class);
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody());
    }

    @Test
    public void checkIfPyramidWordFailed() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort + "/svc/v1/sample/word/check-pyramid/hello";
        URI uri = new URI(baseUrl);

        ResponseEntity<Boolean> result = restTemplate.getForEntity(uri, Boolean.class);
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(false, result.getBody());
    }

    @Test
    public void checkIfPyramidWordWithReqParam() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort;
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl).path("/svc/v1/sample/word/check-pyramid")
                .queryParam("input","banana").build().toUri();

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("true", result.getBody());
    }
}