import java.time.LocalDateTime;

public class Reservation {
    private String reservationName;
    private int reservationId; // There might be a better way of implementing this. Ideas? - Eamonn
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
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void sendReminderToCustomer(){

    }

    public void makeTableNotAvailable(){
        // 1 hour(or more suitable time interval) before table is due to have a
        // reservation turn it's isAvailable variable from true to false
    }
}
