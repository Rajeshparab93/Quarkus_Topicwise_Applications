package org.clover.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.clover.entity.Citizen;
import org.clover.entity.SimCard;
import org.clover.repository.CitizenRepo;

import java.util.List;

@Path("/")
public class Resource {
    @Inject
    CitizenRepo citizenRepo;

    @GET
    @Path("/save")
    @Transactional
    public Response saveData() {


        Citizen citizen = new Citizen();

        citizen.setName("Raj");
        citizen.setGender("Male");


        SimCard simCard = new SimCard();

        simCard.setActive(true);
        simCard.setCitizen(citizen);
        simCard.setNumber(8356025036L);
        simCard.setProvider("Jio");

        SimCard simCard1 = new SimCard();
        simCard1.setActive(true);
        simCard1.setCitizen(citizen);
        simCard1.setNumber(8356025039L);
        simCard1.setProvider("Airtel");

        citizen.setSimCard(List.of(simCard, simCard1));
        citizenRepo.persist(citizen);
        if (citizenRepo.isPersistent(citizen)) {
            return Response.ok(new String("Citizen with SimCard Details get save successfully...!!!")).build();


        }
        return Response.ok("Something went wrong...!!!").build();
    }
}
