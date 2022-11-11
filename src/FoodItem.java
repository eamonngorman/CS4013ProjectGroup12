public class FoodItem extends FoodCategory{
    
    private String dishName;
    private static double dishCost;
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

    
    public double getDishCost() {
        return dishCost;
    }

}
