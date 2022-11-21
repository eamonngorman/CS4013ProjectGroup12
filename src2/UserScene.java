import java.util.ArrayList;
import java.util.Scanner;

public class UserScene {

    private Scanner in;
    private Person user;

    public UserScene() {
        in = new Scanner(System.in);
    }

    public void run();

    {
        boolean more = true;

        while (more) {
            System.out.println();
        }
    }

    private Object getChoice(ArrayList<Object> choices) {
        if (choices.size() == 0)
            return null;
        while (true) {
            char c = 'A';
            for (Object choice : choices) {
                System.out.println("\n" + c + ") \n" + choice.toString() + "\n");
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.size())
                return choices.get(n);
        }
    }
}
