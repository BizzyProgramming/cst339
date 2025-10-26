package com.gcu.model;

/**
 * CartItem
 *
 * Represents a single product entry in a user's shopping cart.
 * Includes quantity, unit pricing, and automatically calculated
 * line totals for both price and in-game coins.
 */
public class CartItem {

    private int productId;
    private String productName;
    private float unitPrice;
    private int coinsPerUnit;
    private int quantity;      // Quantity of this product
    private float linePrice;   // unitPrice * quantity
    private int lineCoins;     // coinsPerUnit * quantity

    /** Default constructor. */
    public CartItem() {}

    /**
     * Constructs a CartItem with all fields initialized.
     *
     * @param productId     the product’s unique ID
     * @param productName   the product’s name
     * @param unitPrice     the product’s price per unit
     * @param coinsPerUnit  the number of coins per unit
     * @param quantity      how many units the user selected
     */
    public CartItem(int productId, String productName, float unitPrice, int coinsPerUnit, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.coinsPerUnit = coinsPerUnit;
        this.quantity = quantity;
        recalc();
    }

    /** Recalculates the derived totals for price and coins. */
    public void recalc() {
        this.linePrice = unitPrice * quantity;
        this.lineCoins = coinsPerUnit * quantity;
    }

    // Getters and Setters

    public int getProductId() { 
        return productId; 
    }
    public void setProductId(int productId) { 
        this.productId = productId; 
    }

    public String getProductName() { 
        return productName; 
    }
    public void setProductName(String productName) { 
        this.productName = productName; 
    }

    public float getUnitPrice() { 
        return unitPrice; 
    }
    public void setUnitPrice(float unitPrice) { 
        this.unitPrice = unitPrice; recalc(); 
    }

    public int getCoinsPerUnit() { 
        return coinsPerUnit; 
    }
    public void setCoinsPerUnit(int coinsPerUnit) { 
        this.coinsPerUnit = coinsPerUnit; recalc(); 
    }

    public int getQuantity() { 
        return quantity; 
    }
    public void setQuantity(int quantity) { 
        this.quantity = quantity; recalc(); 
    }

    public float getLinePrice() { 
        return linePrice; 
    }
    public int getLineCoins() { 
        return lineCoins; 
    }
}