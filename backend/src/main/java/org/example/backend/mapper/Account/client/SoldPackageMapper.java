package org.example.backend.mapper.Account.client;

import org.example.backend.dto.request.account.client.SoldPackageDTORequest;
import org.example.backend.dto.response.account.client.SoldPackageDTOResponse;
import org.example.backend.entity.child.account.client.SoldPackage;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SoldPackageMapper extends BaseMapper<SoldPackage, SoldPackageDTORequest, SoldPackageDTOResponse> {
    @Mapping(source = "client.id", target = "clientId")
    @Mapping(source = "voucherPackage.id", target = "voucherPackageId")
    SoldPackageDTOResponse toResponseDto(SoldPackage soldPackage);

    @Mapping(source = "clientId", target = "client.id")
//    @Mapping(source = "voucherId", target = "voucherPackage.id")
    SoldPackage toEntity(SoldPackageDTORequest soldPackageDTORequest);
}
