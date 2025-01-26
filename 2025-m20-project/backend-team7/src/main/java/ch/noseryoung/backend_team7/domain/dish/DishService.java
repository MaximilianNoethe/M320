package ch.noseryoung.backend_team7.domain.dish;

import ch.noseryoung.backend_team7.domain.dish.strategy.ForexDiscount;
import ch.noseryoung.backend_team7.domain.dish.strategy.PricingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;

/**
 * Service class for managing {@link Dish} entities.
 * Provides business logic for CRUD operations and applying pricing strategies.
 */
@Service
public class DishService implements DishServiceInterface {

    @Autowired
    private DishDelegate dishDelegate;

    @Autowired
    private DishRepository dishRepository;

    /**
     * Default constructor for {@link DishService}.
     */
    public DishService() {
    }

    /**
     * Retrieves all dishes from the repository.
     *
     * @return a list of all {@link Dish} objects.
     */
    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    /**
     * Retrieves a dish by its ID.
     *
     * @param dishId the ID of the dish to retrieve.
     * @return the {@link Dish} object with the given ID.
     * @throws InstanceNotFoundException if no dish with the given ID is found.
     */
    @Override
    public Dish getById(int dishId) throws InstanceNotFoundException {
        return dishRepository.findById(dishId)
                .orElseThrow(() -> new InstanceNotFoundException("Dish with id " + dishId + " could not be found."));
    }

    /**
     * Adds a new dish to the repository.
     *
     * @param newDish the {@link Dish} object to add.
     * @return the added {@link Dish} object.
     * @throws InstanceAlreadyExistsException if the dish already exists.
     */
    @Override
    public Dish addDish(Dish newDish) throws InstanceAlreadyExistsException {
        return dishDelegate.addDish(newDish);
    }

    /**
     * Updates an existing dish by its ID.
     *
     * @param dishId the ID of the dish to update.
     * @param dish the updated {@link Dish} object.
     * @return the updated {@link Dish} object.
     * @throws InstanceNotFoundException if no dish with the given ID is found.
     */
    @Override
    public Dish updateById(int dishId, Dish dish) throws InstanceNotFoundException {
        if (!dishRepository.existsById(dishId)) {
            throw new InstanceNotFoundException("Dish with id " + dishId + " could not be found.");
        }
        dish.setDishId(dishId);
        return dishRepository.save(dish);
    }

    /**
     * Deletes a dish by its ID.
     *
     * @param id the ID of the dish to delete.
     * @throws InstanceNotFoundException if no dish with the given ID is found.
     */
    @Override
    public void deleteDish(int id) throws InstanceNotFoundException {
        if (!dishRepository.existsById(id)) {
            throw new InstanceNotFoundException("Dish with id " + id + " could not be found.");
        }
        dishRepository.deleteById(id);
    }

    /**
     * Applies a pricing strategy to a dish.
     *
     * @param dishId the ID of the dish to which the strategy is applied.
     * @param strategy the {@link PricingStrategy} to apply.
     * @throws IllegalArgumentException if the dish with the given ID is not found.
     */
    public void applyPricingStrategy(int dishId, PricingStrategy strategy) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Dish not found"));
        dish.setPricingStrategy(strategy);
        dishRepository.save(dish);
    }

    /**
     * Applies a forex discount strategy to a dish.
     *
     * @param dishId the ID of the dish to which the discount is applied.
     * @param discountPercentage the discount percentage to apply.
     * @param exchangeRate the exchange rate to apply.
     * @param targetCurrency the target currency for the discount.
     * @throws IllegalArgumentException if the dish with the given ID is not found.
     */
    public void applyForexDiscount(int dishId, double discountPercentage, double exchangeRate, String targetCurrency) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Dish not found"));

        dish.setPricingStrategy(new ForexDiscount(discountPercentage, exchangeRate, targetCurrency));
        dishRepository.save(dish);
    }
}
