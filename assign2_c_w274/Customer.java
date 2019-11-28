package hardwarestore;

/**
 * Class for Customer objects, subclass of User class
 */
public class Customer extends User {

    private String phoneNumber;
    private String address;

    /**
     * Customer constructor
     * @param first customer first name
     * @param last customer last name
     * @param ID customer id number
     * @param phoneNum customer phone number
     * @param adrs customer address
     */
    public Customer(String first, String last, int ID,
                    String phoneNum, String adrs){
        super(first, last, ID);
        phoneNumber = phoneNum;
        address = adrs;
    }

    /**
     * gets customer phone number
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * gets customer address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets customer phone number
     * @param phoneNumber customer phone number is set to this
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * sets customer address
     * @param address customer address is set to this
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
