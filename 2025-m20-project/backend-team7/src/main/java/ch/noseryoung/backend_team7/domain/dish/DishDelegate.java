package ch.noseryoung.backend_team7.domain.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.InstanceAlreadyExistsException;

/**
 * Delegate class for managing {@link Dish} entities.
 * Provides helper methods for performing operations on dishes.
 */
@Component
public class DishDelegate {

    @Autowired
    private DishRepository dishRepository;

    /**
     * Adds a new dish to the repository.
     *
     * @param newDish the {@link Dish} object to add.
     * @return the added {@link Dish} object.
     * @throws InstanceAlreadyExistsException if a dish with the same ID already exists in the repository.
     */
    public Dish addDish(Dish newDish) throws InstanceAlreadyExistsException {
        if (dishRepository.existsById(newDish.getDishId())) {
            throw new InstanceAlreadyExistsException("Dish with id " + newDish.getDishId() + " already exists.");
        }
        return dishRepository.save(newDish);
    }
}
