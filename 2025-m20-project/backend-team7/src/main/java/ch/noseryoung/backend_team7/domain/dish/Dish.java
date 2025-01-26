package ch.noseryoung.backend_team7.domain.dish;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import ch.noseryoung.backend_team7.domain.dish.strategy.*;

/**
 * Entity class representing a Dish.
 * Contains attributes and methods related to a dish, including pricing and formatting logic.
 */
@Entity
@Getter
@Setter
@Table(name = "dish")
public class Dish {

    /**
     * The unique identifier for the dish.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int dishId;

    /**
     * The name of the dish.
     * Must not be blank and must contain less than 100 characters.
     */
    @Column(name = "dish_name")
    @NotBlank(message = "Dish name cannot be blank")
    @Size(max = 100, message = "Dish name must be less than 100 characters")
    private String dishName;

    /**
     * The description of the dish.
     * Must contain less than 300 characters.
     */
    @Column(name = "description")
    @Size(max = 300, message = "Description must be less than 255 characters")
    private String description;

    /**
     * The URL or path to the image of the dish.
     */
    @Column(name = "image")
    private String image;

    /**
     * Indicates whether the dish is a chef's choice.
     */
    @Column(name = "is_chefs_choice")
    private boolean isChefsChoice;

    /**
     * The region associated with the dish.
     * Must contain less than 100 characters.
     */
    @Column(name = "region")
    @Size(max = 100, message = "Region must be less than 100 characters")
    private String region;

    /**
     * The price of the dish.
     * Must not be null and must be a positive value.
     */
    @Column(name = "price")
    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be a positive value")
    private Double price;

    /**
     * The pricing strategy applied to the dish.
     * Transient field, not persisted in the database.
     */
    @Transient
    @JsonIgnore
    private PricingStrategy pricingStrategy = new NoDiscountStrategy(); // Default strategy

    /**
     * Calculates the final price of the dish based on the applied pricing strategy.
     *
     * @return the final price after applying the strategy.
     */
    public double getFinalPrice() {
        return pricingStrategy.calculatePrice(this);
    }

    /**
     * Sets the pricing strategy for the dish.
     *
     * @param pricingStrategy the {@link PricingStrategy} to apply.
     */
    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    /**
     * Gets the formatted price of the dish.
     * Includes the target currency if the pricing strategy is a {@link ForeignExchange} strategy.
     *
     * @return the formatted price as a {@link String}.
     */
    public String getFormattedPrice() {
        if (pricingStrategy instanceof ForeignExchange) {
            ForeignExchange fx = (ForeignExchange) pricingStrategy;
            return String.format("%.2f %s", getFinalPrice(), ((ForexDiscount) fx).getTargetCurrency());
        }
        return String.format("%.2f USD", getFinalPrice()); // Default currency
    }
}
