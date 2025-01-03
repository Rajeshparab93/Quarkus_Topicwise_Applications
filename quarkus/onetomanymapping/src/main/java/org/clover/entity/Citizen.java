package org.clover.entity;

import jakarta.persistence.*;

import java.util.List;

// ProblemStatement: one citizen hav many sim cards......

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    Long id;
    String name;
    String gender;

    @OneToMany(mappedBy = "citizen", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<SimCard> simCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<SimCard> getSimCard() {
        return simCard;
    }

    public void setSimCard(List<SimCard> simCard) {
        this.simCard = simCard;
    }
}
