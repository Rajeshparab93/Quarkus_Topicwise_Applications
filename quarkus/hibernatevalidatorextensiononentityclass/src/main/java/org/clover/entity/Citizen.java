package org.clover.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    Long id;
    @NotBlank(message = "Name can not be blank")
    @Length(min = 10, max = 30, message = "Name should be between 1 char to 30 char")
    String name;
    @Pattern(regexp = "[MF]", message = "Select either M or F")
    String gender;
    @Length(min = 12, max = 12)
    String aadharNo;
    @Min(value = 10, message = "Min age should be 10 yrs")
    @Max(value = 24, message = "Min age should be 24 yrs")
    int age;

    public Citizen() {

    }

    public Citizen(Long id, String name, String gender, String aadharNo, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.aadharNo = aadharNo;
        this.age = age;
    }


}
