import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CSVWriter {

    public void writeNewCustomerToCSV(String userName, String password, Person person, Restaurant restaurant){
        PrintWriter printWriter;
        try {
            File file = new File("src/PersonDetails.csv");
            printWriter = new PrintWriter(new FileWriter(file, true));
            Scanner input = new Scanner(file);
            StringBuffer csvData = new StringBuffer("");

            if (!input.hasNext()){
                StringBuffer header = new StringBuffer("");
                header.append("Name, Access Level, Username, Password, Restaurant\n");
                printWriter.write(header.toString());
            }
            csvData.append("\n" + person.getName());
            csvData.append(",");
            csvData.append(person.getAccessLevel());
            csvData.append(",");
            csvData.append(userName);
            csvData.append(",");
            csvData.append(password);
            csvData.append(",");
            csvData.append(restaurant.getName());
            csvData.append(",");
            csvData.append(person.getIdNum());


            printWriter.write(csvData.toString());
            printWriter.close();


        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void writeTableToCSV(Table table, Restaurant restaurant){
        PrintWriter printWriter;
        try {
            File file = new File("src/Tables.csv");
            printWriter = new PrintWriter(new FileWriter(file, true));
            Scanner input = new Scanner(file);
            StringBuffer csvData = new StringBuffer("");

            if (!input.hasNext()){
                StringBuffer header = new StringBuffer("");
                header.append("RestaurantName, TableNo, Capacity\n");
                printWriter.write(header.toString());
            }

            csvData.append("\n" + restaurant.getName());
            csvData.append(",");
            csvData.append(table.getTableNum());
            csvData.append(",");
            csvData.append(table.getCanSeat());
            csvData.append(",");

            printWriter.write(csvData.toString());
            printWriter.close();


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
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
                header.append("RestaurantId,Order Id,Items,Total Cost,Gratuity,Order Status,Date, Restaurant name\n");
                printWriter.write(header.toString());
            }

            csvData.append(restaurant.getRestaurantId());//[0]
            csvData.append(",");
            csvData.append(order.getOrderId());//[1]
            csvData.append(",");
            csvData.append(order.getItems().toString());//[2]
            csvData.append(",");
            csvData.append(order.getTotal());//[3]
            csvData.append(",");
            csvData.append(order.getGratuity());//[4]
            csvData.append(",");
            csvData.append(order.getOrderStatus());//[5]
            csvData.append(",");
            csvData.append(timeToString(order.getDate()));//[6]
            csvData.append(",");
            csvData.append(order.getPaymentMethod());//[7]
            csvData.append(",");

            csvData.append(order.getDate().toString());
            csvData.append(",");

            csvData.append(restaurant.getName());//[8]
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
                header.append("ReservationId, numPeople, date, time, tableNo, customerId, Restaurant\n");
                printWriter.write(header.toString());
            }
            csvData.append("\n");
            csvData.append(reservation.getReservationId());
            csvData.append(",");
            csvData.append(reservation.getNumOfPeople());
            csvData.append(",");
            csvData.append(timeToString(reservation.getStartTime()));
            csvData.append(",");
            csvData.append(reservation.getTable().getTableNum());
            csvData.append(",");
            csvData.append(reservation.getCustomer().getIdNum());
            csvData.append(",");
            csvData.append(restaurant.getName());
            csvData.append(",");

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
                header.append("RestaurantName, RestaurantID, Tables, Reservations, People,\n");
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

            csvData.append(",");

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
        int day = t.getDayOfMonth();
        int month = t.getMonthValue();
        int year = t.getYear();
        int hour = t.getHour();
        int min = t.getMinute();
        
        time = String.format("%02d/%02d/%d %02d:%02d", day, month, year, hour, min);

        return time;
    }
}
