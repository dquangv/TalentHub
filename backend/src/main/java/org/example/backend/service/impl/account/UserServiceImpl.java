package org.example.backend.service.impl.account;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.UserDTORequest;
import org.example.backend.dto.response.account.UserDTOResponse;
import org.example.backend.entity.child.account.User;
import org.example.backend.enums.RoleUser;
import org.example.backend.enums.StatusAccount;
import org.example.backend.exception.NotFoundException;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.intf.account.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<UserDTOResponse> getAllActiveAdmins() {
        List<User> activeAdmins = userRepository.findByAccount_RoleAndAccount_Status(
                RoleUser.ADMIN, StatusAccount.VERIFIED);

        return activeAdmins.stream()
                .map(this::mapToUserDTOResponse)
                .collect(Collectors.toList());
    }
    @Override
    public UserDTOResponse create(UserDTORequest userDTORequest) {
        return null;
    }

    @Override
    public Optional<UserDTOResponse> getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(this::mapToUserDTOResponse);
    }

    @Override
    public List<UserDTOResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }

    @Override
    public UserDTOResponse update(UserDTORequest userDTORequest) {
        Long userId = userDTORequest.getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));

        // Cập nhật thông tin user (không cập nhật account)
        if (userDTORequest.getFirstName() != null) {
            user.setFirstName(userDTORequest.getFirstName());
        }

        if (userDTORequest.getLastName() != null) {
            user.setLastName(userDTORequest.getLastName());
        }

        if (userDTORequest.getPhoneNumber() != null) {
            user.setPhoneNumber(userDTORequest.getPhoneNumber());
        }

        if (userDTORequest.getProvince() != null) {
            user.setProvince(userDTORequest.getProvince());
        }

        if (userDTORequest.getCountry() != null) {
            user.setCountry(userDTORequest.getCountry());
        }

        if (userDTORequest.getTitle() != null) {
            user.setTitle(userDTORequest.getTitle());
        }

        if (userDTORequest.getIntroduction() != null) {
            user.setIntroduction(userDTORequest.getIntroduction());
        }

        if (userDTORequest.getImage() != null) {
            user.setImage(userDTORequest.getImage());
        }

        User updatedUser = userRepository.save(user);
        return mapToUserDTOResponse(updatedUser);
    }

    private UserDTOResponse mapToUserDTOResponse(User user) {
        return UserDTOResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .province(user.getProvince())
                .country(user.getCountry())
                .title(user.getTitle())
                .introduction(user.getIntroduction())
                .image(user.getImage())
                .role(user.getAccount() != null ? user.getAccount().getRole() : null)
                .build();
    }


}
