package foodstorage;
import java.util.Scanner;

public class FoodStorageApp {

    private static Scanner scanner = new Scanner(System.in);
    //Connect FoodStorage when the class is ready
    private static FoodStorage storage = new FoodStorage;

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Fast Food Storage - CA1 (Deque)");

        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
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
}