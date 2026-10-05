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
     * Constructs a new perishable item, validating all input parameters
     * prior to initialization.
     *
     * @param name            The name of the item; must not be null or blank.
     * @param weightInGrams   The weight of the item in grams; must be greater than zero.
     * @param bestBeforeDate  The expiration date; must fall between today and
     *                        {@link #MAX_SHELF_LIFE_DAYS} days from today.
     * @throws InvalidFoodDataException If any of the provided parameters fail validation.
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
    /** @return the item's name */
    public String getName() {
        return name;
    }
    /** @return the item's weight in grams */
    public double getWeightInGrams() {
        return weightInGrams;
    }
    /** @return the last day the item is still good to serve */
    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }
    /** @return the exact date/time the item was placed in storage */
    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    /**
     * Every subclass must say what kind of perishable item it is
     * (e.g. FoodItem returns "Fast Food Item"). This is where the
     * abstract class forces each subclass to add its own behaviour.
     *
     * @return a short description of the item's category
     */

    public abstract String getCategory();
}