package ch.noseryoung.backend_team7;

import ch.noseryoung.backend_team7.domain.dish.Dish;
import ch.noseryoung.backend_team7.domain.dish.strategy.*;

public class DishTest {
    public static void main(String[] args) {
        // Create a Dish
        Dish sushi = new Dish();
        sushi.setDishName("Sushi");
        sushi.setPrice(20.0);

        // Apply ForexDiscount strategy
        ForexDiscount forexDiscount = new ForexDiscount(10, 0.85, "EUR"); // 10% off, convert to EUR
        sushi.setPricingStrategy(forexDiscount);

        // Display Final Price
        System.out.println(sushi.getDishName() + " Final Price: " + sushi.getFormattedPrice());
    }
}
