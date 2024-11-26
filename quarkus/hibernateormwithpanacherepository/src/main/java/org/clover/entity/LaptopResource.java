package org.clover.entity;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/laptop")
public class LaptopResource {

    @Inject
    LaptopRepo laptopRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLaptop() {
        List<Laptop> laptopList = laptopRepo.listAll();

        return Response.ok(laptopList).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveLaptop(Laptop laptop) {
        laptopRepo.persist(laptop);

        if (laptopRepo.isPersistent(laptop)) {

            return Response.created(URI.create("/laptop/" + laptop.getId())).build();
        } else {

            return Response.status(Response.Status.BAD_REQUEST).build();
        }


    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getLaptopById(@PathParam("id") Long id) {

        Laptop laptop = laptopRepo.findById(id);

        return Response.ok(laptop).build();


    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response updateLaptop(@PathParam("id") Long id, Laptop updateLaptop) {
        Optional<Laptop> optionalLaptop = laptopRepo.findByIdOptional(id);

        if (optionalLaptop.isPresent()) {
            Laptop dbLaptop = optionalLaptop.get();
            dbLaptop.setName(updateLaptop.getName()); // Update name or other fields
            dbLaptop.setBrand(updateLaptop.getBrand());
            dbLaptop.setRam(updateLaptop.getRam());
            dbLaptop.setExternalStorage(updateLaptop.getExternalStorage());// Update price or other fields
            // You can update more fields here as per your Laptop class structure
            laptopRepo.persist(dbLaptop);
            return Response.ok(dbLaptop).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Laptop not found with ID: " + id).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLaptopById(@PathParam("id") Long id) {
        Optional<Laptop> optionalLaptop = laptopRepo.findByIdOptional(id);

        if (optionalLaptop.isPresent()) {
            laptopRepo.delete(optionalLaptop.get());
            return Response.ok("Laptop with ID " + id + " deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Laptop not found with ID: " + id).build();
        }
    }

}
