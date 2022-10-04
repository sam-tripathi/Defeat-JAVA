// The selection sort algorithm sorts an array by repeatedly finding the minimum element 
//(considering ascending order) from the unsorted part and putting it at the beginning. 

import java.util.Scanner;

public class searchingSort {
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
        SearchingSort(arr, n);
        System.out.println("After Sorting: ");  
        for(int i=0; i < n; i++){  
            System.out.print(arr[i] + " ");  
        }  
        
    }
    //creating a function
    static void SearchingSort(int[] arr, int n){

        for (int i = 0; i < n; i++)  
        {  
            //set index to location 0
            int min_value = i;  
            for (int j = i + 1; j < n; j++){  
                if (arr[j] < arr[min_value]){  
                    min_value = j;//searching for lowest index  
                }  
            }  
            //increment the value and repeat it until sorted
            int smallNum = arr[min_value];   
            arr[min_value] = arr[i];  
            arr[i] = smallNum;  

    }
}
}
