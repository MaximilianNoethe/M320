package ch.noseryoung.backend_team7.domain.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import java.util.List;

@Service
public class DishService implements DishServiceInterface {
    @Autowired
    private DishDelegate dishDelegate;

    @Autowired
    private DishRepository dishRepository;

    public DishService() {
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getById(int dishId) throws InstanceNotFoundException {
        return dishRepository.findById(dishId)
                .orElseThrow(() -> new InstanceNotFoundException("Dish with id " + dishId + " could not be found."));
    }

    @Override
    public Dish addDish(Dish newDish) throws InstanceAlreadyExistsException {
        return dishDelegate.addDish(newDish);
    }

    @Override
    public Dish updateById(int dishId, Dish dish) throws InstanceNotFoundException {
        if (!dishRepository.existsById(dishId)) {
            throw new InstanceNotFoundException("Dish with id " + dishId + " could not be found.");
        }
        dish.setDishId(dishId);
        return dishRepository.save(dish);
    }

    @Override
    public void deleteDish(int id) throws InstanceNotFoundException {
        if (!dishRepository.existsById(id)) {
            throw new InstanceNotFoundException("Dish with id " + id + " could not be found.");
        }
        dishRepository.deleteById(id);
    }
}
