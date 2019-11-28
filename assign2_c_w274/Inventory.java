package hardwarestore;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;

/**
 * A class that manages the inventory of the Hardware Store.
 */
public class Inventory {


    private ArrayList<SmallHardware> smallHardwares = new ArrayList<SmallHardware>();
    private ArrayList<Appliance> appliances = new ArrayList<Appliance>();

    /**
     * takes user input and adds a small hardware object to the smallHarwares ArrayList
     */
    public void addSmallHardware() {
        Scanner scanIdNumber = new Scanner(System.in);
        Scanner scanName = new Scanner(System.in);
        Scanner scanQuantity = new Scanner(System.in);
        Scanner scanPrice = new Scanner(System.in);
        Scanner scanCategory = new Scanner(System.in);

        System.out.print("Please enter ID Number: ");
        String idNumber = scanIdNumber.nextLine();

        System.out.print("Please enter item name: ");
        String name = scanName.nextLine();

        System.out.print("Please enter quantity: ");
        int quantity = scanQuantity.nextInt();

        System.out.print("Please enter price: ");
        float price = scanPrice.nextFloat();

        System.out.print("Please enter category: ");
        String category = scanCategory.nextLine();

        SmallHardware smallHardware = new SmallHardware(idNumber, name, quantity, price, category);
        smallHardwares.add(smallHardware);
    }

    /**
     * takes user input and adds an Appliance object to the appliances ArrayList
     */
    public void addAppliance() {
        Scanner scanIdNumber = new Scanner(System.in);
        Scanner scanName = new Scanner(System.in);
        Scanner scanQuantity = new Scanner(System.in);
        Scanner scanPrice = new Scanner(System.in);
        Scanner scanBrand = new Scanner(System.in);
        Scanner scanType = new Scanner(System.in);

        System.out.print("Please enter ID Number: ");
        String idNumber = scanIdNumber.nextLine();

        System.out.print("Please enter item name: ");
        String name = scanName.nextLine();

        System.out.print("Please enter quantity: ");
        int quantity = scanQuantity.nextInt();

        System.out.print("Please enter price: ");
        float price = scanPrice.nextFloat();

        System.out.print("Please enter brand: ");
        String brand = scanBrand.nextLine();

        System.out.print("Please enter type: ");
        String type = scanType.nextLine();

        Appliance appliance = new Appliance(idNumber, name, quantity, price, brand, type);
        appliances.add(appliance);
    }


    /**
     * Sorts the smallHardwares ArrayList in ascending order and prints the ArrayList
     */
    public void printSmallHardwares() {
        Collections.sort(smallHardwares, new Comparator<SmallHardware>() {
            @Override
            public int compare(SmallHardware o1, SmallHardware o2) {
                return o1.getIdNumber().compareTo(o2.getIdNumber());
            }
        });

        System.out.println("SMALL HARDWARE");
        System.out.format(String.format("%s %14s %14s %10s %17s",
                "Item Number", "Name", "  Quantity", "  Price", "  Category"));
        System.out.println();
        for (SmallHardware smallHardware : smallHardwares) {
            System.out.format(String.format("%s %21s %10d %12.2f %16s",
                    smallHardware.getIdNumber(),
                    smallHardware.getName(),
                    smallHardware.getQuantity(),
                    smallHardware.getPrice(),
                    smallHardware.getCategory()));
            System.out.println();
        }
    }

    /**
     * Sorts the appliances ArrayList in ascending order and prints the ArrayList
     */
    public void printAppliances() {
        Collections.sort(appliances, new Comparator<Appliance>() {
            @Override
            public int compare(Appliance o1, Appliance o2) {
                return o1.getIdNumber().compareTo(o2.getIdNumber());
            }
        });

        System.out.println("APPLIANCES");
        System.out.format(String.format("%s %14s %14s %10s %17s %15s",
                "Item Number", "Name", "  Quantity", "  Price", "Brand", "Type"));
        System.out.println();

        for (Appliance appliance : appliances) {
            System.out.format(String.format("%s %21s %10d %15.2f %17s %16s",
                    appliance.getIdNumber(),
                    appliance.getName(),
                    appliance.getQuantity(),
                    appliance.getPrice(),
                    appliance.getBrand(),
                    appliance.getType()));
            System.out.println();
        }
    }

    /**
     * Searches smallHardwares ArrayList and updates the quantity
     * @param name the name of smallHardware object to search for
     * @param update the objects new quantity
     */
    public void updateSmallHardwareQuantity (String name, int update){
        for (SmallHardware smallHardware : smallHardwares){
            if (smallHardware.getName().equals(name)){
                update = smallHardware.getQuantity() + update;
                smallHardware.setQuantity(update);
            }
        }
    }

