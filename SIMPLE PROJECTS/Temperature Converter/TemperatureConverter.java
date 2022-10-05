import java.util.Scanner;

/**
 * TemperatureConverter
 */
public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.println("Welcome to the Temperature Converter");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Value");
            int val = sc.nextInt();
            System.out.println("Celsius to Fahrenheit (Enter 1)");
            System.out.println("Celsius to Kelvin (Enter 2)");
            System.out.println("Fahrenheit to Celsius (Enter 3)");
            System.out.println("Fahrenheit to Kelvin (Enter 4)");
            System.out.println("Kelvin to Celsius(Enter 5)");
            System.out.println("Kelvin to Fahrenheit (Enter 6)");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(val + " Celsius is :");
                    System.out.println(val * 9 / 5 + 32 + " Fahrenheit");
                    break;
                case 2:
                    System.out.print(val + " Celsius is :");
                    System.out.println(val + 273.15 + " Kelvin");
                    break;
                case 3:
                    System.out.println(val + " Fahrenheit is :");
                    System.out.println((val - 32) * 5 / 9 + " Celsius");
                    break;
                case 4:
                    System.out.println(val + " Fahrenheit is :");
                    System.out.println((val - 32) * 5 / 9 + 273.15 + " Kelvin");
                    break;
                case 5:
                    System.out.println(val + " Kelvin :");
                    System.out.println(val - 273.15 + " Celsius");
                    break;
                case 6:
                    System.out.println(val + " Kelvin is :");
                    System.out.println((val - 273 - 15) * 9 / 5 + 32 + " Fahrenheit");
                    break;
                default:
                    System.out.println(" Please enter the correct choice");
                    break;
            }
        }
    }
}