package foodstorage;

/**
 * Operations that our storage unit must support (add, remove, peek,
 * search and display), based on the assignment brief.
 * We use an interface so other classes only depend on WHAT the storage
 * does, and not on HOW it is implemented.
 */

public interface StorageOperations {

    void addFront(FoodItem item) throws StorageFullException;

    void addBack(FoodItem item) throws StorageFullException;

    FoodItem removeFront() throws StorageEmptyException;

    FoodItem removeBack() throws StorageEmptyException;

    FoodItem peekFront() throws StorageEmptyException;

    FoodItem searchByName(String name);

    void displayAll();

    boolean isEmpty();

    boolean isFull();

    int size();
}
