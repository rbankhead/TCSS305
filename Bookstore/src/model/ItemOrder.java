/*
 * TCSS 305 Assignment 2 - Online Bookstore
 */

package model;

import java.util.Objects;

/**
 * ItemOrder holds items and their order quantities for the Online Bookstore project
 * 
 * @author richardbankhead
 * @version 01/17/20
 */
public final class ItemOrder {
    
    /** Item for this order */
    private final Item item;
    
    /** quantity of the individual item for this order */
    private final int quantity;

    /**
     * constructor for ItemOrders, initializes with an item and number of those items that are being added to the order
     * @param theItem the item
     * @param theQuantity the quantity of theItem that will be added to the order
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        item = Objects.requireNonNull(theItem);
        if (theQuantity<0) {
            throw new IllegalArgumentException();
        }
        quantity = theQuantity;
    }

    /**
     * getter for the item on this order
     * @return item object for the item on this order
     */
    public Item getItem() {
        return item;
    }
    
    /**
     * getter for the quantity of the item on this order
     * @return int value for the number of items on this order
     */
    public int getQuantity() {
        return quantity;
    }

    @Override
    /**
     * toString() override to return a string that will read "item, quantity: quantity"
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(item);
        builder.append(", quantity: ");
        builder.append(quantity);
        return builder.toString();
    }

}

//end of class ItemOrder