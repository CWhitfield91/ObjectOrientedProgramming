package hardwarestore;

/**
 * Class holds all information about item objects
 */
public class Item {

    /**
     * A 5 parameter contruster used to store information
     * about item objects
     * @param idNum the ID Number of an item
     * @param n the Name of the item
     * @param cat the Category of the item
     * @param quan the Quantity of the item
     * @param pri the Price of the item
     */
    public Item(String idNum, String n, String cat,
                 int quan, float pri){
        idNumber = idNum;
        name = n;
        category = cat;
        quantity = quan;
        price = pri;
    }

    private String idNumber;
    private String name;
    private String category;
    private int quantity;
    private float price;

    /**
     * Gets the ID Number of the item
     * @return idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * gets the Name of the item
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets the Category of the item
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * gets the Quantity of the item
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * gets the Price of the item
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * sets the Quantity of the item
     * @param update the new updated quantity to be set
     */
    public void setQuantity(int update){
        quantity = update;
    }
}
