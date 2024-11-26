package org.clover.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/mobile")
@Tag(name = "Mobile API", description = "Operations related to mobile management")
public class MobileResource {

    List<Mobile> mobileList = new ArrayList<>();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Get all mobiles",
        description = "Retrieves the list of all mobiles"
    )
    public Response getMobList() {

        return Response.ok(mobileList).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Create a new mobile",
            description = "Creates a new mobile entry"
    )
    public Response createMobile(Mobile mobile) {

        mobileList.add(mobile);
        return Response.ok(mobile).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Update an existing mobile",
        description = "Updates the mobile entry with the given ID"
    )

    public Response updateMob(@PathParam("id") int id, Mobile mobileToUpdate) {
        mobileList = mobileList.stream().map(mobile -> {
            if (mobile.getId()==id) {
                return mobileToUpdate;
            } else {
                return mobile;
            }

        }).collect(Collectors.toList());

        return Response.ok(mobileList).build() ;


    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Delete a mobile by ID",
            description = "Deletes the mobile entry with the given ID"
    )

    public Response deleteMobile(@PathParam("id") int id) {
        // Attempt to remove the mobile with the given ID in one step
        List<Mobile> updatedList = mobileList.stream()
                .filter(mobile -> mobile.getId() != id)
                .collect(Collectors.toList());

        // Check if any mobile was actually removed
        if (updatedList.size() == mobileList.size()) {
            // No mobile was found with the specified ID, return 404
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Mobile with id " + id + " not found.")
                    .build();
        }

        // Update the original list reference
        mobileList = updatedList;

        // Return a success message along with the updated mobile list
        String successMessage = "Mobile with id " + id + " has been deleted successfully.";
        return Response.ok(successMessage).build();
    }

}




/*
package org.clover.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/mobile")
public class MobileResource {

    private static final Logger log = LoggerFactory.getLogger(MobileResource.class);
    List<String> mobList = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    */
/*public List<String> getMobList() {
        return mobList;
    }*//*


    public Response getMobList() {
        return Response.ok(mobList).build();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    */
/*public void addNewMob(String mobName) {
        mobList.add(mobName);
    }*//*


    public Response addNewMob(String mobName) {
        mobList.add(mobName);
        return Response.ok(mobName).build();

    }

    @PUT
    @Path("/{oldmobname}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateMobile(@PathParam("oldmobname") String oldMobName, @QueryParam("newmobname") String newMobName) {

        List<String> updatedMobList =mobList.stream().map(mobile-> {
            if (mobile.equals(oldMobName)) {
                return newMobName;
            } else {
                return mobile;
            }
        }).collect(Collectors.toList());
        mobList.clear();
        mobList.addAll(updatedMobList);

        return Response.ok(mobList).build();

    }

    @DELETE
    @Path("{mobtobedelete}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteMob(@PathParam("mobtobedelete") String mobName) {
       boolean isRemoved = mobList.remove(mobName);
       if (isRemoved) {
           return Response.ok(mobList).build();
       } else {
           return Response.status(Response.Status.BAD_REQUEST).build();
       }

    }
}
*/


