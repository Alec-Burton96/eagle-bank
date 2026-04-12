package com.barclays.eagle.mapper;

import com.barclays.eagle.model.user.entity.User;
import com.barclays.eagle.model.user.requestDTO.CreateUserRequest;
import com.barclays.eagle.model.user.responseDTO.CreateUserSuccessResponse;

import java.text.ParseException;

public class UserMapper {

    private static final String USER_RESPONSE_ID_PREFIX = "usr-";

    public static User createUserRequestToEntity(CreateUserRequest createUserRequest) {
        return new User(createUserRequest.name(),
                createUserRequest.address(),
                createUserRequest.phoneNumber(),
                createUserRequest.email());
    }

    public static CreateUserSuccessResponse userToCreateUserSuccessResponse(User user) {
        return new CreateUserSuccessResponse(appendUserPrefixToId(user.getId()),
                user.getName(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getCreatedTimestamp(),
                user.getUpdatedTimestamp());
    }

    private static String appendUserPrefixToId(Long id) {
        return USER_RESPONSE_ID_PREFIX + id;
    }

    public static Long extractIdNumberFromId(String fullId) throws Exception {
        if (fullId.contains(USER_RESPONSE_ID_PREFIX)) {
            return Long.valueOf(fullId.substring(USER_RESPONSE_ID_PREFIX.length()));
        }
        throw new Exception();
    }
}
