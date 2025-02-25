package org.example.backend.controller.account;


import lombok.RequiredArgsConstructor;
import org.example.backend.dto.request.account.UserDTORequest;
import org.example.backend.dto.response.account.UserDTOResponse;
import org.example.backend.service.intf.account.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTOResponse> getUserById(@PathVariable Long userId) {
        Optional<UserDTOResponse> userResponse = userService.getById(userId);
        return userResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTOResponse> updateUser(
            @PathVariable Long userId,
            @RequestBody UserDTORequest userDTORequest) {
        userDTORequest.setId(userId);
        UserDTOResponse updatedUser = userService.update(userDTORequest);
        return ResponseEntity.ok(updatedUser);
    }
}