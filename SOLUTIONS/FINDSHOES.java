package codechef_lib;

import java.util.Scanner;

public class FINDSHOES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n>=m) {
				System.out.println(2*n-m);
			}else {
				System.out.println(n);
			}
			
		}

	}

}
//Accepted