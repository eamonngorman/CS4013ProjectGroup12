import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {



    /*public void readOrdersFromCSV() throws FileNotFoundException {
        int orderId = 1;
        File file = new File("Orders.csv");
        Scanner input = new Scanner(file);

        /*
        orderId; field 1
    private ArrayList<MenuItem> itemsInOrder; field 2
    private double totalCost; field 3
    private double gratuity; field 4
    private boolean isPaid; field 5
    private String orderStatus; field 6

    Order Id,Items,Total Cost,Gratuity,Order Status,Date





        while (input.hasNext()){
            int isOrderNum = input.nextInt();

        }
    }*/


    public boolean signIn(String username, String password){
        boolean signInSuccess = false;
        try {
            File file = new File("PersonDetails.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()){
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");

                if (username == dataFields[2]){
                    if (password == dataFields[3]){
                        signInSuccess = true;
                    }
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return signInSuccess;
    }

    public ArrayList<Double> readPaymentsFromCSV() {
        ArrayList<Double> payments = new ArrayList<Double>();
        try {
            File file = new File("Orders.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()){
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");

                Double payment = Double.parseDouble(dataFields[2]);
                payments.add(payment);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return payments;
    }

    public ArrayList<Double> readPaymentsFromCSV(LocalDate startDate, LocalDate endDate) {
        ArrayList<Double> payments = new ArrayList<Double>();

        try {
            File file = new File("Orders.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()) {
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");
                LocalDate csvDate = LocalDate.parse(dataFields[5]);
                if (csvDate.isAfter(startDate) && csvDate.isBefore(endDate)) {
                    Double payment = Double.parseDouble(dataFields[2]);
                    payments.add(payment);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return payments;
    }

    public ArrayList<Double> readPaymentsFromCSV(DayOfWeek day) {
        ArrayList<Double> payments = new ArrayList<Double>();
        try {
            File file = new File("Orders.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()){
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");
                LocalDate csvDate = LocalDate.parse(dataFields[5]);
                DayOfWeek weekDay = csvDate.getDayOfWeek();
                if (weekDay == day) {
                    Double payment = Double.parseDouble(dataFields[2]);
                    payments.add(payment);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return payments;
    }

    public String getUserId(String userName){

    }


}
