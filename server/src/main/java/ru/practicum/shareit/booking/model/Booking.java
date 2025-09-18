package ru.practicum.shareit.booking.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.shareit.booking.enumeration.BookingStatus;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@NamedEntityGraph(name = "Booking",
        attributeNodes = {
                @NamedAttributeNode("item"),
                @NamedAttributeNode("booker")
        })
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "start_date")
    LocalDateTime start;

    @Column(name = "end_date")
    LocalDateTime end;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    Item item;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booker_id", referencedColumnName = "id")
    User booker;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    BookingStatus status;
}