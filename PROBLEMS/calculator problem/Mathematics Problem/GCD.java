class FAIZHACKTOBERFEST {
    // Greatest common divisor of x and y using recursive function
    static int GCD(int x, int y)
    {
        if (x == 0)
            return y;
        if (y == 0)
            return x;
  
        // Let's start the loop for Both the numbers are equal
        if (x == y)
            return x;
  
        // now let's write if x is greater
        if (x > y)
            return GCD(x - y, y);
        return GCD(x, y - x);
    }
  

    public static void main(String[] args)
    {
        int x = 100, y = 88;
        System.out.println("Greatest Common Divisor (GCD) of " + x + " and " + y
                           + " is " + GCD(x, y) );
    }
} 