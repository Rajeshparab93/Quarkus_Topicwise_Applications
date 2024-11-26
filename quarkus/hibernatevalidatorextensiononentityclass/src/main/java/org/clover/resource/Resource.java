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

@Path("")
public class Resource {

    @Inject
    CitizenRepo citizenRepo;

    @POST
    @Path("/save")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCitizen(Citizen citizen) {
        citizenRepo.persist(citizen);

        if (citizenRepo.isPersistent(citizen)) {
            return Response.ok(citizen).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
