package foodstorage;

/**
 * This is the storage unit itself.
 *
 * We chose a DEQUE (Double-Ended Queue) because the chef can use only the front side to add AND remove (Stack behaviour, LIFO), 
 * or add on the front side and remove from the back side (Queue behaviour, FIFO).
 *
 * A normal Stack or a normal Queue can not do both things,
 * but a Deque can, because we can add and remove at both ends.
 *
 * We built the Deque with a doubly linked list
 * (the private Node class below), instead of using java.util.ArrayDeque.
 * This way we can show how the data structure works internally.
 */
public class FoodStorage implements StorageOperations {

    // maximum number of trays that the storage unit can hold
    public static final int MAX_CAPACITY = 8;

    // Each node keeps one tray (FoodItem) and two links:
    // prev = the node before it, next = the node after it.
    // It is private because only FoodStorage needs to use it.
    private class Node {
        FoodItem data;
        Node prev;
        Node next;

        // the links start as null and we set them when we add the node
        Node(FoodItem data) {
            this.data = data;
        }
    }

    private Node front;  // first node of the list (null if the storage is empty)
    private Node back;   // last node of the list (null if the storage is empty)
    private int count;   // how many trays we have now

    // Starts an empty storage: no nodes and zero trays
    public FoodStorage() {
        front = null;
        back = null;
        count = 0;
    }

    @Override
    public void addFront(FoodItem item) throws StorageFullException {
        // TODO
    }

    @Override
    public void addBack(FoodItem item) throws StorageFullException {
        // TODO
    }

    @Override
    public FoodItem removeFront() throws StorageEmptyException {
        // TODO
        return null;
    }

    @Override
    public FoodItem removeBack() throws StorageEmptyException {
        // TODO
        return null;
    }

    @Override
    public FoodItem peekFront() throws StorageEmptyException {
        // TODO
        return null;
    }

    @Override
    public FoodItem searchByName(String name) {
        // TODO
        return null;
    }

    @Override
    public void displayAll() {
        // TODO
    }

    // The storage is empty when we have zero trays
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    // The storage is full when we reach the maximum capacity (8 trays)
    @Override
    public boolean isFull() {
        return count == MAX_CAPACITY;
    }

    // Returns how many trays are in the storage now
    @Override
    public int size() {
        return count;
    }
}
