package org.clover.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.clover.restclient.NasaWeatherRestClient;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class IndiaWeatherResource {

    @RestClient
    NasaWeatherRestClient weatherRestClient;

    @GET
    @Path("weather/{country}")
    @Fallback(fallbackMethod = "")
    public Response getWeatherByCountry(@PathParam("country") String country) {

        Response response = weatherRestClient.weatherByCountry(country);

        return response;


    }
}
