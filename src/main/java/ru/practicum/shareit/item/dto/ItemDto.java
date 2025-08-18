package ru.practicum.shareit.item.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.shareit.validation.OnCreate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
}