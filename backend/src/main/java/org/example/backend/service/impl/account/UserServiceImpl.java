package org.example.backend.service.impl.account;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.UserDTORequest;
import org.example.backend.entity.child.account.User;
import org.example.backend.service.intf.account.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public UserDTORequest create(UserDTORequest userDTORequest) {
        return null;
    }

    @Override
    public Optional<UserDTORequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<UserDTORequest> getAll() {
        return List.of();
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}
