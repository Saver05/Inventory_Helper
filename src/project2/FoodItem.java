/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 * Creates the food items for use in the inventory and storage classes
 *
 * @author jfram
 */
public class FoodItem {

    private String name; //the name of the inventory
    private String description; //the description of the inventory
    private String expDate; //the expiration date of the inventory
    private String category; //the category of the inventory
    private int quantity; //the qunatity of the inventory

    /**
     * Constructor for class FoodItem
     *
     * @param n String name
     * @param d String description
     * @param e String expDate
     * @param c String category
     */
    public FoodItem(String n, String d, String e, String c) {
        name = n;
        description = d;
        expDate = e;
        category = c;
        quantity = 1;
    }

    /**
     * Constructor for class FoodItem
     *
     * @param n String name
     * @param d String description
     * @param e String expDate
     * @param c String category
     * @param q Int quantity
     */
    public FoodItem(String n, String d, String e, String c, int q) {
        name = n;
        description = d;
        expDate = e;
        category = c;
        quantity = q;
    }

    /**
     * returns the name of the food item
     *
     * @return returns name
     */
    public String getName() {
        return name;
    }

    /**
     * returns the description of the food item
     *
     * @return returns description
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns the expiration month of the food item
     *
     * @return returns month
     */
    public int getExpMonth() {
        String m = expDate.substring(0, 2);
        int month = Integer.parseInt(m);
        return month;
    }

    /**
     * returns the expiration day of the food item
     *
     * @return returns day
     */
    public int getExpDay() {
        String d = expDate.substring(3, 5);
        int day = Integer.parseInt(d);
        return day;
    }

    /**
     * returns the expiration year of the food item
     *
     * @return returns year
     */
    public int getExpYear() {
        String y = expDate.substring(6, 8);
        int year = Integer.parseInt(y);
        return year;
    }

    /**
     * returns the quantity of the food item
     *
     * @return returns quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * returns the category of the food item
     *
     * @return returns category
     */
    public String getCategory() {
        return category;
    }

    /**
     * sets the quantity of the food item
     *
     * @param q the integer of the quantity you would like the food item to be
     * set to
     */
    public void setQuantity(int q) {
        this.quantity = q;
    }

    /**
     * basic toString method returning all available information about an item
     *
     * @return returns all information on inventory item
     */
    @Override
    public String toString() {
        return "[" + category + "] " + name + " [" + description + "] " + expDate + " Quantity: " + quantity;
    }

}