package codechef_lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MAXTHEMIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int arr[] = new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=sc.nextInt();
			}
			Arrays.sort(arr);
			if(k>=n-1) {
				System.out.println(arr[n-1]);
			}else {
				System.out.println(arr[k]);
			}
		}

	}

}
//Accepted