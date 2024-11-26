package org.clover.health;

import org.clover.restclient.JsonPlaceHolderRestClient;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Liveness
public class LivenessHealthCheck implements HealthCheck {

    @RestClient
    JsonPlaceHolderRestClient restClient;

    @Override
    public HealthCheckResponse call() {
        restClient.getAllPost();

        return HealthCheckResponse.named("JsonPlaceHolder APIs health").up().build();
    }

    // it is used to check weather APIs are live / working


}
