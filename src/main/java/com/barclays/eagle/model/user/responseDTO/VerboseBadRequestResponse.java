package com.barclays.eagle.model.user.responseDTO;

import java.util.List;

public record VerboseBadRequestResponse(String message,
                                        List<Details> details) {
    public record Details(String field, String message, String type){}
}
