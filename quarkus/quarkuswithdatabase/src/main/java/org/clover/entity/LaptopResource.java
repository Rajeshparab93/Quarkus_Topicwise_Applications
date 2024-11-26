package org.clover.entity;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/laptop")
public class LaptopResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLaptop() {
        List<Laptop> laptopList = Laptop.listAll();

        return Response.ok(laptopList).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveLaptop(Laptop laptop) {
        Laptop.persist(laptop);

        if (laptop.isPersistent()) {

            return Response.created(URI.create("/laptop" + laptop.id)).build();
        } else {

            return Response.status(Response.Status.BAD_REQUEST).build();
        }


    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getLaptopById(@PathParam("id") Long id) {

        Laptop laptop = Laptop.findById(id);

        return Response.ok(laptop).build();


    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response updateLaptop(@PathParam("id") Long id, Laptop updateLaptop) {
        Optional<Laptop> optionalLaptop = Laptop.findByIdOptional(id);
        if (optionalLaptop.isPresent()) {

            Laptop dbLaptop  = optionalLaptop.get();
        } else {

            return Response.status(Response.Status.BAD_REQUEST).build();
        }


    }

}
