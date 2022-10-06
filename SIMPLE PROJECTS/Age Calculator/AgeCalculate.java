import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * AgeCalculate
 */
public class AgeCalculate {
  public static void main(String[] args) {
    LocalDate cr =LocalDate.now();
    System.out.println(cr);
    try (Scanner ip = new Scanner(System.in)) {
         System.out.println("Enter your Year Month and Date");
         int y=ip.nextInt();
         int m=ip.nextInt();
         int d=ip.nextInt();

         LocalDate db=LocalDate.of(y, m, d);
         int ageinyears=Period.between(cr, db).getYears();
         System.out.println("Your age is = " + Math.abs(ageinyears));
    }
    
  }
}