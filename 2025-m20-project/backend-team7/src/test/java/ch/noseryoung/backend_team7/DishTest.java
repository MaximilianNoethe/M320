package ch.noseryoung.backend_team7;

import ch.noseryoung.backend_team7.domain.dish.Dish;
import ch.noseryoung.backend_team7.domain.dish.strategy.*;

public class DishTest {
    public static void main(String[] args) {
        // Create dishes
        Dish pizza = new Dish(1, "Pizza", "Delicious cheese pizza", "image.jpg", "Italian", 15.0);
        Dish pasta = new Dish(2, "Pasta", "Tasty pasta dish", "image.jpg", "Italian", 12.0);

        // Set pricing strategies
        pizza.setPricingStrategy(new PercentageDiscountStrategy(20)); // 20% off
        pasta.setPricingStrategy(new FixedAmountDiscountStrategy(3)); // $3 off

        // Calculate final prices
        System.out.println(pizza.getDishName() + " Final Price: $" + pizza.getFinalPrice());
        System.out.println(pasta.getDishName() + " Final Price: $" + pasta.getFinalPrice());
    }
}
