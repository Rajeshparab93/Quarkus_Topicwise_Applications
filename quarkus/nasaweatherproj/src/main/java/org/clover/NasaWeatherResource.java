package org.clover;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Random;
import java.util.logging.Logger;

@Path("/api")
public class NasaWeatherResource {

    public static final Logger logger = Logger.getLogger(String.valueOf(NasaWeatherResource.class));

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("weather_by_country/{country}")

    public Response weatherByCountry(@PathParam("country") String country) {

        logger.info("Calling nasaweather ::weatherByCountry for country:"+country);

        return Response.ok("Weather of "+country+":"+ new Random().nextInt(40)).build();

    }
}
