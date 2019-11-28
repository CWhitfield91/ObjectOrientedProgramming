package hardwarestore;

/**
 * Class for Employee objects, subclass of User class
 */
public class Employee extends User {

    private int ssn;
    private float monthlySalary;

    /**
     * Employee constructor
     * @param first employee first name
     * @param last employee last name
     * @param ID employee id number
     * @param SSN employee social security number
     * @param monthlySal employee monthly salary
     */
    public Employee( String first, String last, int ID,
                     int SSN, float monthlySal){
        super (first, last, ID);
        ssn = SSN;
        monthlySalary = monthlySal;
    }

    /**
     * gets employee social security number
     * @return ssn
     */
    public int getSsn() {
        return ssn;
    }

    /**
     * gets employee monthly salary
     * @return monthlySalary
     */
    public float getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * sets employe SSN
     * @param ssn employee SSN is set to this
     */
    public void setSsn(int ssn) { this.ssn = ssn; }

    /**
     * sets employee monthly salary
     * @param monthlySalary employe monthly salary is set to this
     */
    public void setMonthlySalary(float monthlySalary) { this.monthlySalary = monthlySalary; }

}
