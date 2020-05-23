package tests;

import model.*;

/**
 * 
 * @author richardbankhead
 * @version 2/13/20
 */
public class TestItem {
    
    
    /**
     * Tests toString method
     * @param item test item
     * @return 1 for success, -1 for failure
     */
    public static int test_toString(Item item) {
        System.out.println("Testing toString method with inputs: "+ item);
        System.out.println("Expected result: " + "TestItem, $10.00");
        System.out.println("Actual result: " + item.toString());
        if(!item.toString().equals("TestItem, $10.00")) {
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
    public static int test_equals(Item first, Item second) {
        System.out.println("Testing equals method with inputs: " + first + " and" + second);
        System.out.println("Expected result: " + true);
        System.out.println("Actual result: " + second.equals(first));
        if(!first.equals(second)) {
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
    public static int test_hashCode(Item item) {
        System.out.println("Testing hashCode method with inputs: " + item);
        System.out.println("Expected result: " + "2091437283");
        System.out.println("Actual result: " + item.hashCode());
        if(!(item.hashCode()==2091437283)) {
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
    public static int test_compareTo(Item first, Item second) {
        System.out.println("Testing compareTo method with inputs: ");
        System.out.println("Expected result: " + "positive integer");
        System.out.println("Actual result: " + first.compareTo(second));
        if(first.compareTo(second)<1) {
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
    public static int test_compare(Item first, Item second) {
        System.out.println("Testing compare with input(s): " + first + second);
        System.out.println("Expected results: " + -1);
        System.out.println("Actual results: " + first.compare(first,second));
        if(first.compare(first,second)>=0) {
            System.out.println("FAILURE"); 
            return -1;
        }
        System.out.println("SUCCESS");
        return 1;
    }

}
