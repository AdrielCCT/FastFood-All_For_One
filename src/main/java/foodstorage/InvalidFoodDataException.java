package foodstorage;

/**
 * Thrown when someone inputs invalid food data
 * (like an empty name, weight <= 0, or a best-before date outside the 0 to 14 days range).
 */
public class InvalidFoodDataException extends Exception {

    public InvalidFoodDataException(String message) {
        super(message);
    }
}