package problem2;

import java.util.ArrayList;

public class Bank {
    private final String name;
    private final ArrayList<Customer> customers;


    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(String custName) {
        if (findCustomer(custName) != null) {
            return false;
        }
        customers.add(new Customer(custName));
        return true;
    }



    private Customer findCustomer(String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public boolean addTransaction(String name, double amount) {
        Customer c = findCustomer(name);

        if (c == null) {
            return false;
        }

        c.addTransaction(amount);
        return true;
    }

    public void printStatement(String name) {
        Customer c = findCustomer(name);

        if (c == null) {
            System.out.println("Customer not found");
            return;
        }

        System.out.println("Bank: " + this.name);
        System.out.println("Customer: " + c.getName());

        for (Double transaction : c.getTransactions()) {
            double amount = transaction; // Unboxing
            System.out.println(amount);
        }
    }
}
