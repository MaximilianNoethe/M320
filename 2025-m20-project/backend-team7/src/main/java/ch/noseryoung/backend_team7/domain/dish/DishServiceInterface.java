package ch.noseryoung.backend_team7.domain.dish;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;

public interface DishServiceInterface {
    List<Dish> getAllDishes();
    Dish getById(int dishId) throws InstanceNotFoundException;
    Dish addDish(Dish newDish) throws InstanceAlreadyExistsException;
    Dish updateById(int dishId, Dish dish) throws InstanceNotFoundException;
    void deleteDish(int id) throws InstanceNotFoundException;
}
