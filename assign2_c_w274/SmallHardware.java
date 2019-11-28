package hardwarestore;

/**
 * Class for smallHardware objects, subclass of Item
 */
public class SmallHardware extends Item {

    private String category;

    /**
     * SmallHardware constructor
     * @param idNumber smallHardware idNumber
     * @param itemName smallHardware name
     * @param quan smallHardware quantity
     * @param pri smallHardware price
     * @param cat smallHardware category
     */
    public SmallHardware(String idNumber, String itemName,
                         int quan, float pri, String cat) {
        super(idNumber, itemName, quan, pri);
        category = cat;
    }

    /**
     * gets smallHardware category
     * @return category
     */
    public String getCategory() {
        return category;
    }

}
