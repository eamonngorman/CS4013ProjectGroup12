import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuCategory> menuCategories = new ArrayList<>();
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

    public void addCategory(MenuCategory category) {
        menuCategories.add(category);
    }

    public void removeCategory(MenuCategory category) {
        menuCategories.remove(category);
    }

    public ArrayList<MenuCategory> getCategories() {
        return menuCategories;
    }
}
