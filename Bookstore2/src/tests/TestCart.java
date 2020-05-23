package tests;

import model.*;

/**
 * 
 * @author richardbankhead
 * @version 2/13/20
 */
public class TestCart {
    
    
    /**
     * Tests toString method
     * @param item test item
     * @return 1 for success, -1 for failure
     */
    public static int test_toString(Cart<ItemOrder> cart) {
        System.out.println("Testing toString with input(s): " + cart);
        System.out.println("Expected results: " + "Shopping cart contains: [TestItem, $10.00, quantity: 2]");
        System.out.println("Actual results: " + cart.toString());
        if(!cart.toString().equals("Shopping cart contains: [TestItem, $10.00, quantity: 2]")) {
            System.out.println("FAILURE");
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }
    
    /**
     * Tests equals method
     * @param item test item
     * @return 1 for success, -1 for failure
     */
    public static int test_equals(Cart<ItemOrder> cart,Cart<ItemOrder> otherCart) {
        System.out.println("Testing equals with input(s): " + cart + otherCart);
        System.out.println("Expected results: " + true);
        System.out.println("Actual results: " + cart.equals(otherCart));
        if(!cart.equals(otherCart)) {
            System.out.println("FAILURE");
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }
    
    /**
     * Tests hashCode method
     * @param item test item
     * @return 1 for success, -1 for failure
     */
    public static int test_hashCode(Cart<ItemOrder> cart) {
        System.out.println("Testing hashCode with input(s): " + cart);
        System.out.println("Expected results: " + -173432553);
        System.out.println("Actual results: " + cart.hashCode());
        if(cart.hashCode()!=-173432553) {
            System.out.println("FAILURE");
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }
    
    /**
     * Tests compareTo method
     * @param item test item
     * @return 1 for success, -1 for failure
     */
    public static int test_compareTo(Cart<ItemOrder> cart,Cart<ItemOrder> otherCart) {
        System.out.println("Testing compareTo with input(s): " + cart + otherCart);
        System.out.println("Expected results: " + -1);
        System.out.println("Actual results: " + cart.compareTo(otherCart));
        if(cart.compareTo(otherCart)>=0) {
            System.out.println("FAILURE"); 
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }
    
    /**
     * Tests compare method
     * @param item test item
     * @return 1 for success, -1 for failure
     */
    public static int test_compare(Cart<ItemOrder> cart,Cart<ItemOrder> otherCart) {
        System.out.println("Testing compare with input(s): " + cart + otherCart);
        System.out.println("Expected results: " + -1);
        System.out.println("Actual results: " + cart.compare(cart,otherCart));
        if(cart.compare(cart,otherCart)>=0) {
            System.out.println("FAILURE"); 
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }

}
