package ch.noseryoung.backend_team7.domain.dish;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;

/**
 * Interface for defining operations on {@link Dish} entities.
 * Provides the contract for CRUD operations.
 */
public interface DishServiceInterface {

    /**
     * Retrieves all dishes.
     *
     * @return a list of all {@link Dish} objects.
     */
    List<Dish> getAllDishes();

    /**
     * Retrieves a dish by its ID.
     *
     * @param dishId the ID of the dish to retrieve.
     * @return the {@link Dish} object with the given ID.
     * @throws InstanceNotFoundException if no dish with the given ID is found.
     */
    Dish getById(int dishId) throws InstanceNotFoundException;

    /**
     * Adds a new dish.
     *
     * @param newDish the {@link Dish} object to add.
     * @return the added {@link Dish} object.
     * @throws InstanceAlreadyExistsException if the dish already exists.
     */
    Dish addDish(Dish newDish) throws InstanceAlreadyExistsException;

    /**
     * Updates an existing dish by its ID.
     *
     * @param dishId the ID of the dish to update.
     * @param dish the updated {@link Dish} object.
     * @return the updated {@link Dish} object.
     * @throws InstanceNotFoundException if no dish with the given ID is found.
     */
    Dish updateById(int dishId, Dish dish) throws InstanceNotFoundException;

    /**
     * Deletes a dish by its ID.
     *
     * @param id the ID of the dish to delete.
     * @throws InstanceNotFoundException if no dish with the given ID is found.
     */
    void deleteDish(int id) throws InstanceNotFoundException;
}
