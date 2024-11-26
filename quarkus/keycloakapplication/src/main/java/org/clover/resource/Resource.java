package org.clover.resource;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class Resource {

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @RolesAllowed({"student","professor","admin"})
    @Path("/course_list")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCourseList() {
        return Response.ok("Course List: CS ME CE" +
                securityIdentity.getPrincipal().getName()).build();
    }

    @GET
    @RolesAllowed({"professor","admin"})
    @Path("/add_course")
    @Produces(MediaType.TEXT_PLAIN)
    public Response addCourse() {
        return Response.ok("Added Course: E&TC").build();
    }

    @GET
    @RolesAllowed({"admin"})
    @Path("/update_course")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateCourse() {
        return Response.ok("Update Course:CS -> CSE").build();
    }

    @GET
    @RolesAllowed({"admin"})
    @Path("/delete_coure")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteCourse() {
        return Response.ok("Deleted Course: ME").build();
    }
}
