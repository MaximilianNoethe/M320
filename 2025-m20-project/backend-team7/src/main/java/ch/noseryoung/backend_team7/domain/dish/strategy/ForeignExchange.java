package ch.noseryoung.backend_team7.domain.dish.strategy;

public interface ForeignExchange {
    double convertToTargetCurrency(double price, String targetCurrency);
}

