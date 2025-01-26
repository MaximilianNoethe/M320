package ch.noseryoung.backend_team7.domain.dish.strategy;

import ch.noseryoung.backend_team7.domain.dish.Dish;

public class NoDiscountStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Dish dish) {
        return dish.getPrice();
    }
}