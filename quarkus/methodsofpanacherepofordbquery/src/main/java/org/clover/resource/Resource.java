package org.clover.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.clover.entity.SimCard;
import org.clover.repository.SimCardRepo;

@Path("/")
public class Resource {

    @Inject
    SimCardRepo simCardRepo;

    @GET
    @Path("save_simcard")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional

    public Response saveSimCard() {

        String[] provider = {"Jio","Airtel","VI"};
     //   Boolean[] isActive = {true,false,true};

        for (long i=0L; i<20L; i++) {

            SimCard simCard = new SimCard();
            simCard.setNumber(8356025029L +i);
            simCard.setProvider(provider[(int)i%provider.length]);
            simCard.setActive(i/3L==0);

            simCardRepo.persist(simCard);
            if (simCardRepo.isPersistent(simCard)){
                System.out.println(simCard + "Sim card get save successfully...!!!");
            } else {
                System.out.println(simCard + "Sim card not save. Please check...!!!");
            }
        }

        return Response.ok(new String("Sim card save successfully...!!!")).build();
    }
}
