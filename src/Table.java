public class Table {
    private int tableNo;
    private int tableCounter = 1;
    private boolean isCurrentlyAvailable;

    //private boolean isReserved;
    public boolean isCurrentlyAvailable() {
        return isCurrentlyAvailable;
    }

    public void setCurrentlyAvailable(boolean currentlyAvailable) {
        isCurrentlyAvailable = currentlyAvailable;
    }

    private int canSeatXCustomers;
    private Order currentOrder;

    Table(int tableNum){
        this.canSeatXCustomers = canSeatXCustomers;
        this.tableNo = tableCounter;
        this.tableCounter++;
    }

    public int getTableNo(){
        return tableNo;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }


    public int getNumSeats(){
        return canSeatXCustomers;
    }


    public String toString(){
        
        String print = "Table: " + getTableNo() + "\n" +
        "Can seat: " + getNumSeats() + "\n";

        return print;
    }


}
