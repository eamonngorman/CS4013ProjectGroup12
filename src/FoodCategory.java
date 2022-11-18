import java.util.ArrayList;

public class FoodCategory {

    private ArrayList<FoodItem> menuItems;
    private String category;

    FoodCategory(String category) {
        this.category = category;
    }

    public String getCategoryName() {
        return category;
    }

    public void setCategories(String category) {
        this.category = category;
    }

    public void addFoodToCategory(FoodItem food) {
        menuItems.add(food);
    }

    public void removeFoodFromCategory(FoodItem food) {
        menuItems.remove(food);
    }
}
