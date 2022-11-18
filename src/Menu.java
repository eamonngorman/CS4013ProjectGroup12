import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private ArrayList<FoodItem> menuCategories;
    private HashMap<String, Double> menuCost = new HashMap<String, Double>();

    public void menuAdder(String category, String dishName, double dishCost){
        FoodItem addToMenu = new FoodItem(category, dishName, dishCost);
        menuCost.put(addToMenu.getDishName(), addToMenu.getDishCost());
    }

    public void categorizedMenu(String category,String dishName, double dishCost){
        FoodItem cat = new FoodItem(category, dishName, dishCost);
        menuCategories.add(cat);
    }
}

