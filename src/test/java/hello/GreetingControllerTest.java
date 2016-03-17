
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
 * Unit test
 */
public class GreetingControllerTest {
    @Test
    public void shouldGetGreeting() throws Exception {
        GreetingController controller = new GreetingController();
        Greeting greeting = controller.greeting("foobar");
        assertThat(greeting.getContent(), is("Hello, foobar!"));
    }
}
