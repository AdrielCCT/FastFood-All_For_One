package foodstorage;
import java.time.LocalDate;
import java.util.Scanner;

public class FoodStorageApp {

    private static Scanner scanner = new Scanner(System.in);
    //Connect FoodStorage when the class is ready
    private static FoodStorage storage = new FoodStorage();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Fast Food Storage - CA1 (Deque)");

        //main menu looping
        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addItem(true); // add to front
                    break;
                case "2":
                    addItem(false); // add to back
                    break;
                case "3":
                    removeFront();
                    break;
                case "4":
                    removeBack();
                    break;
                case "5":
                    peekFront();
                    break;
                case "6":
                    search();
                    break;
                case "7":
                    System.out.println("Option " + choice + " is not ready yet");
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting system. Goodbye");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }

    //print the available options to the terminal
    private static void showMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1 - Add food to front");
        System.out.println("2 - Add food to back");
        System.out.println("3 - Remove food from front");
        System.out.println("4 - Remove food from back");
        System.out.println("5 - Check front item");
        System.out.println("6 - Search food by name");
        System.out.println("7 - Show all items");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    //reads the food details from the terminal and adds it to the front or back of the storage
    private static void addItem(boolean addToFront) {
        try {
            System.out.print("Food name (Burger, Pizza, Fries, etc): ");
            String name = scanner.nextLine().trim();

            System.out.print("Weight (grams): ");
            double weight = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Days until expiration (0 to 14): ");
            int days = Integer.parseInt(scanner.nextLine().trim());
            //calculates the expiry date from today's date
            LocalDate expiryDate = LocalDate.now().plusDays(days);

            //create new FoodItem object
            FoodItem item = new FoodItem(name, weight, expiryDate);

            //where to insert the item
            if (addToFront) {
                storage.addFront(item);
            } else {
                storage.addBack(item);
            }

            System.out.println("Success ! Item was added to storage.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Weight and days must be valid numbers.");
        } catch (InvalidFoodDataException | StorageFullException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // removes the item from the front of the storage
    private static void removeFront() {
        try {
            FoodItem removed = storage.removeFront();
            System.out.println("Removed from front: " + removed);
        } catch (StorageEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // removes the item from the back of the storage
    private static void removeBack() {
        try {
            FoodItem removed = storage.removeBack();
            System.out.println("Removed from back: " + removed);
        } catch (StorageEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // looks at the item at the front without removing it
    private static void peekFront() {
        try {
            FoodItem item = storage.peekFront();
            System.out.println("First item: " + item);
        } catch (StorageEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // searches for an item in storage by name
    private static void search() {
        System.out.print("Enter food name to search: ");
        String name = scanner.nextLine().trim();
        FoodItem item = storage.searchByName(name);

        if (item != null) {
            System.out.println("Found: " + item);
        } else {
            System.out.println("No item called \"" + name + "\" found.");
        }
    }
}