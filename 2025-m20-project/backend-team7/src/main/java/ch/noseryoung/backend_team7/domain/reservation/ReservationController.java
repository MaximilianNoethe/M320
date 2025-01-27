package ch.noseryoung.backend_team7.domain.reservation;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /**
     * Retrieves all reservations.
     *
     * @return A list of all reservations.
     */
    @PreAuthorize("hasAuthority('GET')")
    @GetMapping
    @Operation(summary = "Get all reservations", description = "Displays a list of all reservations along with their id, restaurant table, start time, end time, person count, and returns a JSON response with the status code 200.")
    public List<Reservation> getAll() {
        return reservationService.getAllReservations();
    }

    /**
     * Retrieves a single reservation by its ID.
     *
     * @param reservationId The ID of the reservation to retrieve.
     * @return The reservation object wrapped in a ResponseEntity with status code 200.
     * @throws InstanceNotFoundException If the reservation with the specified ID is not found.
     */
    @PreAuthorize("hasAuthority('GET')")
    @GetMapping("/{reservationId}")
    @Operation(summary = "Get reservation by ID", description = "Retrieves reservation information by its ID and returns a JSON object with the status code 200.")
    public ResponseEntity<Reservation> getById(@PathVariable("reservationId") int reservationId) throws InstanceNotFoundException {
        return ResponseEntity.ok().body(reservationService.getByID(reservationId));
    }

    /**
     * Creates a new reservation.
     *
     * @param newReservation The reservation object to create.
     * @return The created reservation object wrapped in a ResponseEntity with status code 201.
     * @throws InvalidReservationTimeException If the reservation time is invalid.
     * @throws TableAlreadyReservedException  If the table is already reserved.
     * @throws InstanceNotFoundException      If the table or related entities are not found.
     */
    @PreAuthorize("hasAuthority('POST')")
    @PostMapping
    @Operation(summary = "Create a new reservation", description = "Adds a new reservation with its information and returns a JSON object with the status code 201.")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation newReservation) throws InvalidReservationTimeException, TableAlreadyReservedException, InstanceNotFoundException {
        return ResponseEntity.status(201).body(reservationService.addReservation(newReservation));
    }

    /**
     * Updates an existing reservation.
     *
     * @param reservationId The ID of the reservation to update.
     * @param reservation   The updated reservation data.
     * @return The updated reservation object wrapped in a ResponseEntity with status code 200.
     * @throws InstanceNotFoundException      If the reservation with the specified ID is not found.
     * @throws InstanceAlreadyExistsException If a similar reservation already exists.
     * @throws InvalidReservationTimeException If the reservation time is invalid.
     * @throws TableAlreadyReservedException  If the table is already reserved.
     */
    @PreAuthorize("hasAuthority('PUT')")
    @PutMapping(value = "/{reservationId}")
    @Operation(summary = "Update a reservation", description = "Updates the information of an existing reservation and returns a JSON object with the status code 200.")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("reservationId") int reservationId, @RequestBody Reservation reservation) throws InstanceNotFoundException, InstanceAlreadyExistsException, InvalidReservationTimeException, TableAlreadyReservedException {
        return ResponseEntity.status(200).body(reservationService.updateReservation(reservation, reservationId));
    }

    /**
     * Deletes a reservation by its ID.
     *
     * @param reservationId The ID of the reservation to delete.
     * @return A success message indicating the reservation has been deleted.
     * @throws InstanceNotFoundException If the reservation with the specified ID is not found.
     */
    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{reservationId}")
    @Operation(summary = "Delete a reservation", description = "Removes a reservation using its ID and returns a message with the status code 200.")
    public String deleteDish(@PathVariable("reservationId") int reservationId) throws InstanceNotFoundException {
        reservationService.deleteReservation(reservationId);
        return "Reservation with ID " + reservationId + " was successfully deleted.";
    }

    /**
     * Handles InstanceNotFoundException.
     *
     * @param infe The exception to handle.
     * @return A ResponseEntity containing the error message with status code 404.
     */
    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<String> instanceNotFoundException(InstanceNotFoundException infe) {
        return ResponseEntity.status(404).body(infe.getMessage());
    }

    /**
     * Handles InstanceAlreadyExistsException.
     *
     * @param iaee The exception to handle.
     * @return A ResponseEntity containing the error message with status code 404.
     */
    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<String> instanceAlreadyExistException(InstanceAlreadyExistsException iaee) {
        return ResponseEntity.status(404).body(iaee.getMessage());
    }
}
