package ch.noseryoung.backend_team7.domain.dish.strategy;

import ch.noseryoung.backend_team7.domain.dish.Dish;

public class FixedAmountDiscountStrategy implements PricingStrategy {
    private double discountAmount;

    public FixedAmountDiscountStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculatePrice(Dish dish) {
        return Math.max(0, dish.getPrice() - discountAmount);
    }
}
