package ch.noseryoung.backend_team7.domain.dish.strategy;

import ch.noseryoung.backend_team7.domain.dish.Dish;

// Strategy Interface
public interface PricingStrategy {
    double calculatePrice(Dish dish);
}
