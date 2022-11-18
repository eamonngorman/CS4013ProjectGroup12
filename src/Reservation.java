import java.time.LocalDateTime;

public class Reservation {
    private static int count = 0; //what is this for

    private int reservationId;
    private LocalDateTime reservationDate;
    private LocalDateTime reservationLength;
    private Table table;
    private Customer customer;
    private int numPeople;

    public Reservation(Table table, Customer customer) {
        this.table = table;
        this.customer = customer;
    }

    public Reservation(LocalDateTime reservationDate, Customer customer, int numPeople, Table table) {
        this.reservationDate = reservationDate;
        this.reservationLength = reservationDate.plusHours(2);
        this.customer = customer;
        this.table = table;
        //this.phoneNumber = phoneNumber;
        this.numPeople = numPeople;
        //this.tableNum = tableNum;
        // The following code might be error prone, we may have to protect against errors like reservations having the same id
        this.reservationId = ++count;
    }

    public LocalDateTime getTime() {
        return reservationDate;
    }

    public void sendReminderToCustomer() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void changeTableStatus() {
        // 1 hour(or more suitable time interval) before table is due to have a
        // reservation turn it's isAvailable variable from true to false
    }
}
