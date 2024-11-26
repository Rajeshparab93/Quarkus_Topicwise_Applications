package org.clover.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.clover.entity.Citizen;
import org.clover.repository.CitizenRepo;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.net.URI;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Resource {

    @Inject
    CitizenRepo citizenRepo;

    @POST
    @Path("/add")
    @Transactional
    public Resource addCitizen(@RequestBody Citizen citizen) {

        citizenRepo.persist(citizen);
        if (citizenRepo.isPersistent(citizen)) {
            return Response.created(URI.create("/citizen/" + citizen.getId())).build();

        } else {
            return Response.status(Response.status.NOT_FOUND).build();
        }
    }
}
