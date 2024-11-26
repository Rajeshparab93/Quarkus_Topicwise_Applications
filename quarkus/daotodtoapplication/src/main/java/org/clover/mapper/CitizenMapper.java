package org.clover.mapper;

import org.clover.dto.CitizenDTO;
import org.clover.entity.Citizen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CitizenMapper {
    Citizen toDAO(CitizenDTO citizenDTO);

    CitizenDTO toDTO(Citizen citizen);
}
