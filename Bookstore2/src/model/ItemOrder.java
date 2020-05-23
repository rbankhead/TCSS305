/*
 * TCSS 305 Assignment 2 - Online Bookstore
 */

package model;

import java.util.Objects;

/**
 * ItemOrder holds items and their order quantities for the Online Bookstore project
 * 
 * @author richardbankhead
 * @version 02/13/20
 */
public final class ItemOrder implements Comparable<ItemOrder>{
    
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


    /**
     * toString() override to return a string that will read "item, quantity: quantity"
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(item);
        builder.append(", quantity: ");
        builder.append(quantity);
        return builder.toString();
    }
    
    /**
     * tests for equality between this and other, they are equal if they have the same item and same quantity
     * returns a boolean
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        ItemOrder otherItemOrder = (ItemOrder) other;
        return item.equals(otherItemOrder.getItem()) 
                        && (quantity == otherItemOrder.getQuantity());
    }
    
    /**
     * returns an ItemOrders hashCode based on the item and quantity in the order
     */
    @Override
    public int hashCode() {
        return Objects.hash(item, quantity);
    }

    /**
     * compares this and other ItemOrders based on their hashCodes
     */
    @Override
    public int compareTo(ItemOrder other) {
        return Integer.compare(this.hashCode(), other.hashCode());
    }

}

//end of class ItemOrder