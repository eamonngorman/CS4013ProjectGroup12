import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Reservation {

    private Customer customer;
    private Table table;
    private int numOfPeople; // not needed?
    private LocalDateTime startTime;
    private static int reservationMinutes = 90;
    private LocalDateTime finishTime;
    File reservationsCSV = new File("Reservations.csv");
    FileWriter fileWriter = new FileWriter(reservationsCSV);

    Reservation(Customer customer, Table table, int numOfPeople, LocalDateTime startTime) throws IOException {
        this.customer = customer;
        this.table = table;
        this.numOfPeople = numOfPeople;
        this.startTime = startTime;
        this.finishTime = startTime.plusMinutes(reservationMinutes);
    }

    Reservation(Customer customer, Table table, int numOfPeople, LocalDateTime startTime, LocalDateTime finishTime) throws IOException{
        this.customer = customer;
    Reservation(Table table, LocalDateTime startTime) {
        this.table = table;
        this.startTime = startTime;
        this.finishTime = startTime.plusMinutes(reservationMinutes);
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
    public void addReservationToCsv() throws IOException{
        StringBuilder line = new StringBuilder();
        line.append(customer + ",");
        line.append(table + ",");
        line.append(numOfPeople + ",");
        line.append(startTime + ",");
        line.append(finishTime);
        line.append("\n");
        fileWriter.write(line.toString());
    }

    public static int getReservationMinutes() {
        return reservationMinutes;
    }

    public void setReservationMinutes(int minutes) {
        this.reservationMinutes = minutes;
    }

    // true = is available
    // false = not available
    public boolean isAvailable(Reservation r) {

        if (r.startTime.compareTo(this.startTime) >= 0 &&
                r.startTime.compareTo(this.finishTime) <= 0) {
            if (this.table.equals(r.table)) {
                return false;
            } 
        }
        return true;
    }

    
}