package ru.practicum.shareit.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {

    @NotNull
    private LocalDateTime start;

    @NotNull
    private LocalDateTime end;

    @NotNull
    private Long itemId;
}
