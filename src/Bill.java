public class Bill {
    private Order order;
    private double billTotal;
    private double gratuity;
    private boolean cashOrCredit; // cash = false; credit = true;
    private boolean isPaid;

    public Bill (Order order){
        this.order = order;

        this.billTotal = 0;
        for (FoodItem item : order.getOrder()){
            this.billTotal += FoodItem.getDishCost();
        }
    }

    public void setCashOrCredit(boolean cashOrCredit) {
        this.cashOrCredit = cashOrCredit;
    }

    public void setGratuity(double gratuity) {
        this.gratuity = gratuity;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }

    public double getBillTotal() {
        return billTotal;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
