package codechef_lib;

import java.util.Arrays;
import java.util.Scanner;

public class MEANMAX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int sum =0;
			int arr[] = new int[n];
			for (int k =0;k<n;k++) {
				arr[k] = sc.nextInt();
			}
			Arrays.sort(arr);
			int arr1[] = new int[arr.length/2];
			int arr2[] = new int[arr.length/2];
			for (int d=0;d<n/2;d++) {
				arr1[d] = arr[d];
			}
			for (int d=0;d<n/2;d++) {
				arr2[d] = arr[n-1-d];
			}
			int sum1=0;
			for(int g:arr1) {
				sum1+=g;
			}
			int sum2=0;
			for(int f:arr2) {
				sum2+=f;
			}
			System.out.println((sum1/(n/2))+(sum2/(n/2)));
		}

	}

}
