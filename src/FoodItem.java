import java.util.ArrayList;

public class FoodItem extends FoodCategory{

    private String dishName;
    private double dishCost;
    /**
    private boolean isVegan;
    private boolean containsMeat;
    private boolean containsGluten;
    private boolean containsCrustaceans;
    private boolean containsEggs;
    private boolean containsFish;
    private boolean containsPeanuts;
    private boolean containsSoyBeans;
    private boolean containsDairy;
    private boolean containsTreeNuts;
    */
    //private HashMap<String, String> categorizedMenu;

    FoodItem(String category, String dishName, double dishCost) {
        super(category);
        this.dishName = dishName;
        this.dishCost = dishCost;
    }

    public double getDishCost() {
        return dishCost;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishCost(double dishCost) {
        this.dishCost = dishCost;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    // public void foodToCategory(String category, String dishName){
    //     categorizedMenu.put(category, dishName);
    //     }
}