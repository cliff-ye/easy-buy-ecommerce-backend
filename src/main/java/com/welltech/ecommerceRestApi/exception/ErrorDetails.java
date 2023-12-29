package com.welltech.ecommerceRestApi.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record ErrorDetails(int status, String message, LocalDateTime timeStamp,String details) {
}
