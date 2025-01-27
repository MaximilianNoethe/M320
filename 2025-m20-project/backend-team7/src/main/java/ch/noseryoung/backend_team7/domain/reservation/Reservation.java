package ch.noseryoung.backend_team7.domain.reservation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ch.noseryoung.backend_team7.domain.table.RestaurantTable;

import java.time.LocalDateTime;

/**
 * Entity class representing a Reservation.
 * Contains attributes and relationships for managing reservations.
 */
@Setter
@Getter
@Entity
@Table(name = "reservation")
public class Reservation {

    /**
     * The unique identifier for the reservation.
     */
    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;

    /**
     * The first name of the person making the reservation.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * The last name of the person making the reservation.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * The time of the reservation.
     * Must be in the future and cannot be null.
     */
    @Column(name = "reservation_time")
    @NotNull(message = "Reservation time cannot be empty")
    @Future(message = "Reservation time must be in the future")
    private LocalDateTime reservationTime;

    /**
     * The number of people included in the reservation.
     * Must be at least 1.
     */
    @Column(name = "person_count")
    @Min(value = 1, message = "Person count must be at least 1")
    private int personCount;

    /**
     * The table associated with the reservation.
     * Must not be null.
     */
    @OneToOne
    @JoinColumn(name = "table_id", referencedColumnName = "table_id")
    @JsonManagedReference
    @NotNull(message = "Restaurant table cannot be empty")
    private RestaurantTable restaurantTable;
}
