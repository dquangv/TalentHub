package org.example.backend.mapper.Account;

import org.example.backend.dto.response.account.LocationDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mapping(target = "address", expression = "java(getAddress(account))")
    @Mapping(source = "lat", target = "lat")
    @Mapping(source = "lng", target = "lng")
    @Mapping(source = "role", target = "role")
    LocationDTOResponse toResponseDTO(Account account);

    @Named("getAddress")
    default String getAddress(Account account) {
        if (account.getUser() == null) {
            return "";
        }

        String province = account.getUser().getProvince();
        String country = account.getUser().getCountry();

        if (province != null && !province.isEmpty()) {
            if (country != null && !country.isEmpty()) {
                return province + ", " + country;
            }
            return province;
        } else if (country != null && !country.isEmpty()) {
            return country;
        }

        return "";
    }
}