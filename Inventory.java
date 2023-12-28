//Olivia Mirly
//HW 13
//This program manages the inventory of a very small grocery store

import java.util.Scanner;

public class Inventory{
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){

        String[] items = new String[5];
        double[] prices = new double[5];
        int[] quantity = new int[5];

        items = createListOfItems();
        prices = createListOfPrices(items);
        quantity = getQuantities(items);

        displayListAndCost(items, prices, quantity);

        System.out.println("Enter an item to display: ");
        String item = input.nextLine();
        System.out.println(item);
        findItem(items, prices, quantity, item);

        System.out.printf("\nThe total investment in inventory is: %.2f\n", inventoryCost(prices, quantity));

        displayLowInventory(items, quantity);

        System.out.println("Enter item to reduce its inventory: ");
        item = input.nextLine();
        System.out.println("Enter quantity to reduce by: ");
        int qty = input.nextInt();
        reduceInventory(items, item, qty, quantity);

        displayListAndCost(items, prices, quantity);

    }

    public static String[] createListOfItems() {
        String[] items = new String[5];
        for(int i = 0; i < 5; i++) {
            System.out.println("Enter grocery item: ");
            items[i] = input.nextLine();
        }
        return items;
    }

    public static double[] createListOfPrices(String[] list) {
        double[] prices = new double[5];
        for(int i = 0; i < 5; i++) {
            System.out.println("Enter price for " + list[i] + ":");
            prices[i] = Double.parseDouble(input.nextLine());
        }
        return prices;
    }

    public static int[] getQuantities(String[] list) {
        int[] qs = new int[5];
        for(int i = 0; i < 5; i++) {
            System.out.println("Enter current inventory for " + list[i] + ":");
            qs[i] = Integer.parseInt(input.nextLine());
        }
        return qs;
    }

    public static void displayListAndCost(String[] list, double[] price, int[] quantities) {
        System.out.println("\nQuantity       Item         Cost\n");
        for(int i = 0; i < 5; i++) {
            System.out.printf("%-15d%-13s%.2f\n", quantities[i], list[i], price[i]);
        }
    }

    public static void findItem(String[] list, double[] price, int[] quantity, String item) {
        int index = -1;
        for(int i = 0; i < 5; i++) {
            if(list[i].equals(item)) {
                index = i;
            }
        }

        if(index == -1) {
            System.out.println("Error: item not found.");
        } else {
            System.out.println("Item: " + list[index]);
            System.out.println("Qty: " + quantity[index]);
            System.out.println("Cost: " + price[index]);
        }
    }

    public static double inventoryCost(double[] prices, int[] qty) {
        double total = 0;
        for(int i = 0; i < 5; i++) {
            total += qty[i] * prices[i];
        }
        return total;
    }

    public static void displayLowInventory(String[] list, int[] qty){
        int count = 0;
        System.out.println("Items that are low in stock: ");
        for(int i = 0; i < 5; i++) {
            if(qty[i] < 3) {
                System.out.println(list[i]);
                count++;
            }
        }
        System.out.println("There are a total of " + count + " items that are low.");
    }

    public static void reduceInventory(String[] list, String item, int amount, int[] qty) {
        int index = -1;
        for(int i = 0; i < 5; i++) {
            if(list[i].equals(item)) {
                index = i;
            }
        }

        if(index == -1) {
            System.out.println("Error: item not found.");
        } else {
            qty[index] -= amount;
        }

        System.out.println("Reducing " + item + " by " + amount + "...");
    }

}