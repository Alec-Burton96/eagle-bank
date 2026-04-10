package com.barclays.eagle.model.user.requestDTO;

import com.barclays.eagle.model.user.entity.Address;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(@NotNull String name,
                                @NotNull Address address,
                                @NotNull String phoneNumber,
                                @NotNull String email) {}
