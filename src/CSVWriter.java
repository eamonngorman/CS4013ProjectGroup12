import java.io.*;
import java.util.Scanner;

public class CSVWriter {

    public void writeOrderToCSV(Order order){
        PrintWriter printWriter;
        try {
            File file = new File("orders.csv");
            printWriter = new PrintWriter(new FileWriter(file, true));
            Scanner input = new Scanner(file);
            StringBuffer csvData = new StringBuffer("");

            if (!input.hasNext()){
                StringBuffer header = new StringBuffer("");
                header.append("Order Id,Items,Total Cost,Gratuity,Order Status\n");
                printWriter.write(header.toString());
            }
            csvData.append(order.getOrderId());
            csvData.append(",");
            csvData.append(order.getItems().toString());
            csvData.append(",");
            csvData.append(order.getTotal());
            csvData.append(",");
            csvData.append(order.getGratuity());
            csvData.append(",");
            csvData.append(order.getOrderStatus());
            csvData.append(",\n");

            printWriter.write(csvData.toString());
            printWriter.close();


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeReservationToCSV(Reservation reservation){
        PrintWriter printWriter;
        try {
            File file = new File("reservations.csv");
            printWriter = new PrintWriter(new FileWriter(file, true));
            Scanner input = new Scanner(file);
            StringBuffer csvData = new StringBuffer("");

            if (!input.hasNext()){
                StringBuffer header = new StringBuffer("");
                header.append("ReservationId, numPeople, date, time, tableNo, customerId\n");
                printWriter.write(header.toString());
            }
            csvData.append(reservation.getReservationId());
            csvData.append(",");
            csvData.append(reservation.getNumOfPeople());
            csvData.append(",");
            csvData.append(reservation.getDate().toString());
            csvData.append(",");
            csvData.append(reservation.getStart());
            csvData.append(",");
            csvData.append(reservation.getTable().getTableNum());
            csvData.append(",");
            csvData.append(reservation.getCustomer().getIdNum());
            csvData.append(",\n");

            printWriter.write(csvData.toString());
            printWriter.close();


        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
