package hacktoberfest_22;

public class ExceptionHandling {
    /*
    When executing Java code, different errors can occur: coding errors made by the programmer,
    errors due to wrong input, or other unforeseeable things. To prevent these from happening we can use Exception handling.

    The Exception Handling in Java is a mechanism using which the normal flow of the application is maintained.
    To do this, we employ a powerful mechanism to handle runtime errors or exceptions in a program.

    **Benefits Of Exception Handling**
    The major benefit of Exception handling is that it maintains the normal flow of the application despite the
    occurrence of an exception. When an exception occurs, the program usually terminates abruptly.Having an exception handler
    in a program will not cause the program to terminate abruptly. Instead, an exception handler makes sure that all
    the statements in the program are executed normally and the program flow does’t break abruptly.
     */

    public static void main(String[] args) {

        /*
        **Try and Catch**
        The try statement allows you to define a block of code to be tested for errors while it is being executed.
        The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
        */
        int x = 5, y = 0;
        try{
            int a = x/y; // Here we are trying to divide by 0 so we get error
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Finally block runs no matter we get a error or not");
        }


        //We can have multiple catch blocks as well
        int a[] = new int[]{1,2,3};
        try{
            System.out.println(a[5]);
        }catch (ArithmeticException e){
            System.out.println("Arithmetic Exception");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("index does not exist");
        }catch (Exception e){
            System.out.println("Some error occurred"); // if error is neither indexoutOfBound nor Arithmetic.
        }

        /*
        **Throws Keyword**
         Throws are used to give information that this method throws this particular exception.
        When you call that particular method, you need to handle that exception.
         */

        public class DemoThrows {
            int i=2,j=0;
            public void checkmethod () throws ArithmeticException{
                System.out.println(i/j);
            }

            public static void main(String[]
                                            args) {

                DemoThrows d =new DemoThrows();

                try {
                    d.checkmethod();
                }
                catch (ArithmeticException e) {

                    e.printStackTrace();
                }

            }
        }

    }

}
