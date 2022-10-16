package codechef_lib;

import java.util.Scanner;

public class GDOG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int k =sc.nextInt();
			int sum=0;
			for (int e=1;e<=k;e++) {
				if(sum<(n%e)) {
					sum = n%e;
				}
			}
			System.out.println(sum);
					
		}

	}

}
