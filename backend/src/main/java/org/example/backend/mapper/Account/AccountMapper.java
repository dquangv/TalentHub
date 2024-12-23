package org.example.backend.mapper.Account;

import org.example.backend.dto.request.account.AccountDTORequest;
import org.example.backend.dto.response.account.AccountDTOResponse;
import org.example.backend.entity.child.account.Account;
import org.example.backend.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountDTORequest, AccountDTOResponse> {
}
