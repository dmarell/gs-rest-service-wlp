/*
 * Created by Daniel Marell on 2016-03-17.
 */
package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Integration test deploying the app on tomcat and calling the endpoint /greeting.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class GreetingControllerIT {
    private static final String REST_URL = "http://localhost:8080";

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void shouldStoreAndReadGreeting() throws Exception {
        ResponseEntity<Greeting> response = restTemplate.getForEntity(
                REST_URL + "/greeting",
                Greeting.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertThat(response.getBody().getContent(), is("Hello, World!"));
    }
}
