public class MenuItem {

    private String itemName;
    private double itemCost;

    MenuItem(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public double getItemCost() {
        return itemCost;
    }
}
