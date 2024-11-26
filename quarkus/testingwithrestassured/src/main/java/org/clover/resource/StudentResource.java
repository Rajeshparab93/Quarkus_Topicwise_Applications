package org.clover.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.clover.entity.Student;
import org.clover.repository.StudentRepo;

import java.util.List;

@Path("/")
public class StudentResource {

    @Inject
    StudentRepo studentRepo;

    @GET
    @Path("/getstudentlist")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getStudentList(){
        List<Student> studentList= studentRepo.listAll();
        return Response.ok(studentList).build();
    }
}
