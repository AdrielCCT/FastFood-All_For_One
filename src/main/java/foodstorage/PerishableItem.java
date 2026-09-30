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
}