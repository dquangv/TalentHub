package org.example.backend.mapper.Account;

import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountDTORequest, AccountDTOResponse> {

   /* @Mapping(source = "account.id", target = "id")
    @Mapping(source = "account.email", target = "email")
    @Mapping(source = "account.role", target = "role")
    @Mapping(source = "account.status", target = "status")
    @Mapping(source = "account.createdAt", target = "createdAt")
    @Mapping(source = "account.updatedAt", target = "updatedAt")
    @Mapping(source = "account.user", target = "user")
    @Mapping(source = "account.payments", target = "payments")
    AccountResponseDTO toResponseDTO(Account account);*/
}
