import java.util.ArrayList;

public class MenuCategory {

    private ArrayList<MenuItem> menuItems;
    private String categoryName;

    MenuCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<MenuItem> getMenuItems(ArrayList<MenuItem> menuItems) {
        return menuItems;
    }

    public void addMenuItem(MenuItem itemToAdd) {
        menuItems.add(itemToAdd);
    }

    public void removeMenuItem(MenuItem itemToAdd) {
        menuItems.remove(itemToAdd);
    }
}
