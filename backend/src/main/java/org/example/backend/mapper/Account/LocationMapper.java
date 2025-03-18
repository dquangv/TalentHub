package org.example.backend.mapper.Account;


import org.example.backend.dto.response.account.LocationDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    @Mapping(source = "lat", target = "lat")
    @Mapping(source = "lng", target = "lng")
    @Mapping(source = "role", target = "role")
    LocationDTOResponse toResponseDTO(Account account);
}
