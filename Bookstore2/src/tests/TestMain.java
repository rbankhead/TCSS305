package tests;

import java.math.BigDecimal;

import model.*;

/**
 * 
 * @author richardbankhead
 * @version 2/13/20
 */
public class TestMain {
    
/**
 * Initializes test Item, ItemOrder and Cart objects
 * Calls each method in the TestCart, TestItem and TestItemOrder classes
 * @param args
 */
    public static void main(String[] args) {
        
        Item item = new Item("TestItem", BigDecimal.TEN);
        Item itemClone = new Item("TestItem", BigDecimal.TEN);
        Item other = new Item("Not TestItem", BigDecimal.valueOf(75.0));
        ItemOrder itemOrder = new ItemOrder(item, 2);
        ItemOrder itemOrderClone = new ItemOrder(item, 2);
        ItemOrder otherOrder = new ItemOrder(other, 3);
        Cart<ItemOrder> cart = new Cart<ItemOrder>();
        Cart<ItemOrder> cartClone = new Cart<ItemOrder>();
        Cart<ItemOrder> otherCart = new Cart<ItemOrder>();
        cart.add(itemOrder);
        cartClone.add(itemOrderClone);
        otherCart.add(otherOrder);
        
        System.out.println("Test Item Class...");
        TestItem.test_toString(item);
        TestItem.test_equals(item, itemClone);
        TestItem.test_hashCode(item);
        TestItem.test_compareTo(item, other);
        TestItem.test_compare(item, other);
        System.out.println();
        
        System.out.println("Test ItemOrder class...");
        TestItemOrder.test_toString(itemOrder);
        TestItemOrder.test_equals(itemOrder, itemOrderClone);
        TestItemOrder.test_hashCode(itemOrder);
        TestItemOrder.test_compareTo(itemOrder, otherOrder);
        System.out.println();
        
        System.out.println("Test Cart class...");
        TestCart.test_toString(cart);
        TestCart.test_equals(cart, cartClone);
        TestCart.test_hashCode(cart);
        TestCart.test_compareTo(cart, otherCart);
        TestCart.test_compare(cart, otherCart);

    }

}
