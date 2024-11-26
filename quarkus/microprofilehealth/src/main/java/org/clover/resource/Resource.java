package org.clover.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class Resource {

    private static final Logger log = LoggerFactory.getLogger(Resource.class);

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)

    public Response hello() {
        return Response.ok("HEllo from quarkus.....!!!").build();
    }

}
