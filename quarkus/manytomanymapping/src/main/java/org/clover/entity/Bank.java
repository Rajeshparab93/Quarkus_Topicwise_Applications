package org.clover.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id;
    String name;
    String branch;
    String ifscCode;

    @ManyToMany(mappedBy = "bankList")
    List<Citizen> citizen;

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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public List<Citizen> getCitizen() {
        return citizen;
    }

    public void setCitizen(List<Citizen> citizen) {
        this.citizen = citizen;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", citizen=" + citizen +
                '}';
    }
}
