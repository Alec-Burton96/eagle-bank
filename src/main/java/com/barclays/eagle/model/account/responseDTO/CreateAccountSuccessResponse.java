package com.barclays.eagle.model.account.responseDTO;

import java.time.LocalDateTime;

public record CreateAccountSuccessResponse(String accountNumber,
                                           String sortCode,
                                           String name,
                                           String accountType,
                                           double balance,
                                           String currency,
                                           LocalDateTime createdTimestamp,
                                           LocalDateTime updatedTimestamp) {
}
