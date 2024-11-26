package org.clover.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.clover.repository.AadharRepo;
import org.clover.repository.CitizenRepo;

@Path("/")
public class Resource {

    @Inject
    CitizenRepo citizenRepo;

    @Inject
    AadharRepo aadharRepo;

    @GET
    @Path("get")
    @Transactional
    public Response saveCitizen() {
        return Response.ok("Saved").build();
    }
}
