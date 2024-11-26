package org.clover.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.clover.entity.Bank;
import org.clover.entity.Citizen;
import org.clover.repository.BankRepo;
import org.clover.repository.CitizenRepo;

import java.util.List;

@Path("/")
public class Resource {

    @Inject
    BankRepo bankRepo;

    @Inject
    CitizenRepo citizenRepo;
           @GET
           @Path("save_bank")
           @Transactional
           @Produces(MediaType.TEXT_PLAIN)
           public Response saveBank() {
               String[] bankNames = {"SBI","PNB","ICICI","AXIS","HDFC"};

               for (String bankName: bankNames) {
                   Bank bank = new Bank();
                   bank.setBranch("BKC, Mumbai");
                   bank.setName(bankName);
                   bank.setIfscCode("IFSC85"+bankName);

                   bankRepo.persist(bank);
               }

               return Response.status(Response.Status.OK).build();
           }

    @GET
    @Path("save_citizen")
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public Response saveCitizen() {
        String[] bankNames = {"SBI","PNB","ICICI","AXIS","HDFC"};

        Bank SBIBank = bankRepo.find("name",bankNames[0]).firstResult();
        Bank PNBBank = bankRepo.find("name",bankNames[1]).firstResult();
        Bank ICICIBank = bankRepo.find("name",bankNames[2]).firstResult();
        Bank AXISBank = bankRepo.find("name",bankNames[3]).firstResult();
        Bank HDFCBank = bankRepo.find("name",bankNames[4]).firstResult();

        System.out.println(">>>>>>>>>>><<<<<<<<<<<"+PNBBank);

        Citizen citizen = new Citizen();
        citizen.setName("Raj");
        citizen.setGender("Male");
        citizen.setBankList(List.of(SBIBank,ICICIBank,AXISBank));

        citizenRepo.persist(citizen);



        return Response.status(Response.Status.OK).build();
    }
}
