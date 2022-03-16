/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * This is a basic Inventory manager for any food stores allows you to keep
 * track of your inventory and what items you have in your store at any given
 * time
 *
 * @author jfram
 */
public class Project2JAF {

    /**
     * Main function of program
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Inventory inven = new Inventory(); //main call for the inventory system
        try {
            File foodData = new File("food.txt"); //file food.txt has all of your inventory items iterated by "$"
            Scanner scan = new Scanner(foodData);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                FoodItem f = processLine(data);
                inven.add(f);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //inven.reportAll();
        inven.reportCategory("snack");
        inven.reportCounCategory("snack");
        inven.reportExpiringSonn(12, 21);
    }

    /**
     * This method extracts all of your items from the food.txt file
     *
     * @param d This is the food.txt file that has all inventory iterated by "$"
     * @return Returns an item with all available data for your different
     * products
     */
    public static FoodItem processLine(String d) {
        String delims = "[$]+"; //deliminator 
        String[] fields = d.split(delims); //splits the fields by the deliminator
        int quant = Integer.parseInt(fields[4]); //gets the quantity to integer
        FoodItem food = new FoodItem(fields[0], fields[1], fields[2], fields[3], quant); //adds all items to a food item
        return food; //returns the food item
    }
}
