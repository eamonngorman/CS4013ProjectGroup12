import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FoodCategory {
    private ArrayList<FoodItem> menuItems;
    private String category;
    public FoodCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
}

