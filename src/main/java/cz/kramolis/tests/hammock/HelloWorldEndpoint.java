package cz.kramolis.tests.hammock;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
@RequestScoped
public class HelloWorldEndpoint {
    @GET
    public Response doGet() {
        return Response.ok("Hello, World!").build();
    }
}
