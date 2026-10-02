package foodstorage;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Represents an abstract base class for perishable items.
 *
 * This class manages core data fields for food items that expire over time.
 * It is defined as abstract to prevent direct instantiation, serving as
 * a foundation for specific subclasses.
 */
public abstract class PerishableItem {

    // Maximum allowed shelf life in days
    public static final int MAX_SHELF_LIFE_DAYS = 14;

    protected String name;
    protected double weightInGrams;
    protected LocalDate bestBeforeDate;
    protected LocalDateTime dateAdded;

    /**
     * Constructs a new PerishableItem with data validation.
     */
    public PerishableItem(String name, double weightInGrams, LocalDate bestBeforeDate)
            throws InvalidFoodDataException {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidFoodDataException("Food name cannot be empty.");
        }
        if (weightInGrams <= 0) {
            throw new InvalidFoodDataException("Weight must be greater than 0 grams.");
        }

        LocalDate today = LocalDate.now();
        LocalDate maxAllowedDate = today.plusDays(MAX_SHELF_LIFE_DAYS);
        if (bestBeforeDate == null || bestBeforeDate.isBefore(today) || bestBeforeDate.isAfter(maxAllowedDate)) {
            throw new InvalidFoodDataException(
                    "Best-before date must be between today and " + MAX_SHELF_LIFE_DAYS + " days from today.");
        }

        this.name = name.trim();
        this.weightInGrams = weightInGrams;
        this.bestBeforeDate = bestBeforeDate;
        this.dateAdded = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    // Returns the specific category of the perishable item
    public abstract String getCategory();
}