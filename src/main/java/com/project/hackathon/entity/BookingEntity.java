package com.project.hackathon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull(message = "{user_id is invalid}")
    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity userId;

    @NotNull(message = "{position_id is invalid}")
    @JoinColumn(name = "position_id")
    @ManyToOne
    private PositionEntity positionId;
//    private String positionId;

    @NotNull(message = "{date is invalid}")
    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "{booking_status_id is invalid}")
    @JoinColumn(name = "booking_status_id")
    @ManyToOne
    private BookingStatusEntity bookingStatusId;
}