    /**
     * Searches the appliances ArrayList and updates the quantity
     * @param name the name of appliance object to search for
     * @param update the objects new quantity
     */
    public void updateApplianceQuantity (String name, int update){
        for (Appliance appliance : appliances){
            if (appliance.getName().equals(name)){
                update = appliance.getQuantity() + update;
                appliance.setQuantity(update);
            }
        }
    }

    /**
     * Removes a smallHardware object from the smallHarwares ArrayList
     */
    public void removeSmallHardware() {
        Scanner scanItemName = new Scanner(System.in);
        System.out.print("Please enter ITEM NAME to be removed: ");
        String itemName = scanItemName.nextLine();

        for (SmallHardware smallHardware : smallHardwares){
            if (smallHardware.getName().equals(itemName)){
                smallHardwares.remove(smallHardware);
                break;
            }
        }
    }

    /**
     * Removes an appliance object from the appliances ArrayList
     */
    public void removeAppliance() {
        Scanner scanItemName = new Scanner(System.in);
        System.out.print("Please enter ITEM NAME to be removed: ");
        String itemName = scanItemName.nextLine();

        for (Appliance appliance : appliances){
            if (appliance.getName().equals(itemName)){
                appliances.remove(appliance);
                break;
            }
        }
    }

    /**
     * Searches for a smallHardware object by name and prints it out to the screen if found
     */
    public void lookUpSmallHardware (){
        Scanner scanItemName = new Scanner(System.in);
        System.out.print("Please enter item name: ");
        String itemName = scanItemName.nextLine();

        for (SmallHardware smallHardware : smallHardwares){
            if (smallHardware.getName().toLowerCase().equals(itemName)){
                System.out.println(smallHardware.getIdNumber() + "\t" +
                        smallHardware.getName() + "\t" +
                        smallHardware.getQuantity() + "\t" +
                        smallHardware.getPrice() + "\t" +
                        smallHardware.getCategory());
            }
        }
    }

    /**
     * Searches for an appliance object by name and prints it out to the screen if found
     */
    public void lookUpAppliance(){
        Scanner scanItemName = new Scanner(System.in);
        System.out.print("Please enter item name: ");
        String itemName = scanItemName.nextLine();

        for (Appliance appliance : appliances){
            if (appliance.getName().toLowerCase().equals(itemName)){
                System.out.println(appliance.getIdNumber() + "\t" +
                        appliance.getName() + "\t" +
                        appliance.getQuantity() + "\t" +
                        appliance.getPrice() + "\t" +
                        appliance.getBrand() + "\t" +
                        appliance.getType());
            }
        }
    }

    /**
     * searches for an item by name in both ArrayLists and returns a true or false value
     * @param name name of object to search for
     * @return true or false depending on if item was found
     */
    public boolean containsItem(String name) {
        boolean found = false;
        for (SmallHardware smallHardware : smallHardwares) {
            if (smallHardware.getName().equals(name)) {
                return true;
            }
        }

        for (Appliance appliance : appliances) {
            if (appliance.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Subtracts a quantity of a specific item
     * @param name name of item to search for
     * @param quantitySubtracted the quantity to subtract by
     */
    public void subtractItemQuantity(String name, int quantitySubtracted) {
        for (SmallHardware smallHardware : smallHardwares) {
            if (smallHardware.getName().equals(name)) {
                int subtracted = smallHardware.getQuantity() - quantitySubtracted;
                smallHardware.setQuantity(subtracted);
                return;
            }
        }

        for (Appliance appliance : appliances) {
            if (appliance.getName().equals(name)) {
                int subtracted = appliance.getQuantity() - quantitySubtracted;
                appliance.setQuantity(subtracted);
                return;
            }
        }
    }

    /**
     * Writes the smallHardwares and appliances ArrayLists to .dat files. Creates the files if they
     * are not already made.
     */
    public void writeToFile() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("smallHardwareDatabase.dat"));
            out.writeObject(smallHardwares);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("appliancesDatabase.dat"));
            out.writeObject(appliances);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads in from .dat files and populates the smallHardwares and appliances ArrayLists
     */
    public void inputFromFile(){

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("smallHardwareDatabase.dat"));
            smallHardwares = (ArrayList<SmallHardware>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("appliancesDatabase.dat"));
            appliances = (ArrayList<Appliance>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}