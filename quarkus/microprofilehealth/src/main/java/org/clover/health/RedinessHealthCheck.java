package org.clover.health;

import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Readiness
public class RedinessHealthCheck implements HealthCheck {

    @Inject
    DataSource dataSource;

    @Override
    public HealthCheckResponse call() {
        try {
            Connection connection = dataSource.getConnection();
            if (connection.isValid(1)) {
                return HealthCheckResponse
                        .named("Database rediness health")
                        .up()
                        .build();

            } else {

                return HealthCheckResponse
                        .named("Database rediness health")
                        .down()
                        .build();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // resources which we r working in the project r ready or not to serve the incoming request

}
