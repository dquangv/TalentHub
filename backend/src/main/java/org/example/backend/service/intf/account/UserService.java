package org.example.backend.service.intf.account;

import org.example.backend.dto.request.account.UserDTORequest;
import org.example.backend.dto.response.account.UserDTOResponse;
import org.example.backend.service.BaseService;

public interface UserService extends BaseService<UserDTORequest, UserDTOResponse, Long> {
}
