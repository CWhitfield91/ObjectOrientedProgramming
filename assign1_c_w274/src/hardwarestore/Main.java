package hardwarestore;

/**
 * The main driver class for the hardware package
 * Creates new instances of Inventory and MenuManager
 * for inventory and menu menthods
 */
public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        MenuManager menu = new MenuManager();

        inventory.inputFromFile();

        menu.printMenu(inventory);

        inventory.writeToFile();
    }
}
