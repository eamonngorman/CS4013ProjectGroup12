import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Order {

    private int orderId;
    private ArrayList<MenuItem> itemsInOrder;
    private double totalCost;
    private double tip;
    private boolean isPaid;

    File ordersCSV = new File("Orders.csv");
    FileWriter fileWriter = new FileWriter(ordersCSV);

    Order() throws IOException {
        this.orderId = 123; //need way to create unique id
        this.itemsInOrder = new ArrayList<MenuItem>();
        this.totalCost = 0;
    }

    public void setTip(double tip){
        this.tip = tip;
    }
    public void setPaid(boolean paid){
        isPaid = paid;
    }

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<MenuItem> getItems() {
        return itemsInOrder;
    }

    public double getTotal() {
        return totalCost;
    }

    public void addToOrder(MenuItem item) {
        itemsInOrder.add(item);
        totalCost += item.getItemCost();
    }

    public void removeFromOrder(MenuItem item) {
        itemsInOrder.remove(item);
        totalCost -= item.getItemCost();
    }

    public void addOrderToCSv() throws IOException {
        StringBuilder line = new StringBuilder();
        line.append(orderId + ",");
        line.append(itemsInOrder + ",");
        line.append(totalCost);
        fileWriter.write(line.toString());
    }

    public void printBill (){  //method to print the bill. will only show tip after the bill has been paid
        double beforeTip = totalCost;
        totalCost += tip;
        System.out.println("Yum Restaurant");
        System.out.println(itemsInOrder);
        System.out.println("Total: " + beforeTip);
        if (isPaid == true){
            System.out.println("Tip: " + tip);
            System.out.println("Grand Total: " + totalCost);
        }
    }
}
