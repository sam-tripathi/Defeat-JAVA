// Bubble sort is a sorting algorithm that compares two adjacent elements and swaps them until they are in the intended order.

import java.util.Scanner;

public class bubbleSort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length : ");
        int n = sc.nextInt();
        System.out.println("Enter array elements: ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Before Sorting: ");  
        for(int i=0; i < n; i++){  
            System.out.print(arr[i] + " ");  
        }  
        //calling the function
        System.out.println();
        BubbleSort(arr, n);
        System.out.println("After Sorting: ");  
        for(int i=0; i < n; i++){  
            System.out.print(arr[i] + " ");  
        }  
    }
    //creating function
    static void BubbleSort(int[] arr, int n) {  
        
        int temp = 0;  
        //array is traversed from first element to last element.
        for(int i=0; i < n; i++){  
            for(int j=0; j < n-i-1; j++){  
                //Here, current element is compared with the next element
                if(arr[j] > arr[j+1]){  
                //If current element is greater than the next element, swap elements  
                temp = arr[j];  
                arr[j] = arr[j+1];  
                arr[j+1] = temp;  

                }  
                          
            }  
        }  
    }
}
