package com.barclays.eagle.model.user.responseDTO;

import com.barclays.eagle.model.user.entity.Address;
import com.barclays.eagle.model.user.entity.User;

import java.time.LocalDateTime;

public record CreateUserSuccessResponse(Long id,
                                        String name,
                                        Address address,
                                        String phoneNumber,
                                        String email,
                                        LocalDateTime createdTimestamp,
                                        LocalDateTime updatedTimestamp) implements CreateUserResponse {
}
