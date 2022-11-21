import java.time.LocalDateTime;

public class Reservation {

    private Customer customer;
    private Table table;
    private int numOfPeople;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;

    Reservation(Customer customer, Table table, int numOfPeople, LocalDateTime startTime, LocalDateTime finishTime) {
        this.customer = customer;
        this.table = table;
        this.numOfPeople = numOfPeople;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Table getTable() {
        return table;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public boolean isAvailable(Reservation r) {

        if (r.startTime.compareTo(startTime) >= 0 && r.finishTime.compareTo(finishTime) <= 0) {
            if (table.equals(r.table)) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }
}
