package codechef_lib;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LAPTOPREC {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			HashSet<Integer> set = new HashSet<Integer>();
			for(int j=0;j<n;j++) {
				arr[j]=sc.nextInt();
				set.add(arr[j]);
			}
			HashMap<Integer,Integer> s = new HashMap<Integer,Integer>();
			for(Integer g:set) {
				int c=0;
				for(int e:arr) {
					if(e==g) {
						c++;
					}
				}
				s.put(g, c);
			}
			
			int ans=0;
			for(int r:s.values()) {
				if(r>=ans) {
					ans=r;
				}	
			}
			int c=0;
			for(int r:s.values()) {
				if(r==ans) {
					c++;
				}
			}
			int val=0;
			for(int y:set) {
				if(s.get(y)==ans) {
					val=y;
				}
			}
			
			if(c>1) {
				System.out.println("CONFUSED");
			}else {
				System.out.println(val);
			}
			
		}
	}

}
//Accepted