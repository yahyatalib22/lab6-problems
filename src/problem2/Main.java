package problem2;


public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("My Bank");

        System.out.println(bank.addCustomer("Ali"));
        System.out.println(bank.addCustomer("Sara"));

        System.out.println(bank.addCustomer("Ali"));

        // Add transactions
        bank.addTransaction("Ali", 1000.0);
        bank.addTransaction("Ali", -200.0);
        bank.addTransaction("Ali", 500.0);

        bank.addTransaction("Sara", 300.0);

        // Nonexistent customer
        System.out.println(bank.addTransaction("Omar", 100.0));

        // Print statements
        bank.printStatement("Ali");
        bank.printStatement("Sara");
        bank.printStatement("Omar");
    }
}

