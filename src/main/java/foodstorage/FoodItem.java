package foodstorage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A single fast-food item that goes on a tray in the storage unit
 * (like a Burger, Pizza, Fries, Sandwich, or Hotdog).
 *
 * FoodItem extends PerishableItem, so it reuses all the shared fields and
 * validation from the parent class (showing off inheritance for the assignment!).
 */
public class FoodItem extends PerishableItem {

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public FoodItem(String name, double weightInGrams, LocalDate bestBeforeDate)
            throws InvalidFoodDataException {
        super(name, weightInGrams, bestBeforeDate);
    }

    @Override
    public String getCategory() {
        return "Fast Food Item";
    }

    @Override
    public String toString() {
        return name + " - " + weightInGrams + "g"
                + " | Best before: " + bestBeforeDate
                + " | Added at: " + dateAdded.format(TIME_FORMAT);
    }
}
