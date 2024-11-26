package org.clover.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.clover.entity.Bank;

@ApplicationScoped
public class BankRepo implements PanacheRepository<Bank> {
}
