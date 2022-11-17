public class FoodItem extends FoodCategory{
    
    private String dishName;
    private double dishCost;
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

    public FoodItem(String dishName, double dishCost){
        this.dishName = dishName;
        this.dishCost = dishCost;
    }

    
    public double getDishCost() {
        return dishCost;
    }

    public String getDishName(){
        return dishName;
    }

}
