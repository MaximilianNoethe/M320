package ch.noseryoung.backend_team7.domain.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.InstanceAlreadyExistsException;


@Component
public class DishDelegate {
    @Autowired
    private DishRepository dishRepository;

    public Dish addDish(Dish newDish) throws InstanceAlreadyExistsException {
        if (dishRepository.existsById(newDish.getDishId())) {
            throw new InstanceAlreadyExistsException("Dish with id " + newDish.getDishId() + " already exists.");
        }
        return dishRepository.save(newDish);
    }


}
