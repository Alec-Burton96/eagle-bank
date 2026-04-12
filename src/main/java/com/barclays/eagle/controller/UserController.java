package com.barclays.eagle.controller;

import com.barclays.eagle.mapper.UserMapper;
import com.barclays.eagle.model.user.requestDTO.CreateUserRequest;
import com.barclays.eagle.model.user.responseDTO.CreateUserResponse;
import com.barclays.eagle.model.user.responseDTO.CreateUserSuccessResponse;
import com.barclays.eagle.model.user.entity.User;
import com.barclays.eagle.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserSuccessResponse createUser(@RequestBody @Valid CreateUserRequest request) {
        return userService.createUser(request);
    }
}
