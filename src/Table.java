public class Table {
    private int tableNo;
    private boolean isReserved;
    private boolean isAvailable;
    private int canSeatXCustomers;

    Table(int tableNum, int canSeatXCustomers){
        
        this.canSeatXCustomers = canSeatXCustomers;
        this.tableNo = tableNum;
    }

    public int getTableNo(){
        return tableNo;
    }

    public int getNumSeats(){
        return canSeatXCustomers;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String toString(){
        
        String print = "Table: " + getTableNo() + "\n" +
        "can seat: " + getNumSeats();

        return print;
    }
}
