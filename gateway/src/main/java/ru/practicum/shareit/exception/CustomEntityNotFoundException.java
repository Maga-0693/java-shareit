package ru.practicum.shareit.exception;

public class CustomEntityNotFoundException extends RuntimeException {
    public CustomEntityNotFoundException(String message) {

        super(message);
    }
}
