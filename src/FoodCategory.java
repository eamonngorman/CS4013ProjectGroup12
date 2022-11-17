import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FoodCategory {
    private ArrayList<FoodItem> menuItems;
    private String category;
    private ArrayList<String> categories;
    public FoodCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    }
    public ArrayList<String> getCategories(){
        return categories;
    }
}

