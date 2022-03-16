/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 * Inventory class food food items
 *
 * @author jfram
 */
public class Inventory {

    private Storage storage; //incorportates storage

    /**
     * Constructor for inventory creates storage objects
     */
    public Inventory() {
        storage = new Storage(); //created storage object
    }

    /**
     * adds a food item to storage
     *
     * @param food a food item
     */
    public void add(FoodItem food) {
        storage.setStart();
        int dontAdd = 0;
        String category = food.getCategory();
        String name = food.getName();
        int expDay = food.getExpDay();
        int expMonth = food.getExpMonth();
        int expYear = food.getExpYear();
        while (storage.hasNext()) {
            FoodItem check = storage.next();
            String CheckCategory = check.getCategory();
            String CheckName = check.getName();
            int CheckexpDay = check.getExpDay();
            int CheckexpMonth = check.getExpMonth();
            int CheckexpYear = check.getExpYear();
            if (name.equals(CheckName)) //check tree to see if any are the same
            {
                if (category.equals(CheckCategory)) {
                    if (expDay == CheckexpDay) {
                        if (expMonth == CheckexpMonth) {
                            if (expYear == CheckexpYear) {
                                int quant1 = food.getQuantity();
                                int quant2 = check.getQuantity();
                                int quant = quant1 + quant2; //adds the quantity of the two same items together 
                                check.setQuantity(quant);
                                dontAdd = 1;
                            }
                        }
                    }
                }
            }
        }
        if (dontAdd < 1) {
            storage.add(food);
        }
    }

    /**
     * returns all items in storage
     */
    public void reportAll() {
        storage.setStart();
        while (storage.hasNext()) {
            FoodItem food = storage.next();
            System.out.println(food.toString());
        }
    }

    /**
     * returns all items in a certain category
     *
     * @param category any category name will return nothing if no item is in
     * category
     */
    public void reportCategory(String category) {
        storage.setStart();
        while (storage.hasNext()) {
            FoodItem food = storage.next();
            String cat = food.getCategory();
            if (category.equals(cat)) {
                System.out.println(food);
            }
        }
    }

    /**
     * Returns the # of items in a given category
     *
     * @param category any category name
     */
    public void reportCounCategory(String category) {
        storage.setStart();
        int count = 0;
        while (storage.hasNext()) {
            FoodItem food = storage.next();
            String cat = food.getCategory();
            if (category.equals(cat)) {
                count++;
            }
        }
        System.out.println("There are " + count + " items in " + category + " category");
    }

    /**
     * Returns what items are expiring in the current month
     *
     * @param currM the number of the current month
     * @param currY the number of the current year
     */
    public void reportExpiringSonn(int currM, int currY) {
        storage.setStart();
        int count = 0;
        while (storage.hasNext()) {
            FoodItem food = storage.next();
            int expM = food.getExpMonth();
            int expY = food.getExpYear();
            if (currM == expM && currY == expY) {
                if (count == 0) {
                    System.out.println("Expiring soon");
                    count++;
                }
                System.out.println(food);
            }
        }
        if (count == 0) {
            System.out.println("Nothing is expiring soon");
        }
    }
}