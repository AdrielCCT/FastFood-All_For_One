package foodstorage;

/**
 * Thrown when someone tries to add a food item, but the storage
 * has already hit the max limit of 8 trays.
 */
public class StorageFullException extends Exception {

    /**
     * @param message explains that the 8-tray limit was reached
     */

    public StorageFullException(String message) {
        super(message);
    }
}