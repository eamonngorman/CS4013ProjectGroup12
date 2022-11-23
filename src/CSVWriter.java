import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CSVWriter {

    public void writeNewCustomerToCSV(String[] details){
        PrintWriter printWriter;
        try {
            File file = new File("src/PersonDetails.csv");
            printWriter = new PrintWriter(new FileWriter(file, true));
            Scanner input = new Scanner(file);
            StringBuffer csvData = new StringBuffer("");

            if (!input.hasNext()){
                StringBuffer header = new StringBuffer("");
                header.append("Name, Access Level, Username, Password\n");
                printWriter.write(header.toString());
            }
            csvData.append("\n" + details[0]);
            csvData.append(",");
            csvData.append("0");
            csvData.append(",");
            csvData.append(details[1]);
            csvData.append(",");
            csvData.append(details[2]);
            csvData.append(",");

            printWriter.write(csvData.toString());
            printWriter.close();


        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void writeOrderToCSV(Order order, Restaurant restaurant){
        PrintWriter printWriter;
        try {
            File file = new File("src/Orders.csv");
            printWriter = new PrintWriter(new FileWriter(file, true));
            Scanner input = new Scanner(file);
            StringBuffer csvData = new StringBuffer("");

            if (!input.hasNext()){
                StringBuffer header = new StringBuffer("");
                header.append("RestaurantId,Order Id,Items,Total Cost,Gratuity,Order Status,Date\n");
                printWriter.write(header.toString());
            }

            csvData.append(restaurant.getRestaurantId());
            csvData.append(",");
            csvData.append(order.getOrderId());
            csvData.append(",");
            csvData.append(order.getItems().toString());
            csvData.append(",");
            csvData.append(order.getTotal());
            csvData.append(",");
            csvData.append(order.getGratuity());
            csvData.append(",");
            csvData.append(order.getOrderStatus());
            csvData.append(",");
            csvData.append(order.getDate().toString());
            csvData.append(",\n");

            printWriter.write(csvData.toString());
            printWriter.close();


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeReservationToCSV(Reservation reservation, Restaurant restaurant){
        PrintWriter printWriter;
        try {
            File file = new File("src/Reservations.csv");
            printWriter = new PrintWriter(new FileWriter(file, true));
            Scanner input = new Scanner(file);
            StringBuffer csvData = new StringBuffer("");

            if (!input.hasNext()){
                StringBuffer header = new StringBuffer("");
                header.append("ReservationId, numPeople, date, time, tableNo, customerId, Restuarant\n");
                printWriter.write(header.toString());
            }
            csvData.append(reservation.getReservationId());
            csvData.append(",");
            csvData.append(reservation.getNumOfPeople());
            csvData.append(",");
            csvData.append(reservation.getDate().toString());
            csvData.append(",");
            csvData.append(timeToString(reservation.getStartTime()));
            csvData.append(",");
            csvData.append(reservation.getTable().getTableNum());
            csvData.append(",");
            csvData.append(reservation.getCustomer().getIdNum());
            csvData.append(",");
            csvData.append(restaurant.getName());
            csvData.append(",\n");

            printWriter.write(csvData.toString());
            printWriter.close();


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeRestaurantToCSV(Restaurant restaurant){
        // RestaurantName, RestaurantID, Tables, Reservations, People
        PrintWriter printWriter;
        try {
            File file = new File("src/Restaurants.csv");
            printWriter = new PrintWriter(new FileWriter(file, true));
            Scanner input = new Scanner(file);
            StringBuffer csvData = new StringBuffer("");

            if (!input.hasNext()){
                StringBuffer header = new StringBuffer("");
                header.append("RestaurantName, RestaurantID, Tables, Reservations, People\n");
                printWriter.write(header.toString());
            }
            csvData.append(restaurant.getName());
            csvData.append(",");
            csvData.append(restaurant.getRestaurantId());
            csvData.append(",");

            for (Table table: restaurant.getTables()){
                csvData.append(table.getTableNum());
                csvData.append(",");
                csvData.append(table.getCanSeat());
                csvData.append(",");
            }
            for (Reservation reservation: restaurant.getReservations()){

            }

            csvData.append(",\n");

            printWriter.write(csvData.toString());
            printWriter.close();


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String timeToString(LocalDateTime t) {

        String time = "";
        String day = Integer.toString(t.getDayOfMonth());
        String month = Integer.toString(t.getMonthValue());
        String year = Integer.toString(t.getYear());
        String hour = Integer.toString(t.getHour());
        String min = Integer.toString(t.getMinute());
        
        time = day + "/" + month + "/" + year + " " + hour + ":" + min; 

        return time;
    }
}
