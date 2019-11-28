package hardwarestore;

/**
 * Class for Appliance objecs, subclass of Item class
 */
public class Appliance extends Item {

    private String brand;
    private String type;

    /**
     * Constructor for Appliance objects
     * @param idNumber appliance id number
     * @param name appliance name
     * @param quan appliance quantity
     * @param pri appliance price
     * @param bran appliance brand
     * @param typ appliance type
     */
    public Appliance (String idNumber, String name, int quan,
                      float pri, String bran, String typ) {
        super (idNumber, name, quan, pri);
        brand = bran;
        type = typ;
    }

    /**
     * gets appliance brand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * gets appliance type
     * @return type
     */
    public String getType() {
        return type;
    }
}
