// This approach basically checks all possible subarrays, which means if the size of array is n then the time-complexity of this algorithm would be O(n²), thus taking huge time to execute.

// Initialize: local_max = 0 global_max = INT_MIN

// For each element we will follow these steps:

// if (a[i] <= local_max + a[i]) local_max = local_max + a[i]
// else local_max = a[i]
// global_max = max(global_max, local_max)
// global_max is the maximum sum required.

// Analysing the above approach, we can write a recursive formulation for Kadane's algorithm.

// local_max[i] = max( A[ i ], A[ i ] + local_max[ i-1 ] )

// resulting answer will be the maximum of all the values of local_max[i]

import java.util.*;
public class Kadane_Algo
{
    public static void main(String[] args) {
        int[] arr=new int[]{-2,1,-3,4,-1,2,1,-5,4}; //example data
        int max=arr[0]; //initializing the max value with the first element of the array
        int sum=0; //initializing the sum value with 0
        for(int i=0;i<arr.length;i++) // looping for the elements in the array
        {
            sum+=arr[i]; // adding the elements in the sum
            if(sum>max) // checking if the sum is greater than the max
            {
                max=sum; // if it is greater then we are assigning the sum to the max
            }
            if(sum<0) // checking if the sum is less than 0
            {
                sum=0; // if it is less than 0 then we are assigning 0 to the sum
            }
        }
        System.out.println(max); // printing the max value
    }
}
