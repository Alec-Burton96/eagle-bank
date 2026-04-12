package com.barclays.eagle.model;

import com.barclays.eagle.model.user.responseDTO.CreateUserResponse;

public record DefaultInternalErrorResponse(String message) implements CreateUserResponse {
}
