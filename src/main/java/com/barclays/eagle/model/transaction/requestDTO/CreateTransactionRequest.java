package com.barclays.eagle.model.transaction.requestDTO;

import jakarta.validation.constraints.NotNull;

public record CreateTransactionRequest(@NotNull double amount,
                                       @NotNull String currency,
                                       @NotNull String type,
                                       String reference) {
}
