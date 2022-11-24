import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tester {
    
    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after = now.plusMinutes(10);
        Order o = new Order();
        MenuItem m1 = new MenuItem("Cheese", 700);
        MenuItem m2 = new MenuItem("beans", 2.87);
        MenuItem m3 = new MenuItem("grease", 42);
        o.addToOrder(m1);
        o.addToOrder(m2);
        o.addToOrder(m3);
        System.out.println(o.toString());
        System.out.println(now);
    }
}
