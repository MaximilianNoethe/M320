package ch.noseryoung.backend_team7.domain.dish.strategy;

import ch.noseryoung.backend_team7.domain.dish.Dish;

public class ForexDiscount implements PricingStrategy, ForeignExchange {
    private double discountPercentage;
    private double exchangeRate; // Rate to convert to target currency
    private String targetCurrency;

    public ForexDiscount(double discountPercentage, double exchangeRate, String targetCurrency) {
        this.discountPercentage = discountPercentage;
        this.exchangeRate = exchangeRate;
        this.targetCurrency = targetCurrency;
    }

    // Implement PricingStrategy
    @Override
    public double calculatePrice(Dish dish) {
        // Apply percentage discount
        double discountedPrice = dish.getPrice() * (1 - discountPercentage / 100);
        return convertToTargetCurrency(discountedPrice, targetCurrency);
    }

    // Implement ForeignExchange
    @Override
    public double convertToTargetCurrency(double price, String targetCurrency) {
        // Simulate conversion using the exchange rate
        return price * exchangeRate;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }
}
