package org.clover.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.clover.entity.Citizen;

@ApplicationScoped
public class CitizenRepo implements PanacheRepository<Citizen> {
}
