package ch.noseryoung.backend_team7.domain.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Reservation} entities.
 *
 * <p>This interface extends {@link JpaRepository}, providing CRUD operations and query method functionality
 * for interacting with the Reservation database table. The primary key of Reservation is of type Integer.</p>
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
