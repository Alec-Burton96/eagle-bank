package com.barclays.eagle.mapper;

import com.barclays.eagle.model.user.entity.User;
import com.barclays.eagle.model.user.requestDTO.CreateUserRequest;
import com.barclays.eagle.model.user.responseDTO.CreateUserSuccessResponse;

public class UserMapper {

    public static User createUserRequestToEntity(CreateUserRequest createUserRequest) {
        return new User(createUserRequest.name(),
                createUserRequest.address(),
                createUserRequest.phoneNumber(),
                createUserRequest.email());
    }

    public static CreateUserSuccessResponse userToCreateUserSuccessResponse(User user) {
        return new CreateUserSuccessResponse(user.getId(),
                user,
                user.getCreatedTimestamp(),
                user.getUpdatedTimestamp());
    }
}
