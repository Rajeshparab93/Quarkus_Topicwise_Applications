package org.clover.entity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LaptopRepo implements PanacheRepository<Laptop> {

}
