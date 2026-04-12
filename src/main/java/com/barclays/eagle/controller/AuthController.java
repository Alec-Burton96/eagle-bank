package com.barclays.eagle.controller;

import com.barclays.eagle.model.auth.requestDTO.LoginRequest;
import com.barclays.eagle.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {

        return authService.isAuthenticated(loginRequest.username(), loginRequest.password())
                ? ResponseEntity.ok(authService.generateJwtToken(loginRequest.username()))
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
