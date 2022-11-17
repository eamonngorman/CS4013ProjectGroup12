public class ReservationDate {

    private int year;
    private int month;
    private int day;


    ReservationDate(int year, int month, int date){
        this.year = year;
        this.month = month;
        this.day = day;
    }


    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
