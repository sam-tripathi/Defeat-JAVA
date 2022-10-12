package codechef_lib;

import java.util.Scanner;

public class MINFLIPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			int c_p=0;
			int c_n=0;
			for(int j=0;j<n;j++) {
				arr[j]=sc.nextInt();
				if(arr[j]<0) {
					c_n++;
				}else {
					c_p++;
				}
			}
			if(n%2!=0) {
				System.out.println(-1);
			}else {
				System.out.println((int)Math.abs(c_n-c_p)/2);
			}
		}

	}

}
//AC