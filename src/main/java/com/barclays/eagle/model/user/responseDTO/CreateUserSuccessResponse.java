package com.barclays.eagle.model.user.responseDTO;

import com.barclays.eagle.model.user.entity.User;

import java.time.LocalDateTime;

public record CreateUserSuccessResponse(Long id,
                                        User user,
                                        LocalDateTime createdTimestamp,
                                        LocalDateTime updatedTimestamp) implements CreateUserResponse {
}
