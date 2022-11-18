import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private ArrayList<FoodCategory> menuCategories;
    private String menuName;

    Menu() {
        this.menuName = "Menu";
    }

    Menu(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void categoryAdder(FoodCategory category) {
        menuCategories.add(category);
    }

    //what is this for?
    public void menuAdder(String category, String dishName, double dishCost) {
        FoodItem addToMenu = new FoodItem(category, dishName, dishCost);
        menuCost.put(addToMenu.getDishName(), addToMenu.getDishCost());
    }

}