package problem1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Shop
{

    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList<>();
        double totalPrice;
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        String keepShopping = "y";
        do
        {
            totalPrice = 0;
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();
            scan.nextLine();
            cart.add(new Item(itemName, itemPrice, quantity));
            System.out.println("Cart contents:");
            for (Item cartItem : cart) {
                System.out.println(cartItem);
                totalPrice += cartItem.getPrice() * cartItem.getQuantity();
            }
            System.out.printf(Locale.US, "Total price: $%.2f%n", totalPrice);

            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();

        }
        while (keepShopping.equals("y"));
    }
}
