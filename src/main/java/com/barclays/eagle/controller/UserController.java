package com.barclays.eagle.controller;

import com.barclays.eagle.model.user.requestDTO.CreateUserRequest;
import com.barclays.eagle.model.user.responseDTO.CreateUserSuccessResponse;
import com.barclays.eagle.security.JwtCache;
import com.barclays.eagle.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtCache jwtCache;

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserSuccessResponse createUser(
            @RequestBody
            @Valid
            CreateUserRequest request) {
        CreateUserSuccessResponse response = userService.createUser(request);

        cacheToken(response.id());

        return response;
    }

    @GetMapping( "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Validated
    public CreateUserSuccessResponse fetchUser(
            @PathVariable
            @Pattern(regexp = "^usr-[A-Za-z0-9]+$", message = "Invalid user ID format")
            String id) throws Exception {
        return userService.fetchUser(id);
    }

    private void cacheToken(String id) {
        String userToken = JwtCache.getAuthTokenForRequest();
        JwtCache.JwtCacheEntry cacheEntry = new JwtCache.JwtCacheEntry(userToken, id);
        jwtCache.getJwtCacheEntries().add(cacheEntry);
    }
}
