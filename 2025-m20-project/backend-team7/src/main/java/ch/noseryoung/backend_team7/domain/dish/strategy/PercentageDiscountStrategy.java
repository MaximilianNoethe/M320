package ch.noseryoung.backend_team7.domain.dish.strategy;

import ch.noseryoung.backend_team7.domain.dish.Dish;

public class PercentageDiscountStrategy implements PricingStrategy {
    private double discountPercentage;

    public PercentageDiscountStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(Dish dish) {
        return dish.getPrice() * (1 - discountPercentage / 100);
    }
}

