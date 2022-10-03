// This program is used to find the frequency of the number of elements present in the given array
import java.util.*;
public class Hash
{
	public static void main(String[] args) {
	    int[] arr=new int[]{1,1,1,2,2,3,3,3,3,4,5,5,6,6,6}; //example data
	    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>(); // Creating a HashMap with key and value both of its type as Integer
	    for(int i=0;i<arr.length;i++) // The looping for elements in the array
	    {
	        if(hm.containsKey(arr[i])) // containsKey checks if the element of the array is already present
	        {
	            hm.put(arr[i],hm.get(arr[i])+1); // It increments the frequecy of that elements since we found the duplicate
	        }
	        else
	        {
	            hm.put(arr[i],1); // If it is a new element it ferequency is 1
	        }
	    }
	    for(Map.Entry<Integer,Integer> map: hm.entrySet()) // converting the hashmap to the set for accessing the key and value and looping it
	    {
	        System.out.println(map.getKey()+": "+map.getValue()); //.getKey() gives the key value and .getValue() gives the value associated with it 
	    }
	}
}
Footer
