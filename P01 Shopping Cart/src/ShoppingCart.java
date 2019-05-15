//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Shopping Cart Program
// Files:           ShoppingCart.java
// Course:          CS 300 Spring 2019
//
// Author:          Vamsi Peddi
// Email:           vpeddi@wisc.edu 
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         No help used
// Online Sources:  -
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;

public class ShoppingCart {
  // Define final parameters
  private static final int CART_CAPACITY = 20; // shopping cart max capacity
  private static final double TAX_RATE = 0.05; // sales tax

  // a perfect-size two-dimensional array that stores the available items in the market
  // MARKET_ITEMS[i][0] refers to a String that represents the description of the item
  // identified by index i
  // MARKET_ITEMS[i][1] refers to a String that represents the unit price of the item
  // identified by index i in dollars.
  public static final String[][] MARKET_ITEMS = new String[][] {{"Apple", "$1.59"},
      {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
      {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
      {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
      {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
      {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
      {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};


  /**
   * adds the item with the given identifier index at the end of the cart
   * 
   * @param index of the item within the marketItems array
   * @param cart  shopping cart
   * @param count number of items present within the cart before this add method is called
   * @return the number of items present in the cart after the item with identifier index is added
   */
  public static int add(int index, String[] cart, int count) {

    String item = MARKET_ITEMS[index][0];
    if (count >= cart.length) {
      System.out.println("WARNING: The cart is full. You cannot add any new item.");
      return count;
    }

    cart[count] = item;
    count++;

    return count;
  }


  /**
   * Returns how many occurrences of the item with index itemIndex are present in the shopping cart
   * 
   * @param itemIndex identifier of the item to count its occurrences in the cart
   * @param cart      shopping cart
   * @param count     number of items present within the cart
   * @return the number of occurrences of item in the cart
   */
  public static int occurrencesOf(int itemIndex, String[] cart, int count) {
    if (count == 0) {
      return 0;
    }
    String item = MARKET_ITEMS[itemIndex][0];
    int oc = 0;
    for (int i = 0; i < count; i++) {
      if (cart[i].equals(item)) {
        oc++;
      }
    }

    return oc;
  }

  /**
   * Returns the index of an item within the shopping cart
   * 
   * @param item  description
   * @param cart  Shopping cart
   * @param count number of items present in the shopping cart
   * @return index of the item within the shopping cart, and -1 if the item does not exist in the
   *         cart
   */
  private static int indexOf(String item, String[] cart, int count) {
    int itemIndex = -1;
    for (int i = 0; i < count; i++) {
      if (cart[i].equals(item)) {
        itemIndex = i;
        break;
      }
    }
    if (itemIndex == -1) {
      itemIndex = -1;
    }
    return itemIndex;
  }

  
  /**
   * Removes the first (only one) occurrence of itemToRemove if found and returns the number of
   * items in the cart after remove operation is completed either successfully or not
   * 
   * @param itemToRemove - Item to remove from cart
   * @param cart  Shopping cart
   * @param count number of items present in the shopping cart
   * @return count - the number of the items left within the shopping cart
   */
  public static int remove(String itemToRemove, String[] cart, int count) {
    int index = indexOf(itemToRemove, cart, count);
    if (index == -1) {
      System.out.println("WARNING: " + itemToRemove + " not found in the shopping cart.");
      return count;
    } else {
      cart[index] = cart[count - 1];
      cart[count - 1] = null;
      count--;

    }
    return count;
  }

  
  /**
   * returns the total value (cost) of the cart without tax in $ (double)
   * 
   * @param cart  Shopping cart
   * @param count number of items present in the shopping cart
   * @return totalPrice - the total price of the items in the cart without tax
   * 
   */
  public static double getSubTotalPrice(String[] cart, int count) {

    double totalPrice = 0;
    for (int i = 0; i < count; i++) {
      for (int j = 0; j < MARKET_ITEMS.length; j++) {
        if (cart[i].equals(MARKET_ITEMS[j][0])) {
          totalPrice = totalPrice + Double.valueOf(MARKET_ITEMS[j][1].substring(1));
        }
      }
    }
    return totalPrice;
  }

  
  /**
   * prints the Market Catalog (item identifiers, description, and unit prices)
   * 
   */
  public static void printMarketCatalog() {
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Item id     Description      Price");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    for (int i = 0; i < MARKET_ITEMS.length; i++) {
      System.out.println(i + "\t\t" + MARKET_ITEMS[i][0] + "    \t " + MARKET_ITEMS[i][1]);
    }
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

  }

  // Displays the cart content (items separated by commas)
  public static void displayCartContent(String[] cart, int count) {
    String cartContent = "";

    for (int i = 0; i < count; i++) {
      cartContent = cartContent + cart[i] + ", ";
    }

    System.out.println("Cart Content: " + cartContent);
  }

  // Displays the command Menu 
  public static void printCommandMenu() {
    System.out.println("\nCOMMAND MENU:\n" + " [P] print the market catalog\n"
        + " [A <index>] add one occurrence of an item to the cart given its identifier\n"
        + " [C] checkout\n" + " [D] display the cart content\n"
        + " [O <index>] number of occurrences of an item in the cart given its identifier\n"
        + " [R <index>] remove one occurrence of an item from the cart given its identifier\n"
        + " [Q]uit the application\n");
  }

  /**
   * main method used to call the unit tests
   * 
   * @param args
   */
  public static void main(String[] args) {

    String[] cart = new String[CART_CAPACITY];
    int count = 0;
    int a = 0;


    System.out.println("=============   Welcome to the Shopping Cart App   =============");
    System.out.println();


    printCommandMenu();

    System.out.print("ENTER COMMAND: ");

    Scanner sc = new Scanner(System.in);

    String command = sc.nextLine();

    command = command.toUpperCase();

    while (!command.equals("Q")) {

      if (a != 0) {
        System.out.print("ENTER COMMAND: ");

        command = sc.nextLine();

        command = command.toUpperCase();
      }



      if (command.charAt(0) == 'P') {

        printMarketCatalog();

      }
      if (command.charAt(0) == 'A') {
        int index = Integer.parseInt(command.substring(2));
        count = add(index, cart, count);
        printCommandMenu();
      }
      if (command.charAt(0) == 'C') {
        double total = getSubTotalPrice(cart, count);
        System.out.println("#items: " + count + " Subtotal: $" + String.format("%.2f", total)
            + " Tax: $" + String.format("%.2f", TAX_RATE * total) + " TOTAL: $"
            + String.format("%.2f", TAX_RATE * total + total));
        printCommandMenu();
      }
      if (command.charAt(0) == 'O') {
        int itemIndex = Integer.parseInt(command.substring(2));
        int numberOfOccurrences = occurrencesOf(itemIndex, cart, count);
        System.out.println("The number of occurrences of " + MARKET_ITEMS[itemIndex][0] + " (id #"
            + itemIndex + ") is: " + numberOfOccurrences);

        printCommandMenu();
      }
      if (command.charAt(0) == 'R') {
        int index = Integer.parseInt(command.substring(2));
        String itemToRemove = MARKET_ITEMS[index][0];
        count = remove(itemToRemove, cart, count);

        printCommandMenu();
      }
      if (command.charAt(0) == 'D') {

        displayCartContent(cart, count);

        printCommandMenu();

      }
      if (command.charAt(0) == 'Q') {
        System.out.println("=============  Thank you for using this App!!!!!  =============");
        System.exit(0);
      }

      command = "";
      a++;
    }

    if (command.charAt(0) == 'Q') {
      System.out.println("=============  Thank you for using this App!!!!!  =============");
      System.exit(0);
    }


  }
}
