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
        // first, check if there is space. If not, stop and throw the exception
        if (isFull()) {
            throw new StorageFullException("Storage is full! Maximum of " + MAX_CAPACITY + " trays reached.");
        }
        // create the new node that will keep the tray
        Node newNode = new Node(item);
        if (isEmpty()) {
            // first tray: the new node is the front and the back at the same time
            front = newNode;
            back = newNode;
        } else {
            newNode.next = front;  // the new node points to the old front
            front.prev = newNode;  // the old front points back to the new node
            front = newNode;       // now the new node is the front
        }
        count++; // one more tray in the storage
    }

    @Override
    public void addBack(FoodItem item) throws StorageFullException {
        // first, check if there is space. If not, stop and throw the exception
        if (isFull()) {
            throw new StorageFullException("Storage is full! Maximum of " + MAX_CAPACITY + " trays reached.");
        }
        // create the new node that will keep the tray
        Node newNode = new Node(item);
        if (isEmpty()) {
            // first tray: the new node is the front and the back at the same time
            front = newNode;
            back = newNode;
        } else {
            newNode.prev = back;  // the new node points to the old back
            back.next = newNode;  // the old back points forward to the new node
            back = newNode;       // now the new node is the back
        }
        count++; // one more tray in the storage
    }

    @Override
    public FoodItem removeFront() throws StorageEmptyException {
        // we can not remove anything from an empty storage
        if (isEmpty()) {
            throw new StorageEmptyException("Storage is empty! There is nothing to remove.");
        }
        // save the tray first, because we need to return it at the end
        FoodItem removed = front.data;
        front = front.next;  // the second node becomes the new front
        if (front != null) {
            front.prev = null;  // the new front must not point back to the old one
        } else {
            back = null; // storage became empty
        }
        count--; // one less tray in the storage
        return removed;
    }

    @Override
    public FoodItem removeBack() throws StorageEmptyException {
        // we can not remove anything from an empty storage
        if (isEmpty()) {
            throw new StorageEmptyException("Storage is empty! There is nothing to remove.");
        }
        // save the tray first, because we need to return it at the end
        FoodItem removed = back.data;
        back = back.prev;  // the node before the back becomes the new back
        if (back != null) {
            back.next = null;  // the new back must not point forward to the old one
        } else {
            front = null; // storage became empty
        }
        count--; // one less tray in the storage
        return removed;
    }

    @Override
    public FoodItem peekFront() throws StorageEmptyException {
        // there is no front tray if the storage is empty
        if (isEmpty()) {
            throw new StorageEmptyException("Storage is empty! There is nothing at the front.");
        }
        // only return the tray, we do not remove it from the list
        return front.data;
    }

    @Override
    public FoodItem searchByName(String name) {
        // start at the front and walk to the back, one node at a time
        Node current = front;
        while (current != null) {
            if (current.data.getName().equalsIgnoreCase(name)) {
                return current.data;  // found it, so we can stop
            }
            current = current.next;  // go to the next node
        }
        return null; // we checked all the trays and did not find the name
    }

    @Override
    public void displayAll() {
        if (isEmpty()) {
            System.out.println("The storage is empty. No trays to show.");
            return;
        }
        System.out.println("---- Trays currently in storage (front -> back) ----");
        Node current = front;
        int position = 1;  // used to number the trays: 1, 2, 3...
        while (current != null) {
            System.out.println(position + ". " + current.data);
            current = current.next;  // go to the next node
            position++;
        }
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
