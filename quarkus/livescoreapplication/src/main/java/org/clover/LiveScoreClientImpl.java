package org.clover;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.net.URI;

@RegisterRestClient(configKey = "live-score-client") // Register as a REST client
@ApplicationScoped // Mark it as a CDI bean
public class LiveScoreClientImpl implements LiveScoreClient{

    @Inject
    @ConfigProperty(name = "live-score-client/mp-rest/url")
    String baseUrl;

    @Override
    public String getLiveScores() {

        LiveScoreClient client = RestClientBuilder.newBuilder()
                .baseUri(URI.create(baseUrl))
                .build(LiveScoreClient.class);

        return client.getLiveScores();
    }
    }

