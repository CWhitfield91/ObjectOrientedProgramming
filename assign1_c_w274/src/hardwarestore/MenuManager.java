package hardwarestore;

import java.util.Scanner;

/**
 * Prints the menu and manages user input
 */
public class MenuManager {

    public void printMenu(Inventory inventory){

        int choice;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("1: Show all existing items in stock and their existing quantities.");
            System.out.println("2. Add a new quantity of a specific item to the stock.");
            System.out.println("3. Remove a certain quantity of a specific item type.");
            System.out.println("4. Search for an item (given its name or part of its name).");
            System.out.println("5. Show a list of all items below a certain quantity.");
            System.out.println("6. Exit program.");
            System.out.print("Please select a choice: ");
            choice = scanner.nextInt();

            switch (choice){

                case (1):
                    inventory.print();
                    System.out.println();
                    break;

                case (2):
                    System.out.print("Please enter item name: ");
                    Scanner scName = new Scanner(System.in);
                    String name = scName.nextLine();

                    System.out.print("Please enter amount added: ");
                    Scanner scQuantity = new Scanner(System.in);
                    int update = scQuantity.nextInt();

                    inventory.addQuantity(name, update);
                    break;

                case (3):
                    System.out.print("Please enter item name: ");
                    Scanner scanName = new Scanner(System.in);
                    String itemName = scanName.nextLine();

                    System.out.print("Please enter amount removed: ");
                    Scanner scanQuantity = new Scanner(System.in);
                    int subtract = scanQuantity.nextInt();

                    inventory.subtractQuantity(itemName, subtract);
                    break;

                case (4):
                    System.out.print("Please enter the item you wish to look up: ");
                    Scanner scItem = new Scanner(System.in);
                    String itemLookup = scItem.nextLine();

                    inventory.itemSearch(itemLookup);
                    System.out.println();
                    break;

                case (5):
                    System.out.print("Under which quantity do you wish to show?: ");
                    Scanner scUnderQuantity = new Scanner(System.in);
                    int listQuantity = scUnderQuantity.nextInt();

                    inventory.itemsUnderQuantity(listQuantity);
                    System.out.println();
                    break;

            }

        } while (choice != 6);
    }
}
