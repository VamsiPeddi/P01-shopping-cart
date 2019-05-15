// File Header comes here
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Shopping Cart Program
// Files: ShoppingCart.java
// Course: CS 300 Spring 2019
//
// Author: Vamsi Peddi
// Email: vpeddi@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: No help used
// Online Sources: -
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


// JavaDoc class Header comes here
public class ShoppingCartTests {

  /**
   * Checks whether the total number of items within the cart is incremented after adding one item
   * 
   * @return true if the test passes without problems, false otherwise
   */
  public static boolean testCountIncrementedAfterAddingOnlyOneItem() {
    boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
                               // false otherwise
    String[] cart = new String[20]; // shopping cart
    int count = 0; // number of items present in the cart (initially the cart is empty)

    // Add an item to the cart
    count = ShoppingCart.add(3, cart, count); // add an item of index 3 to the cart
    // Check that count was incremented
    if (count != 1) {
      System.out.println("Problem detected: After adding only one item to the cart, "
          + "the cart count should be incremented. But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }

  /**
   * Checks whether add and OccurrencesOf return the correct output when only one item is added to
   * the cart
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testAddAndOccurrencesOfForOnlyOneItem() {
    boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
    // define the shopping cart as an oversize array of elements of type String
    // we can set an arbitrary capacity for the cart - for instance 10
    String[] cart = new String[10]; // shopping cart
    int count = 0; // number of items present in the cart (initially the cart is empty)

    // check that OccurrencesOf returns 0 when called with an empty cart
    if (ShoppingCart.occurrencesOf(10, cart, count) != 0) {
      System.out.println("Problem detected: Tried calling OccurrencesOf() method when the cart is "
          + "empty. The result should be 0. But, it was not.");
      testPassed = false;
    }

    // add one item to the cart
    count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

    // check that OccurrencesOf("Apples", cart, count) returns 1 after adding the item with key 0
    if (ShoppingCart.occurrencesOf(0, cart, count) != 1) {
      System.out.println("Problem detected: After adding only one item with key 0 to the cart, "
          + "OccurrencesOf to count how many of that item the cart contains should return 1. "
          + "But, it was not the case.");
      testPassed = false;
    }

    return testPassed;
  }


  /**
   * Checks that items can be added more than one time and are found
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testAddOccurrencesOfDuplicateItems() {
    boolean testPassed = true;
    String[] cart = new String[10]; // shopping cart
    int count = 0; // number of items present in the cart (initially the cart is empty)
    // Adding two apples to the cart
    count = ShoppingCart.add(0, cart, count);
    count = ShoppingCart.add(0, cart, count);
    // Checking if the program recognizes two instances of the apple
    if (ShoppingCart.occurrencesOf(0, cart, count) != 2) {
      System.out.println("Problem detected: After adding only one item with key 0 to the cart, "
          + "OccurrencesOf to count how many of that item the cart contains should return 1. "
          + "But, it was not the case.");
      testPassed = false;
    }
    return testPassed;
  }


  /**
   * Checks that the correct output is returned when the user tries to add too much items to the
   * cart exceeding its capacity
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testAddingTooMuchItems() {
    boolean testPassed = true;
    String[] cart = new String[2];
    int count = 0;
    count = ShoppingCart.add(0, cart, count);
    count = ShoppingCart.add(0, cart, count);

    // created a cart with a capacity of two and now we're going to add the third item to test the
    // method
    if (ShoppingCart.add(2, cart, count) != 2) {
      System.out.println("Problem detected: add method should've returned 2 but returned "
          + ShoppingCart.add(2, cart, count));
      testPassed = false;
    }
    return testPassed;
  }

  
  /**
   * Checks that when only one attempt to remove an item present in the cart is made, only one
   * occurrence of that item is removed from the cart
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testRemoveOnlyOneOccurrenceOfItem() {
    boolean testPassed = true;
    String[] cart = new String[10];
    int count = 0;
    count = ShoppingCart.add(0, cart, count);// Adding Apple
    count = ShoppingCart.add(3, cart, count);
    
    // checking to see if cart removes the Apple
    if (ShoppingCart.remove("Apple", cart, count) != 1) {
      System.out.println("Problem detected: Item was not removed from cart");
      testPassed = false;
    }

    return testPassed;
  }

  /**
   * Checks that remove returns false when the user tries to remove an item not present within the cart
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testRemoveItemNotFoundInCart() {
    boolean testPassed = true;
    String[] cart = new String[10];
    int count = 0;
    count = ShoppingCart.add(0, cart, count);
    count = ShoppingCart.add(2, cart, count);
    count = ShoppingCart.add(3, cart, count);
    
    // Here we're trying to remove a Potato which we never added to the cart
    if (ShoppingCart.remove("Potato", cart, count) != count) {
      System.out
          .println("Problem detected: Item was not in the cart but programm returned " + count);
      testPassed = false;
    }

    return testPassed;

  }

  /**
   * Checks that getSubTotalPrice returns the correct total price without tax.
   * 
   * @return true if test passed without problems, false otherwise
   */
  public static boolean testGetSubTotalPrice() {
    boolean testPassed = true;
    String[] cart = new String[10];
    int count = 0;
    count = ShoppingCart.add(2, cart, count);
    count = ShoppingCart.add(3, cart, count);
 
 
    if (ShoppingCart.getSubTotalPrice(cart, count) != 4.28) {
      System.out.println(
          "Problem detected: Total checkout price should've been 4.28 but price returned was "
              + ShoppingCart.getSubTotalPrice(cart, count));
      testPassed = false;
    }
    return testPassed;
  }


  /**
   * main method used to call the unit tests
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testCountIncrementedAfterAddingOnlyOneItem(): "
        + testCountIncrementedAfterAddingOnlyOneItem());
    System.out.println(
        "testAddAndOccurrencesOfForOnlyOneItem(): " + testAddAndOccurrencesOfForOnlyOneItem());
    System.out
        .println("testAddOccurrencesOfDuplicateItems(): " + testAddOccurrencesOfDuplicateItems());
    System.out
        .println("testRemoveOnlyOneOccurrenceOfItem(): " + testRemoveOnlyOneOccurrenceOfItem());

    System.out.println("testRemoveItemNotFoundInCart(): " + testRemoveItemNotFoundInCart());

    System.out.println("testAddingTooMuchItems(): " + testAddingTooMuchItems());

    System.out.println("testGetSubTotalPrice(): " + testGetSubTotalPrice());
  }
}
