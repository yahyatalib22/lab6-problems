package problem2;


public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("My Bank");

        System.out.println(bank.addCustomer("Yahya"));
        System.out.println(bank.addCustomer("Hamza"));

        System.out.println(bank.addCustomer("Yahya"));

        // Add transactions
        bank.addTransaction("Yahya", 1000.0);
        bank.addTransaction("Yahya", -200.0);
        bank.addTransaction("Yahya", 500.0);

        bank.addTransaction("Hamza", 300.0);

        // Nonexistent customer
        System.out.println(bank.addTransaction("Omar", 100.0));

        // Print statements
        bank.printStatement("Yahya");
        bank.printStatement("Hamza");
        bank.printStatement("Omar");
    }
}

