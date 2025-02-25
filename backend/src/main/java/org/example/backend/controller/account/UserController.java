package org.example.backend.controller.account;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.ResponseObject;
import org.example.backend.dto.request.account.UserDTORequest;
import org.example.backend.dto.response.account.UserDTOResponse;
import org.example.backend.service.intf.account.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseObject<UserDTOResponse> getUserById(@PathVariable Long userId) {
        return userService.getById(userId)
                .map(userResponse -> ResponseObject.<UserDTOResponse>builder()
                        .message("User retrieved successfully")
                        .status(HttpStatus.OK.value())
                        .data(userResponse)
                        .build())
                .orElseGet(() -> ResponseObject.<UserDTOResponse>builder()
                        .message("User not found with id: " + userId)
                        .status(HttpStatus.NOT_FOUND.value())
                        .data(null)
                        .build());
    }

    @GetMapping
    public ResponseObject<List<UserDTOResponse>> getAllUsers() {
        List<UserDTOResponse> users = userService.getAll();
        return ResponseObject.<List<UserDTOResponse>>builder()
                .message("All users retrieved successfully")
                .status(HttpStatus.OK.value())
                .data(users)
                .build();
    }

    @PutMapping("/{userId}")
    public ResponseObject<UserDTOResponse> updateUser(
            @PathVariable Long userId,
            @RequestBody UserDTORequest userDTORequest) {
        try {
            userDTORequest.setId(userId);
            UserDTOResponse updatedUser = userService.update(userDTORequest);
            return ResponseObject.<UserDTOResponse>builder()
                    .message("User updated successfully")
                    .status(HttpStatus.OK.value())
                    .data(updatedUser)
                    .build();
        } catch (Exception e) {
            return ResponseObject.<UserDTOResponse>builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST.value())
                    .data(null)
                    .build();
        }
    }
}