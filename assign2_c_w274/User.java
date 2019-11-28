package hardwarestore;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * User superclass. Implements the Serializable interface
 */
public class User implements Serializable {

    private int id;
    private String firstName;
    private String lastName;

    private ArrayList<User> users = new ArrayList<User>();

    /**
     * default User constructor
     */
    public User() {

    }

    /**
     * gets user firstName
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the user firstName
     * @param firstName user firstName is set to this
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets user lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the user lastName
     * @param lastName user lastName is set to this
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets user id number
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 3 paramaeter constructor
     * @param first user first name is set to this
     * @param last user last name is set to this
     * @param ID user id number is set to this
     */
    public User (String first, String last, int ID){
        firstName = first;
        lastName = last;
        id = ID;
    }


}
