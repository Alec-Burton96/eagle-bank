package com.barclays.eagle.model.account.requestDTO;

import jakarta.validation.constraints.NotNull;

public record CreateAccountRequest(@NotNull String name,
                                   @NotNull String accountType) {
}
