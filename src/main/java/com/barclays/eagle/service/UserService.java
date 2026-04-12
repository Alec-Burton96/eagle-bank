package com.barclays.eagle.service;

import com.barclays.eagle.mapper.UserMapper;
import com.barclays.eagle.model.user.entity.User;
import com.barclays.eagle.model.user.requestDTO.CreateUserRequest;
import com.barclays.eagle.model.user.responseDTO.CreateUserSuccessResponse;
import com.barclays.eagle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public CreateUserSuccessResponse createUser(CreateUserRequest createUserRequest) {
        User user = UserMapper.createUserRequestToEntity(createUserRequest);
        User savedUser = userRepository.save(user);
        return UserMapper.userToCreateUserSuccessResponse(savedUser);
    }
}
