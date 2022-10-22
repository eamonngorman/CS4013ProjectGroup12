import java.time.LocalDateTime;

public class Reservation {
    private String reservationName;
    private int reservationId; // There might be a better way of implementing this. Ideas? - Eamonn
    private LocalDateTime reservationDate;
    private String phoneNumber;
    private int numPeople;

    public Reservation(String reservationName, LocalDateTime reservationDate, String phoneNumber, int numPeople){
        this.reservationName = reservationName;
        this.reservationDate = reservationDate;
        this.phoneNumber = phoneNumber;
        this.numPeople = numPeople;
    }


    public void sendReminderToCustomer(){

    }
}
