package hardwarestore;

/**
 * Main class, reads from .dat files to fill ArrayLists
 * main database objects are created to pass to menu
 */
public class Main {

    public static void main(String[] args) {
        //Creates errors on first start up if not .dat files are present
        //Will still run just fine and create files after user enters 10

        Inventory inventory = new Inventory();
        UserDatabase userDatabase = new UserDatabase();
        MenuManager menu = new MenuManager();
        Transactions transactions = new Transactions();

        inventory.inputFromFile();
        userDatabase.inputFromFile();
        transactions.inputFromFile();

        menu.printMenu(inventory, userDatabase, transactions);

        inventory.writeToFile();
        userDatabase.writeToFile();
        transactions.writeToFile();
    }
}
