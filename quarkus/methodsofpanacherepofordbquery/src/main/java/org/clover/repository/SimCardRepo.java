package org.clover.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.clover.entity.SimCard;

@ApplicationScoped
public class SimCardRepo implements PanacheRepository<SimCard> {


}
