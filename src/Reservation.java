import java.time.LocalDateTime;

public class Reservation {
    private String reservationName;
    private static int count = 0;

    private int reservationId;
    private LocalDateTime reservationDate;
    private String phoneNumber;
    private int numPeople;
    private int tableNum;

    public Reservation(String reservationName, LocalDateTime reservationDate, String phoneNumber, int numPeople, int tableNum){
        this.reservationName = reservationName;
        this.reservationDate = reservationDate;
        this.phoneNumber = phoneNumber;
        this.numPeople = numPeople;
        this.tableNum = tableNum;
        // The following code might be error prone, we may have to protect against errors like reservations having the same id
        this.reservationId = ++count;
        // The following code might be error prone, we may have to protect against errors like reservations having the same id
        this.reservationId = ++count;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationName() {
        return reservationName;
    }

    public LocalDateTime getTime(){
        return reservationDate;
    }

    public void sendReminderToCustomer(){

    }

    public int getReservationId() {
        return reservationId;
    }

    public void changeTableStatus(){
        // 1 hour(or more suitable time interval) before table is due to have a
        // reservation turn it's isAvailable variable from true to false
    }
}
