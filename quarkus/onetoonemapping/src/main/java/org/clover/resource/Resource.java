package org.clover.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.clover.entity.Citizen;
import org.clover.repository.CitizenRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class Resource {

    @Inject
    CitizenRepo citizenRepo;

    private static final Logger log = LoggerFactory.getLogger(Resource.class);

    @GET
    @Path("save")
    @Transactional
    public void saveCitizen(){
        Citizen citizen = new Citizen();

        citizen.setName();
        citizen.setGender();
        citizenRepo.persist(citizen);

    }
}
