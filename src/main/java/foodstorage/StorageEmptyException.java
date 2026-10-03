package foodstorage;

/**
 * Thrown when someone tries to remove or peek at a food item,
 * but the storage is completely empty (no trays).
 */
public class StorageEmptyException extends Exception {

    public StorageEmptyException(String message) {
        super(message);
    }
}