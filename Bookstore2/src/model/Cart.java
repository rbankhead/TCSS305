/*
 * TCSS 305 Assignment 2 - Online Bookstore
 */

package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

import view.*;

/**
 * Cart contains all the item data for a particular order or group of ItemOrders for the Online Bookstore project
 * Cart provides the total price for orders including the bulk item discounts
 * 
 * @author richardbankhead
 * @version 01/17/20
 */
public class Cart<T> implements Comparable<Cart<ItemOrder>>, Comparator<Cart<ItemOrder>>{
    
    /** ArrayList to hold all ItemOrder objects */
    private final ArrayList<T> shoppingCart;
    
    /** boolean value == true if user has a membership, false otherwise */
    private boolean membership;

    /**
     * constructor to initialize blank shoppingCart ArrayList
     */
    public Cart() {
        shoppingCart = new ArrayList<T>();
    }
    
    /**
     * adds an item to the shoppingCart ArrayList
     * if an item is already present in a different quantity, it will replace that item with the parameter theOrder
     * @param theOrder an ItemOrder object to be added to the shoppingCart
     */
    public void add(final T theOrder) {
        Objects.requireNonNull(theOrder);
        Item currentItem;
        for (int i=0; i<shoppingCart.size();i++) {
            currentItem = (((ItemOrder) shoppingCart.get(i)).getItem());
            if (currentItem==((ItemOrder) theOrder).getItem()) {
                shoppingCart.set(i, theOrder);
                return;
            }
        }
        shoppingCart.add(theOrder);
    }

    /**
     * setter for the membership value of the user
     * @param theMembership if member, set boolean to true, otherwise false
     */
    public void setMembership(final boolean theMembership) {
        membership = theMembership;
    }

    /**
     * calculates the total cost of the orders for all items oredered by the user
     * multiplies the quantity of each order by the price of the item, summing this value for each item ordered
     * if the user is a member (membership==true) then the bulk discount is factored in
     * if the item has a bulk discount and the user is a member, the maximum number of bulk items are purchased using the bulk price
     * any remaining items are added to the total using the default price
     * example: 6 UW note pads can be purchased for $10.04, if user orders 14 of them, the first 12 will be purchased at the bulk price: 10.04 * 2 == 20.08. 
     * The remaining 2 will be purchased at the regular price $4.41 each: 4.41 * 2 = 8.82. Total for the whole order: $28.90
     * @return BigDecimal total price for all of the items ordered, factoring in bulk item discounts if the user is a member
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal currentPrice;
        BigDecimal currentQuantity;
        BigDecimal currentResult;
        BigDecimal bulkCurrentPrice;
        BigDecimal bulkCurrentQuantity;
        for (int i=0; i<shoppingCart.size();i++) {
            currentPrice = ((ItemOrder) shoppingCart.get(i)).getItem().getPrice();
            currentQuantity = BigDecimal.valueOf(((ItemOrder) shoppingCart.get(i)).getQuantity());
            currentResult = currentPrice.multiply(currentQuantity);
            if (membership && ((ItemOrder) shoppingCart.get(i)).getItem().isBulk()) {
                bulkCurrentQuantity = BigDecimal.valueOf(((ItemOrder) shoppingCart.get(i)).getItem().getBulkQuantity());
                bulkCurrentPrice = ((ItemOrder) shoppingCart.get(i)).getItem().getBulkPrice();
                currentResult = currentQuantity.divideToIntegralValue(bulkCurrentQuantity);
                total = total.add(currentResult.multiply(bulkCurrentPrice));
                currentResult = currentQuantity.remainder(bulkCurrentQuantity);
                total = total.add(currentResult.multiply(currentPrice));
            } else {
                total = total.add(currentResult);
            }
            
        }   
        return total.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
    
    /**
     * clear option in GUI, will erase all data in the shoppingCart ArrayList and all quantity fields in the GUI
     */
    public void clear() {
        shoppingCart.clear();
    }
    
    /**
     * Counts size of the shopping cart
     * @return size of the shoppingCart ArrayList
     */
    public int getCartSize() {
        return shoppingCart.size();
    }
    
    /**
     * gets the membership status
     * @return boolean true if membership box is checked, otherwise false
     */
    public boolean getMembership() {
        return membership;
    }
    
    /**
     * gets the current shopping cart object
     * @return shopping cart object
     */
    public ArrayList<T> getShoppingCart(){
        return shoppingCart;
    }
    /**
     * returns string that reads as "Shopping cart contains: shoppingCart"
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Shopping cart contains: ");
        builder.append(shoppingCart);
        return builder.toString();
    }
    
    /**
     * compares two objects for equality based on ShoppingCart ArrayList and membership status
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        @SuppressWarnings("unchecked")
        Cart<ItemOrder> otherCart = (Cart<ItemOrder>) other;
        return shoppingCart.equals(otherCart.getShoppingCart()) 
                        && (membership == otherCart.getMembership());
    }
    
    /**
     * returns a hashCode int based on the shoppingCart arraylist and membership status
     */
    @Override
    public int hashCode() {
        return Objects.hash(shoppingCart, membership);
    }
    
    /**
     * compares two ShoppingCart objects, this and other based on hashCode
     */
    @Override
    public int compareTo(Cart<ItemOrder> other) {
        Objects.requireNonNull(other);
        return Integer.compare(this.hashCode(), other.hashCode());
    }

    /**
     * compares two ShoppingCart objects based on hashCode
     */
    @Override
    public int compare(Cart<ItemOrder> first, Cart<ItemOrder> second) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);
        return Integer.compare(first.hashCode(), second.hashCode());
    }



}

//end of Cart class