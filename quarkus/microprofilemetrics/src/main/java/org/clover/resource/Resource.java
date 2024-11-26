package org.clover.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.clover.restclient.JsonPlaceholderRestClient;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
public class Resource {

    @RestClient
    JsonPlaceholderRestClient restClient;

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok("Hello there......!!!").build();
    }

    @POST
    @Path("/{number}")
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "Count of check prime number:", description = "How many times this API/method is called:")
    @Timed(name = "Time taken:", description = "How many times this API/method is called:", unit = MetricUnits.MILLISECONDS)
    @Metered(name = "Metered:", description = "How frequently this API is called:")

    public String checkIfPrime(@PathParam("number") long number) {
        if (number < 1) {
            return "only natural numbers can be prime numbers..";
        }
        if (number == 1) {
            return "1 is not prime number";

        }
        if (number == 2) {
            return "2 is prime no.";
        }
        if (number % 2 == 0) {
            return number + "is not prime, it is divisible by 2";
        }

        for (int i = 3; i < Math.floor(Math.sqrt(number)) + 1; i = i + 2) {
            if (number % i == 0) {

                return number + "is not prime, is divisible by" + i;

            }
        }
        long highestPrimeNumberSoFor = Long.parseLong(null);
        if (number > highestPrimeNumberSoFor) {
            highestPrimeNumberSoFor = number;
        }
        return number + "is prime";

    }

    @Gauge(name = "Highest prime number request", description = "What is the highest prime-number calculated so far:", unit = "")
    public Long getHighestPrimeNumber() {
        return highestPrimeNumberSoFor;
    }

}

