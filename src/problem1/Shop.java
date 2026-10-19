package problem1;

import java.util.ArrayList;
import java.util.Scanner;
public class Shop
{

    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList<>();
        double totalPrice;
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
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
            // *** create a new item and add it to the cart
            item = new Item(itemName,itemPrice,quantity);
            cart.add(item);
            // *** print the contents of the cart object using println
            for (int i=0;i<cart.size();i++) {
                Item tempItem = new Item(cart.get(i).getName(),cart.get(i).getPrice(),cart.get(i).getQuantity());
                System.out.println(tempItem);// I already created a toString methode in class Item.
                totalPrice = totalPrice + tempItem.getQuantity()*tempItem.getPrice();
            }

            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();

            if (keepShopping.equals("n")) {
                System.out.println("Total Price of all items: " + totalPrice);
            }
        }
        while (keepShopping.equals("y"));
    }
}
