// A simple java program to compute the BMI of a user based on his height and weight.
// Switch case is used to compute the BMI of a user based on the unit system he inputs the data in.
import java.util.Scanner;

class BMI_Calculator {            // program starts
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // Scanner class to take input from the user
        double weight, height = 0.0; 
        double bmi = 0.0;
        System.out.println("--------------------------------------------------");
        System.out.println("----------------Body Mass Calculator--------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Choose your desired measurement system: ");
        System.out.println("1. Weight in kilograms and Height in meters");
        System.out.println("2. Weight in pounds and Height in inches");
        System.out.println("Enter you choice....");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:             // case to calculate BMI in Kilograms and Meter
                System.out.println("Enter your Weight in Kilograms (Kgs) : ");
                weight = sc.nextDouble();
                System.out.println("Enter your Height in meters (m) : ");
                height = sc.nextDouble();
                bmi = (weight / (height * height));   // formula to calculate BMI  in Kilograms and Meters.
                break;

            case 2:               // case to calculate BMI in Pounds and Inches
                System.out.println("Enter your Weight in Pounds (lbs) : ");
                weight = sc.nextDouble();
                System.out.println("Enter your Height in inches (in) : ");
                height = sc.nextDouble();
                bmi = 703 * (weight / (height * height));   // formula to calculate BMI in Pounds and Inches
                break;

            default:
                System.out.println("Oops! Wrong choice");
        }
        System.out.println("--------------------------------------------------");
        System.out.print("Your BMI according to your height and weight is : ");
        System.out.printf("%.2f%n", bmi);
        if(bmi<16){       // Further description about user's BMI
            System.out.println("You are Severely Underweight");
        }
        else if((16<=bmi)&&(bmi<=18.4)){
            System.out.println("You are Underweight");
        }
        else if((18.5<=bmi)&&(bmi<=24.9)){
            System.out.println("You are Normal");
        }
        else if((25<=bmi)&&(bmi<=29.9)){
            System.out.println("You are Overweight");
        }
        else if((30<=bmi)&&(bmi<=34.9)){
            System.out.println("You are Moderately Obese");
        }
        else if((35<=bmi)&&(bmi<=39.9)){
            System.out.println("You are Severely Obese");
        }
        else{
            System.out.println("You are Morbidly Obese");
        }
        System.out.println("--------------------------------------------------");   // program ends

    }
}


