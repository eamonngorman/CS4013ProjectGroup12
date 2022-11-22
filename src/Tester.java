import java.time.LocalDateTime;

public class Tester {
    
    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after = now.plusMinutes(10);
        
        System.out.println(now.compareTo(after));
    }
}
