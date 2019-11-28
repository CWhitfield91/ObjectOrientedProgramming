package hardwarestore;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class to control user database
 */
public class UserDatabase implements Serializable {

    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    /**
     * takes user input and adds an Employee object to the employees ArrayList
     */
    public void addEmployee() {
        Scanner scanFirstName = new Scanner(System.in);
        Scanner scanLastName = new Scanner(System.in);
        Scanner scanID = new Scanner(System.in);
        Scanner scanSSN = new Scanner(System.in);
        Scanner scanMonthlySalary = new Scanner(System.in);

        System.out.print("Please enter First Name: ");
        String first = scanFirstName.nextLine();

        System.out.print("Please Enter Last Name: ");
        String last = scanLastName.nextLine();

        System.out.print("Please Enter ID Number: ");
        int id = scanID.nextInt();

        System.out.print("Please enter Social Security Number: ");
        int SSN = scanSSN.nextInt();

        System.out.print("Please enter Monthly Salary: ");
        float monthlySal = scanMonthlySalary.nextFloat();

        Employee employee = new Employee(first, last, id, SSN, monthlySal);
        employees.add(employee);
    }

    /**
     * prints the employees ArrayList
     */
    public void printEmployees() {
        System.out.println("EMPLOYEES");
        System.out.format(String.format("%s %14s %14s %8s %20s",
                "First Name", "Last Name", "Id Number", "SSN", "Monthly Salary"));
        System.out.println();

        for (Employee employee : employees) {
            System.out.format(String.format("%s %17s %11s %13d %14.2f",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getId(),
                    employee.getSsn(),
                    employee.getMonthlySalary()));
            System.out.println();
        }
    }

    /**
     * takes user input and adds a Customer object to the customers ArrayList
     */
    public void addCustomer() {
        Scanner scanFirstName = new Scanner(System.in);
        Scanner scanLastName = new Scanner(System.in);
        Scanner scanID = new Scanner(System.in);
        Scanner scanSSN = new Scanner(System.in);
        Scanner scanMonthlySalary = new Scanner(System.in);

        System.out.print("Please enter First Name: ");
        String first = scanFirstName.nextLine();

        System.out.print("Please Enter Last Name: ");
        String last = scanLastName.nextLine();

        System.out.print("Please Enter ID Number: ");
        int id = scanID.nextInt();

        System.out.print("Please enter Phone Number: ");
        String phoneNumber = scanSSN.nextLine();

        System.out.print("Please enter Address: ");
        String address = scanMonthlySalary.nextLine();

        Customer customer = new Customer(first, last, id, phoneNumber, address);
        customers.add(customer);
    }

    /**
     * prints the customer ArrayList
     */
    public void printCustomers() {
        System.out.println("CUSTOMERS");
        System.out.format(String.format("%s %14s %14s %18s %15s",
                "First Name", "Last Name", "Id Number", "Phone Number", "Address"));
        System.out.println();

        for (Customer customer : customers) {
            System.out.format(String.format("%s %17s %11s %21s %21s",
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getId(),
                    customer.getPhoneNumber(),
                    customer.getAddress()));
            System.out.println();
        }
    }

    /**
     * searches for Employee based on ID and updates a specific field of that employee
     * @param id employee id to search for
     */
    public void updateEmployee(int id) {
        Scanner updatedField = new Scanner(System.in);

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.print("Employee found. Do you wish to update FIRSTNAME, LASTNAME, " +
                        "SSN or MONTHLYSALARY?");
                String updateField = updatedField.nextLine();

                switch(updateField.toLowerCase()) {
                    case ("firstname"):
                        System.out.print("Enter updated first name: ");
                        String newFirstName = updatedField.nextLine();
                        employee.setFirstName(newFirstName);
                        break;

                    case ("lastname"):
                        System.out.print("Enter updated last name: ");
                        String newLastName = updatedField.nextLine();
                        employee.setLastName(newLastName);
                        break;

                    case ("ssn"):
                        System.out.print("Enter updated SSN: ");
                        int newSSN = updatedField.nextInt();
                        employee.setSsn(newSSN);
                        break;

                    case ("monthlysalary"):
                        System.out.print("Enter updated monthly salary: ");
                        float newMonthlySalary = updatedField.nextFloat();
                        employee.setMonthlySalary(newMonthlySalary);
                        break;
                }
            }

        }
    }

    /**
     * searches for customer based on ID and updates a specific field of the customer
     * @param id customer id to search for
     */
    public void updateCustomer(int id) {
        Scanner updatedField = new Scanner(System.in);

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.print("Employee found. Do you wish to update FIRSTNAME, LASTNAME, " +
                        "PHONENUMBER or ADDRESS?");
                String updateField = updatedField.nextLine();

                switch(updateField.toLowerCase()) {
                    case ("firstname"):
                        System.out.print("Enter updated first name: ");
                        String newFirstName = updatedField.nextLine();
                        customer.setFirstName(newFirstName);
                        break;

                    case ("lastname"):
                        System.out.print("Enter updated last name: ");
                        String newLastName = updatedField.nextLine();
                        customer.setLastName(newLastName);
                        break;

                    case ("phonenumber"):
                        System.out.print("Enter updated phone number: ");
                        String newPhoneNumber = updatedField.nextLine();
                        customer.setPhoneNumber(newPhoneNumber);
                        break;

                    case ("address"):
                        System.out.print("Enter updated address: ");
                        String newAddress = updatedField.nextLine();
                        customer.setAddress(newAddress);
                        break;
                }
            }

        }
    }

    /**
     * searches for employee name and returns true if found and false if not found
     * @param name employee name to search for
     * @return true or false depending on if found
     */
    public boolean containsEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * searchs for customer name and returns true if found and false if not found
     * @param name customer name to search for
     * @return true or false depending on if found
     */
    public boolean containsCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getFirstName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * writes emplotee and customers ArrayLists to .dat files. Creates the .dat files if they are
     * not already present
     */
    public void writeToFile() {
        try {
            ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("employeeDatabase.dat"));
            out1.writeObject(employees);
            out1.close();

            ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("customerDatabase.dat"));
            out2.writeObject(customers);
            out2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads from .dat files and populates the employees and customers ArrayLists
     */
    public void inputFromFile() {
        try {

            ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("employeeDatabase.dat"));
            employees = (ArrayList<Employee>) in1.readObject();

            ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("customerDatabase.dat"));
            customers = (ArrayList<Customer>) in2.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
