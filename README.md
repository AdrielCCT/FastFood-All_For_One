FoodDeque - CA1 (CCT College Dublin)  
Team: All For One  

Members:  
Adriel Kampa de Gois (2024378)  
Thaisa Braga Pereira (2024239)
Andre Luiz de Carvalho Filho (2024290)

Module: Algorithms, Architecture and Design Patterns (3rd Year)  

Overview  
FoodDeque is a Java console program for managing storage in a fast-food place. The app keeps food trays such as Burger, Pizza, Fries, Sandwich, and Hotdog. It uses access from both ends, meaning the front and the back can be used.  

Kitchen staff can work with the storage in two ways.  
1) Stack style, which is LIFO. In this mode, items are taken and added only from the front.  
2) Queue style, which is FIFO. In this mode, items go in at the front, then are taken out at the back.  

The main logic is in FoodStorage. It records each tray’s name, weight, best-before date, and the time it was added.  

Project Highlights  
Custom Deque Build  
This deque is made from scratch. It uses a doubly linked list with a Node class. The goal is to keep push and pop actions at both ends in constant time.  

Capacity Limit  
The storage can hold up to 8 trays. If more than 8 are added, a custom StorageFullException is raised.  

Input Checks  
Weights must be more than 0 g. Best-before dates must be within 14 days, using LocalDate. If the data fails these rules, it throws InvalidFoodDataException.  

Empty Checks  
If the storage is empty, methods like removeFront, removeBack, and peekFront throw StorageEmptyException. This avoids cases where the code tries to use a null value.  

Object Design  
There is an abstract class named PerishableItem. It holds shared fields and common validation rules. There is also a StorageOperations interface. This separates how the logic is defined from how it is implemented.  

Project Structure
src/
├── main/java/foodstorage/
│   ├── PerishableItem.java           # Abstract base class (shared attributes & validation)
│   ├── FoodItem.java                 # Concrete food item implementation
│   ├── StorageOperations.java        # Interface defining storage contract
│   ├── FoodStorage.java              # Custom Deque implementation (doubly linked list)
│   ├── InvalidFoodDataException.java # Custom exception for invalid input parameters
│   ├── StorageFullException.java     # Custom exception for capacity overflow
│   ├── StorageEmptyException.java    # Custom exception for underflow operations
│   └── FoodStorageApp.java           # Console UI and main execution logic
└── test/java/foodstorage/
    └── FoodStorageTest.java          # JUnit 5 test suite
pom.xml                               # Maven build configuration

Requirements
Java: JDK 17 or higher

Build Tool: Maven (optional, plain javac supported)

IDE: NetBeans (recommended)

How to Run
Option 1: NetBeans IDE
Go to File > Open Project and select the project folder.

Right-click the project root and select Run.

To run tests, right-click the project and select Test.

Option 2: Maven (Command Line)
mvn compile exec:java   # Runs the application CLI
mvn test                # Runs JUnit tests

Option 3: Standard Java Compiler (No Maven required)
javac -d out src/main/java/foodstorage/*.java
java -cp out foodstorage.FoodStorageApp

Individual Contributions
Adriel: Developed PerishableItem, FoodItem, and custom exception classes.

Andre: Implemented StorageOperations interface and FoodStorage Deque structure.

Thaisa: Designed FoodStorageApp console UI, wrote JUnit tests, and created the project poster.

Repository
GitHub:https://github.com/AdrielCCT/FastFood-All_For_One
