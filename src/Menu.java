import java.util.ArrayList;
//import java.util.HashMap;

public class Menu {
    private ArrayList<FoodItem> menuCategories;
    private ArrayList<FoodItem> outCategories;
    //private HashMap<String, Double> menuCost = new HashMap<String, Double>();

    /** not used at the minute
     * public void menuAdder(String category, String dishName, double dishCost){
        FoodItem addToMenu = new FoodItem(category, dishName, dishCost);
        menuCost.put(addToMenu.getDishName(), addToMenu.getDishCost());
    }
    */

    public void addCategorizedMenu(String category,String dishName, double dishCost){ //to add a FoodItem to an ArrayList
        FoodItem cat = new FoodItem(category, dishName, dishCost);
        menuCategories.add(cat);
    }
    public void removeCategorizedMenu(String category,String dishName, double dishCost){ //to remove a FoodItem from an arraylist
        FoodItem cat = new FoodItem(category, dishName, dishCost);
        menuCategories.remove(cat);
    }

    public ArrayList<FoodItem> getCategories(String category){ //user searches for a category and this returns an ArrayList of all FoodItems 
        for (int i = 0; i < menuCategories.size(); i++){
            if (menuCategories.get(i).getCategoryName() == category){
                outCategories.add(menuCategories.get(i));
            }
        }
        return outCategories;
    }
}

