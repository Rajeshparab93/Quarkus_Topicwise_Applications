package org.clover;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;


@RegisterRestClient(baseUri = "https://www.episodate.com/api" )
public interface TvSeriesIdProxy {

    // https://www.episodate.com/api/most-popular?page=1
    @GET
    @Path("/most-popularr")
    ApiResponse getMostPopularShows(@QueryParam("page") int page);

}
