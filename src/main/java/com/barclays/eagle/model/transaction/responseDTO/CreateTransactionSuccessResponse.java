package com.barclays.eagle.model.transaction.responseDTO;

import java.time.LocalDateTime;

public record CreateTransactionSuccessResponse(String id,
                                               double amount,
                                               String currency,
                                               String type,
                                               String reference,
                                               String userId,
                                               LocalDateTime createdTimestamp) {
}
