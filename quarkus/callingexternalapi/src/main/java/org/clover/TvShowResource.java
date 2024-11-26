package org.clover;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/tvshows")
public class TvShowResource {

    @Inject
    @RestClient
    EpisodateProxy episodateProxy;

    @GET
    @Fallback(fallbackMethod = "getMostPopularShowDetails")
    @Path("/most-popular")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMostPopularShows() {
        return Response.ok(episodateProxy.getMostPopularShows(1)).build();
    }

    public Response getMostPopularShowDetails() {
        return Response.ok("Site is under maintenance...Please try again later....!!!").build();
    }


}
