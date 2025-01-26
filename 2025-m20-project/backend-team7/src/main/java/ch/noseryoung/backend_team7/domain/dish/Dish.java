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

@Entity
@Getter
@Setter
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int dishId;

    @Column(name = "dish_name")
    @NotBlank(message = "Dish name cannot be blank")
    @Size(max = 100, message = "Dish name must be less than 100 characters")
    private String dishName;

    @Column(name = "description")
    @Size(max = 300, message = "Description must be less than 255 characters")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "is_chefs_choice")
    private boolean isChefsChoice;

    @Column(name = "region")
    @Size(max = 100, message = "Region must be less than 100 characters")
    private String region;

    @Column(name = "price")
    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be a positive value")
    private Double price;

    @Transient
    @JsonIgnore
    private PricingStrategy pricingStrategy = new NoDiscountStrategy(); // Default strategy

    public double getFinalPrice() {
        return pricingStrategy.calculatePrice(this);
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public String getFormattedPrice() {
        if (pricingStrategy instanceof ForeignExchange) {
            ForeignExchange fx = (ForeignExchange) pricingStrategy;
            return String.format("%.2f %s", getFinalPrice(), ((ForexDiscount) fx).getTargetCurrency());
        }
        return String.format("%.2f USD", getFinalPrice()); // Default currency
    }
}