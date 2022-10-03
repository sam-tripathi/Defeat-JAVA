import java.util.Scanner;

public class prog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = null;
        int n,len;
        System.out.print("Enter length of array : ");
        len = sc.nextInt();
        System.out.print("Enter value of enter into array : ");
        n = sc.nextInt();

        try {
            System.out.println("Length of String str is : " + str.length());
        }catch (NullPointerException e)
        {
            System.out.println("Exception is : "+e.toString());
        }
        try{
            int[] arr = new int [5];
            arr[len]=n;
        }catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Exception is : "+e.toString());
        }
        System.out.print("Enter num1 : ");
        int num1 = sc.nextInt();
        System.out.print("Enter num2 : ");
        int num2 = sc.nextInt();
        try{
            System.out.println("Division of two number is : "+num1/num2);
        }catch (ArithmeticException e)
        {
            System.out.println("Exception is : "+e.toString());
        }
        try {
            str = "abc";
            System.out.println(Integer.parseInt(str));
        }catch (NumberFormatException e)
        {
            System.out.println("Exception is : "+e.toString());
        }
        try {
            str = "abc";
            System.out.println(str.charAt(6));
        }catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("Exception is : "+e.toString());
        }
    }
}
