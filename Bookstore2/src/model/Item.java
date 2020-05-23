/*
 * TCSS 305 Assignment 2 - Online Bookstore
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Item provides item information for the Online Bookstore project
 * 
 * @author Richard Bankhead
 * @version 02/13/20
 */
public final class Item implements Comparable<Item>, Comparator<Item>{
    
    /** String containing the name of the item */
    private final String name;
    
    /** BigDecimal object representing the default price of an individual item */
    private final BigDecimal price;
    
    /** integer quantity representing the number items */
    private final int bulkQuantity;
    
    /** BigDecimal object representing the total price for a group of n items, where n is equal to theBulkQuantity  */
    private final BigDecimal bulkPrice;
    
    /** boolean which is false if the user does not have a membership, true if they do have a membership */
    private final boolean bulkOption;
    
    /** NumberFormat to display the "$" in the toString() method. Initialized here to conserve memory */
    private final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * constructor for the Item object, for items which do not have a bulk price and bulk quantity
     * @param theName name of the item
     * @param thePrice default(or non_bulk) price for the item
     */
    public Item(final String theName, final BigDecimal thePrice) {
        name = Objects.requireNonNull(theName);
        
        //throws IllegalArgumentException if a price less than zero is entered
        if (thePrice.compareTo(BigDecimal.ZERO)<0) {
            throw new IllegalArgumentException();
        }
        price = Objects.requireNonNull(thePrice);
        
        //bulkQuantity set to zero for items without a bulk option
        bulkQuantity = 0;
        
        //bulkPrice left as null for items without a bulk option
        bulkPrice = null;
        
        //explicitly making bulkOption false for items without a bulk option
        bulkOption = false;
    }
    /**
     * constructor for the Item object, for items which have both a bulk quantity and bulk price
     * @param theName name of the item
     * @param thePrice default price of the item
     * @param theBulkQuantity quantity required for bulk order discount
     * @param theBulkPrice total price for a group of n items, where n is equal to theBulkQuantity
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        name = Objects.requireNonNull(theName);
        
        //throws IllegalArgumentException if a price less than zero is entered
        if (thePrice.compareTo(BigDecimal.ZERO)<0) {
            throw new IllegalArgumentException();
        }
        price = thePrice;
        
        //initialize bulk variables for items with bulk options
        if (theBulkQuantity<0) {
            throw new IllegalArgumentException();
        }
        bulkQuantity = theBulkQuantity;
        bulkPrice = Objects.requireNonNull(theBulkPrice);
        bulkOption=true;
    }
    public String getName() {
        return name;
    }
    /**
     * getter for item price
     * @return individual price of an item
     */
    public BigDecimal getPrice() {
        return price;
    }
    /**
     * getter for the quantity required for a bulk discount
     * @return int value for number of items required to get bulk discount
     */
    public int getBulkQuantity() {
        return bulkQuantity;
    }
    /**
     * getter for bulk price
     * @return BigDecimal value for total price for a group of n items, where n is equal to theBulkQuantity
     */
    public BigDecimal getBulkPrice() {
        return bulkPrice;
    }
    /**
     * getter for an items bulk option. false indicates no bulk option, true indicated bulk option is available
     * @return boolean representing if an item has a bulk discount or not
     */
    public boolean isBulk() {
        return bulkOption;
    }


    @Override
    /**
     * override toString method, formats output as "itemname, $price" and if this item has a bulk option also add " (bulkQuantity for bulkPrice)
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + ", " + nf.format(getPrice()));
        if(bulkOption) {
            builder.append(" (" + getBulkQuantity() + " for " + nf.format(getBulkPrice()) + ")");
        }
        return builder.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (getClass() != other.getClass()) return false;
        Item otherItem = (Item) other;
        if (bulkOption) {
            return name.equals(otherItem.getName()) 
                            && price.equals(otherItem.getPrice()) 
                            && bulkPrice.equals(otherItem.getBulkPrice()) 
                            && (bulkQuantity == otherItem.getBulkQuantity());
        }
        return name.equals(otherItem.getName()) 
                        && price.equals(otherItem.getPrice());          
    }
    
    /**
     * returns a hashCode based on all parameters for the Item object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price, bulkQuantity, bulkPrice, bulkOption);
    }

    /**
     * compares two items based on the alphabetical order of the item names
     */
    @Override
    public int compareTo(Item other) {
        Objects.requireNonNull(other);
        return this.getName().compareTo(other.getName());
    }
    /**
     * compares two items based on their prices
     */
    @Override
    public int compare(Item first, Item second) {
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);
        return first.getPrice().compareTo(second.getPrice());
    }

}
//end of class Item
