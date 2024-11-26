package org.clover.resource;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CronJobs {


    @Scheduled(every = "10s")
    public void executeEvery10Sec() {
        System.out.println("I m from CRON...!!");
    }
}
