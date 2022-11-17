import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

public class ReservationCalendar {
    private ArrayList<Reservation> listReservations = new ArrayList<Reservation>();

    public void addReservation(Reservation reservation) throws Exception {

        int flag = 0;

        for (Reservation r : listReservations) {

            //get time + & - 1hour from a reservation
            LocalDateTime before = r.getTime().plusHours(1);
            LocalDateTime after = r.getTime().minusHours(1);
            
            //only add reservation if there is a 1hour gap (+ or - 1hr)
            //this could be made so that a member of staff chooses the buffer timeframe
            if(reservation.getTime().compareTo(before) == -1 || 
                reservation.getTime().compareTo(after) == 1){
                flag = 1;
            }
        }

        if (flag == 1) {
            listReservations.add(reservation);
            
        } else {
            //need to create an exception
            throw new Exception("This reservation already exists");
            //need to create an exception
        }

    }

    public void removeReservation(Reservation reservation){
    
        int reservationId = reservation.getReservationId();

        
    }


    public ArrayList<Reservation> getReservationsForDay(int day, int month, int year) {

        ArrayList<Reservation> reservationsToday = new ArrayList<Reservation>();
        for (Reservation r : listReservations) {

            if((r.getTime()).get(ChronoField.DAY_OF_MONTH) == day &&
            (r.getTime()).get(ChronoField.MONTH_OF_YEAR) == month &&
            (r.getTime()).get(ChronoField.YEAR) == year){
                
                reservationsToday.add(r);
            }
        }    

        return reservationsToday;
    }
}
