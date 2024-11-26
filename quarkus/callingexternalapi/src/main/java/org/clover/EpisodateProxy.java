package org.clover;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://www.episodate.com/api")
public interface EpisodateProxy {
    @GET
    @Path("/most-popularr")
    ApiResponse getMostPopularShows(@QueryParam("page") int page);
}
