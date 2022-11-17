import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private ArrayList<FoodCategory> menuCategories;
    private HashMap<String, Double> menuCost = new HashMap<String, Double>();

    public void menuAdder(String dishName, double dishCost){
        FoodItem addToMenu = new FoodItem(dishName, dishCost);
        menuCost.put(addToMenu.getDishName(), addToMenu.getDishCost());
    }
}
