package cz.kramolis.tests.hammock;

import java.net.URI;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import ws.ament.hammock.test.support.EnableRandomWebServerPort;
import ws.ament.hammock.test.support.HammockArchive;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Arquillian.class)
@EnableRandomWebServerPort
public class HelloWorldEndpointTest {

    @Deployment
    public static JavaArchive createArchive() {
        return new HammockArchive().classes(HelloWorldEndpoint.class).jar();
    }

    @ArquillianResource
    private URI uri;

    @Test
    public void shouldBeAbleToRetrieveRestEndpoint() throws Exception {
        get(uri + "/hello").then().assertThat().statusCode(200)
                .body(is("Hello, World!"));
    }

}
