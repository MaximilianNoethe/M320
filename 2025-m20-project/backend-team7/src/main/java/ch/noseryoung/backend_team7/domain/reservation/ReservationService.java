package ch.noseryoung.backend_team7.domain.reservation;

import ch.noseryoung.backend_team7.domain.table.RestaurantTable;
import ch.noseryoung.backend_team7.domain.table.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.time.LocalTime;
import java.util.List;

/**
 * Service class for managing {@link Reservation} entities.
 *
 * <p>This class provides methods for CRUD operations on reservations and ensures that reservations
 * meet specific business rules, such as table availability and valid reservation times.</p>
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    /**
     * Retrieves all reservations from the database.
     *
     * @return a list of all reservations.
     */
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    /**
     * Retrieves a specific reservation by its ID.
     *
     * @param reservationId the ID of the reservation to retrieve.
     * @return the reservation with the specified ID.
     * @throws InstanceNotFoundException if no reservation with the specified ID exists.
     */
    public Reservation getByID(int reservationId) throws InstanceNotFoundException {
        return reservationRepository.findById(reservationId).orElseThrow(() -> new InstanceNotFoundException("Reservation with id " + reservationId + " could not be found."));
    }

    /**
     * Adds a new reservation.
     *
     * @param newReservation the reservation to add.
     * @return the saved reservation.
     * @throws TableAlreadyReservedException if the associated table is already reserved.
     * @throws InvalidReservationTimeException if the reservation time is invalid.
     * @throws InstanceNotFoundException if the associated table does not exist.
     */
    public Reservation addReservation(Reservation newReservation) throws TableAlreadyReservedException, InvalidReservationTimeException, InstanceNotFoundException {
        validateReservation(newReservation);
        return reservationRepository.save(newReservation);
    }

    /**
     * Updates an existing reservation.
     *
     * @param reservation the updated reservation data.
     * @param reservationId the ID of the reservation to update.
     * @return the updated reservation.
     * @throws TableAlreadyReservedException if the associated table is already reserved.
     * @throws InvalidReservationTimeException if the reservation time is invalid.
     * @throws InstanceNotFoundException if no reservation with the specified ID exists.
     */
    public Reservation updateReservation(Reservation reservation, int reservationId) throws TableAlreadyReservedException, InvalidReservationTimeException, InstanceNotFoundException {

        if (!reservationRepository.existsById(reservationId)) {
            throw new InstanceNotFoundException("Reservation with id " + reservationId + " could not be found.");
        }
        validateReservation(reservation);
        reservation.setReservationId(reservationId);
        return reservationRepository.save(reservation);
    }

    /**
     * Deletes a reservation by its ID.
     *
     * @param reservationId the ID of the reservation to delete.
     * @throws InstanceNotFoundException if no reservation with the specified ID exists.
     */
    public void deleteReservation(int reservationId) throws InstanceNotFoundException {
        if (!reservationRepository.existsById(reservationId)) {
            throw new InstanceNotFoundException("Reservation with id " + reservationId + " could not be found.");
        }
        reservationRepository.deleteById(reservationId);
    }

    /**
     * Validates a reservation to ensure it meets business rules.
     *
     * <p>This method checks the availability of the associated table and ensures
     * that the reservation time is within allowed hours.</p>
     *
     * @param reservation the reservation to validate.
     * @throws TableAlreadyReservedException if the associated table is already reserved.
     * @throws InvalidReservationTimeException if the reservation time is invalid.
     * @throws InstanceNotFoundException if the associated table does not exist.
     */
    private void validateReservation(Reservation reservation) throws TableAlreadyReservedException, InvalidReservationTimeException, InstanceNotFoundException {
        if (reservation.getRestaurantTable() != null) {
            int tableId = reservation.getRestaurantTable().getTableId();
            RestaurantTable table = restaurantTableRepository.findById(tableId).orElseThrow(() -> new InstanceNotFoundException("Table with id " + tableId + " could not be found."));

            if (!table.isAvailable()) {
                throw new TableAlreadyReservedException("Table with id " + tableId + " is already reserved.");
            }
        }

        LocalTime reservationTime = reservation.getReservationTime().toLocalTime();
        if (reservationTime.isBefore(LocalTime.of(12, 0)) || reservationTime.isAfter(LocalTime.of(23, 0))) {
            throw new InvalidReservationTimeException("Reservation time " + reservationTime + " is outside of the allowed hours (12:00 - 23:00).");
        }
    }
}
