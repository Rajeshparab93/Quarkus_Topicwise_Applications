package org.clover.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.clover.entity.Aadhar;

@ApplicationScoped
public class AadharRepo implements PanacheRepository<Aadhar> {
}
