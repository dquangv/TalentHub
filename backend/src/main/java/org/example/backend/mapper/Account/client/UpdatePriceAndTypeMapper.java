package org.example.backend.mapper.Account.client;

import org.example.backend.dto.request.account.client.UpdatePriceAndTypeDTORequest;
import org.example.backend.dto.response.account.client.UpdatePriceAndTypeDTOResponse;
import org.example.backend.entity.child.account.client.Client;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UpdatePriceAndTypeMapper extends BaseMapper<Client, UpdatePriceAndTypeDTORequest, UpdatePriceAndTypeDTOResponse> {

    @Mapping(source = "id", target = "clientId")
    UpdatePriceAndTypeDTOResponse toResponseDto(Client entity);

    @Mapping(source = "clientId", target = "id")
    Client toEntity(UpdatePriceAndTypeDTOResponse dto);
}
