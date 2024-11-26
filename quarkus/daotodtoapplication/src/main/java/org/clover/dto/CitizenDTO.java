package org.clover.dto;

// no need to add @Entity or any other annotations here because
// DTO class is plain java class

import lombok.Data;

@Data
public class CitizenDTO {

    Long id;
    String fullName;
    String pinCode;
    String address;
    String gender;
}
