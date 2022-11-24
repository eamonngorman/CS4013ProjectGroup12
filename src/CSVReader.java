import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
            File file = new File("src/PersonDetails.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()){
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");

                if (username.equals(dataFields[2])){
                    if (password.equals(dataFields[3])){
                        signInSuccess = true;
                    }
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return signInSuccess;
    }

    public double[] readPaymentsFromCSV(RestaurantChain yum) {
        double[] array = new double[4];

        for (Double d: array){
            d = 0.00;
        }


        try {
            File file = new File("src/Orders.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()){
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");

                double payment = Double.parseDouble(dataFields[3]);
                int restaurantID = Integer.parseInt(dataFields[0]);
                array[restaurantID - 1] += payment;

            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return array;
    }

    public ArrayList<Double> readPaymentsFromCSV(LocalDate startDate, LocalDate endDate) {
        ArrayList<Double> payments = new ArrayList<Double>();

        try {
            File file = new File("src/Orders.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()) {
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");
                LocalDate csvDate = LocalDate.parse(dataFields[5]);
                if (csvDate.isAfter(startDate) && csvDate.isBefore(endDate)) {
                    Double payment = Double.parseDouble(dataFields[3]);
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
            File file = new File("src/Orders.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()){
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");
                LocalDate csvDate = LocalDate.parse(dataFields[5]);
                DayOfWeek weekDay = csvDate.getDayOfWeek();
                if (weekDay == day) {
                    Double payment = Double.parseDouble(dataFields[3]);
                    payments.add(payment);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return payments;
    }


    public boolean isUsernameTaken(String username) {
        boolean isTaken = false;
        try {
            File file = new File("src/PersonDetails.csv");

            Scanner input = new Scanner(file);
            if (input.hasNextLine()) {
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");

                if (username.equals(dataFields[2])){
                    isTaken = true;
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return isTaken;


    }

    public double readPayFor(Restaurant restaurant, DayOfWeek day, LocalTime startTime, LocalTime finishTime) {

        double total = 0;

        try {
            File orderFile = new File("src/Orders.csv");
            Scanner in = new Scanner(orderFile);
            if (in.hasNextLine()) {
                in.nextLine();
            }
            while (in.hasNextLine()) {
                String[] dataFields = in.nextLine().split(",");
                String dateString = dataFields[6];
                String restName = dataFields[8];
                String moneyString = dataFields[3];
                double money = Double.parseDouble(moneyString);
                LocalDateTime time = stringToTime(dateString);

                if(restaurant.getName().equals(restName)
                    && time.getDayOfWeek().equals(day)){
                    if(time.toLocalTime().isAfter(startTime) && 
                        time.toLocalTime().isBefore(finishTime)){
                            total += money;
                    }
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return total;

    }

    public LocalDateTime stringToTime(String stringTime){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime formattedDate = LocalDateTime.parse(stringTime, formatter);

        return formattedDate;
    }
}
