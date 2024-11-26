package org.clover;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/live-scores")
public interface LiveScoreClient {
    @GET
    String getLiveScores();
}
