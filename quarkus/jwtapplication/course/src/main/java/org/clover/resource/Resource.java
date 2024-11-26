package org.clover.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
public class Resource {

    @GET
    @RolesAllowed({"teacher","admin"})
    @Path("/getlist")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCourseList() {
        return Response.ok("Here is course list...!!").build();

    }
}
