package hardwarestore;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that manages the inventory of the Hardware Store.
 */
public class Inventory {

    /**
     * An arraylist that contains object of class Item
     * that holds item information.
     */
    private ArrayList<Item> itemsInList = new ArrayList<Item>();

    /**
     * Adds an object item to the arraylist
     * @param item and object of class Item that is added
     *             to the arraylist
     */
    public void addItem(Item item){
        itemsInList.add(item);
    }

    /**
     * Prints the current contents of the arraylist to
       the screen.
     */
    public void print(){
        System.out.format("%12s %20s %32s %18s %11s ",
                "ID Number", "Name", "Category", "Quantity", "Price");
        System.out.println();
        for (Item items : itemsInList){
            System.out.format(String.format("%10s          %17s          %20s" +
                            " %15d          %.2f",
                    items.getIdNumber(),
                    items.getName(),
                    items.getCategory(),
                    items.getQuantity(),
                    items.getPrice()));
            System.out.println();
        }
    }

    /**
     * Updates the quantity via addition of a specific item object
     * @param name name of the item object
     * @param update tells how much should be added to current
     *               quantity
     */
    public void addQuantity (String name, int update){
        for (Item items : itemsInList){
            if (items.getName().equals(name)){
                update = items.getQuantity() + update;
                items.setQuantity(update);
            }
        }
    }

    /**
     * Updates the quantity via subtraction of a specific item object
     * @param name the name of the item object
     * @param subtract tells how much should be subtracted from current
     *                 quantity
     */
    public void subtractQuantity (String name, int subtract){
        for (Item items : itemsInList){
            if (items.getName().equals(name)){
                subtract = items.getQuantity() - subtract;
                items.setQuantity(subtract);
            }
        }
    }

    /**
     * searches for a specific item object given part or all
     * of its name
     * @param name the part or whole of the object name
     */
    public void itemSearch (String name){
        for (Item items : itemsInList){
            if (items.getName().contains(name)){
                System.out.println(items.getIdNumber() + " " + items.getName() + " "
                      + items.getCategory() + " " + items.getQuantity() + " "
                       + items.getPrice());
            }
        }
    }

    /**
     * Lists all current item objects under a certain quantity
     * @param under the quantity in which all objects listed
     *              should be under
     */
    public void itemsUnderQuantity (int under){
        System.out.format("%5s %12s %28s %15s %10s",
                "ID Number", "Name" , "Category",
                "Quantity", "Price");
        System.out.println();

        for (Item items : itemsInList){
            if (items.getQuantity() < under){
                System.out.format("%5s %20s %25s %11d %13.2f", items.getIdNumber(),
                        items.getName(), items.getCategory(),
                        items.getQuantity(), items.getPrice());
                System.out.println();
            }
        }
    }

    /**
     * Overwrites the database.txt file with information that is
     * currently stored in the arraylist
     */
    public void writeToFile() {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("database.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter outputFile = new PrintWriter(fileWriter);

        for (Item items : itemsInList) {
            outputFile.println(items.getIdNumber() + "~" + items.getName() + "~"
                    + items.getCategory() + "~" + items.getQuantity() + "~" +
                    items.getPrice());
        }

        outputFile.close();
    }

    /**
     * Reads from the database.txt file and populates the arraylist
     * with item objects
     */
    public void inputFromFile(){

        try{
            FileReader fileReader = new FileReader("database.txt");
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split("~");

                String id = words[0];
                String name = words[1];
                String category = words[2];
                int quan = Integer.parseInt(words[3]);
                float price = Float.parseFloat(words[4]);

                Item item = new Item(id, name, category, quan, price);

                addItem(item);

            }


        } catch(FileNotFoundException ex){
            System.out.println("File not found.");
        }
    }
}
