package foodstorage;

/**
 * Thrown when someone tries to remove or peek at a food item,
 * but the storage is completely empty (no trays).
 */
public class StorageEmptyException extends Exception {

    /**
     * @param message explains that there were no trays to remove/peek
     */

    public StorageEmptyException(String message) {
        super(message);
    }
}