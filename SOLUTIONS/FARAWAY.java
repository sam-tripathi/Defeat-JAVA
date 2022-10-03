package codechef_lib;

import java.util.Scanner;

public class FARAWAY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases=sc.nextInt();
		while(cases--!=0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long dist=0;
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
				dist+=Math.max(Math.abs(arr[i]-m), Math.abs(arr[i]-1));
				
			}
			System.out.println(dist);
			
		}


	}

}
//AC