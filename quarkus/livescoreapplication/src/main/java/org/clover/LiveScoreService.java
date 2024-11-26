package org.clover;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LiveScoreService {

    @Inject
    LiveScoreClient liveScoreClient;

    @Scheduled(every = "10s") // Every 10 seconds
    void fetchLiveScores() {
        try {
            String response = liveScoreClient.getLiveScores();
            System.out.println("Live Score: " + response);
        } catch (Exception e) {
            System.err.println("Error fetching live scores: " + e.getMessage());
        }
    }
}
