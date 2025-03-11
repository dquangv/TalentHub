package org.example.backend.mapper.Account.admin;

import org.example.backend.dto.request.account.admin.VoucherPackageDTORequest;
import org.example.backend.dto.response.account.admin.VoucherPackageDTOResponse;
import org.example.backend.entity.child.admin.VoucherPackage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VoucherPackageMapper {

    @Mapping(source = "account.id", target = "accountId")
    VoucherPackageDTOResponse toDTO(VoucherPackage voucherPackage);

    @Mapping(source = "accountId", target = "account.id")
    VoucherPackage toEntity(VoucherPackageDTORequest voucherPackageDTORequest);
}
