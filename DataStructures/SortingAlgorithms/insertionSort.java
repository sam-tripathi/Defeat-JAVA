//Insertion sort is a simple sorting algorithm that allows for efficient, in-place sorting of the array,
// one element at a time. By in-place sorting, we mean that the original array is modified and no temporary structures are needed.

import java.util.Scanner;

public class insertionSort {
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
        InsertionSort(arr, n);
        System.out.println("After Sorting: ");  
        for(int i=0; i < n; i++){  
            System.out.print(arr[i] + " ");  
        }
        
    }
    //creating a function
    static void InsertionSort(int[] arr, int n){

        //outer for loop to iterate over each element
        for(int i=0;i<n;++i){

            //check for ascending order of elements
            int j = i;
            
            //while loop condition
            while(j > 0 && arr[j-1]>arr[j]){
                
                //values are swapped if condition is true
              int key = arr[j];
              arr[j] = arr[j-1];
              arr[j-1] = key;
              j = j-1; 
                //this continues until while loop breaks
            }
          }

    }
    
}
