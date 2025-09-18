package ru.practicum.shareit.item.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.shareit.booking.dto.BookingItemDto;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.validation.OnCreate;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemDto {
    Long id;

    @NotBlank(groups = {OnCreate.class})
    String name;

    @NotBlank(groups = {OnCreate.class})
    String description;

    @NotNull(groups = {OnCreate.class})
    Boolean available;

    UserDto owner;
    BookingItemDto lastBooking;
    BookingItemDto nextBooking;
    List<CommentDto> comments;
    Long requestId;
}