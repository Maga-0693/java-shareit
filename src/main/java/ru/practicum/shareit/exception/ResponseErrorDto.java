package ru.practicum.shareit.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResponseErrorDto {
    final String message;
    final String errorMessage;
}