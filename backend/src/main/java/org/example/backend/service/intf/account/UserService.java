package org.example.backend.service.intf.account;

import org.example.backend.dto.request.account.UserDTORequest;
import org.example.backend.dto.response.account.UserDTOResponse;
import org.example.backend.service.BaseService;

import java.util.List;

public interface UserService extends BaseService<UserDTORequest, UserDTOResponse, Long> {
    UserDTOResponse update(UserDTORequest userDTORequest);
    List<UserDTOResponse> getAllActiveAdmins();
}
