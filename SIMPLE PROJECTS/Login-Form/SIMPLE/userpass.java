
import java.util.Scanner;

public class userpass {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String user, pass;
            System.out.print("Enter your username: ");
            user = input.nextLine();

            System.out.print("Enter your password: ");
            pass = input.nextLine();

            if (user.equals("Elsa") && (pass.equals("snow"))) {
                System.out.println("Welcome Elsa.");

            } else {
                System.out.println("Incorrect username or pass");
            }
        }
    }
}
