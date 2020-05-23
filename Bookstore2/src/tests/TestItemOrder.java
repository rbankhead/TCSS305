package tests;

import model.*;

/**
 * 
 * @author richardbankhead
 * @version 2/13/20
 */

public class TestItemOrder {
    
    /**
     * tests ItemOrder toString method
     * @param itemOrder test itemOrder
     * @return 1 for success, -1 for failure
     */
    public static int test_toString(ItemOrder itemOrder) {
        System.out.println("Testing toString with input(s): " + itemOrder);
        System.out.println("Expected results: " + "TestItem, $10.00, quantity: 2");
        System.out.println("Actual results: " + itemOrder.toString());
        if(!itemOrder.toString().equals("TestItem, $10.00, quantity: 2")) {
            System.out.println("FAILURE");
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }
    
    /**
     * tests ItemOrder equals method
     * @param itemOrder test itemOrder
     * @return 1 for success, -1 for failure
     */
    public static int test_equals(ItemOrder first, ItemOrder second) {
        System.out.println("Testing equals with input(s): " + first + second);
        System.out.println("Expected results: " + true);
        System.out.println("Actual results: " + first.equals(second));
        if(!first.equals(second)) {
            System.out.println("FAILURE");
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }
    
    /**
     * tests ItemOrder hashCode method
     * @param itemOrder test itemOrder
     * @return 1 for success, -1 for failure
     */
    public static int test_hashCode(ItemOrder itemOrder) {
        System.out.println("Testing hashCode with input(s): " + itemOrder);
        System.out.println("Expected results: " + 410047296);
        System.out.println("Actual results: " + itemOrder.hashCode());
        if(itemOrder.hashCode()!=410047296) {
            System.out.println("FAILURE");
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }
    
    /**
     * tests ItemOrder compareTo method
     * @param itemOrder test itemOrder
     * @return 1 for success, -1 for failure
     */
    public static int test_compareTo(ItemOrder first, ItemOrder second) {
        System.out.println("Testing compareTo with input(s): " + first + second);
        System.out.println("Expected results: " + -1);
        System.out.println("Actual results: " + first.compareTo(second));
        if(first.compareTo(second)>=0) {
            System.out.println("FAILURE"); 
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }

}
