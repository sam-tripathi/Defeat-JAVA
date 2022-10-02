import java.util.*;
public class Hash
{
	public static void main(String[] args) {
	    int[] arr=new int[]{1,1,1,2,2,3,3,3,3,4,5,5,6,6,6};
	    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	    for(int i=0;i<arr.length;i++)
	    {
	        if(hm.containsKey(arr[i]))
	        {
	            hm.put(arr[i],hm.get(arr[i])+1);
	        }
	        else
	        {
	            hm.put(arr[i],1);
	        }
	    }
	    for(Map.Entry<Integer,Integer> map: hm.entrySet())
	    {
	        System.out.println(map.getKey()+": "+map.getValue());
	    }
	}
}
Footer
