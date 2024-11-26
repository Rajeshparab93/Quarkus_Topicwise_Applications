package org.clover.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.clover.entity.Student;

@ApplicationScoped
public class StudentRepo implements PanacheRepository<Student> {
}
