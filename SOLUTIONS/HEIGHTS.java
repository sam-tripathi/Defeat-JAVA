package codechef_lib;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class HEIGHTS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			for(int j=0;j<n;j++) {
				int val=sc.nextInt();
				map.put(val, map.getOrDefault(val, 0)+1);
			}
			int max_f=Collections.max(map.values());
			int ht=Collections.max(map.keySet());
			
			int ans = 0 ;  
		    int temp = -1;
		    for(int j:map.keySet()){
		         if(map.get(j)==1){
		            temp=j;
		            ans++;
		         }
		    }
		    
		    if(ans==1 && temp==ht){
		         if(max_f==2)
		           System.out.println(2);
		         else
		         System.out.println(1);
		    }
		    else
		    System.out.println((ans+1)/2);
			
		}

	}

}
//AC