package com.barclays.eagle.model.auth.requestDTO;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull String username,
                           @NotNull String password) {
}
