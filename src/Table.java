public class Table {
    private int tableNo;
    private int tableCounter = 1;

    //private boolean isReserved;
    public boolean isAvailable() {
        return true;


    }

    private int canSeatXCustomers;

    Table(int tableNum){
        this.canSeatXCustomers = canSeatXCustomers;
        this.tableNo = tableCounter;
        tableCounter++;
    }

    public int getTableNo(){
        return tableNo;
    }

    public int getNumSeats(){
        return canSeatXCustomers;
    }

    public void setCurrentOrder(Order order) {
    }

    public String toString(){
        
        String print = "Table: " + getTableNo() + "\n" +
        "Can seat: " + getNumSeats() + "\n";

        return print;
    }


}
