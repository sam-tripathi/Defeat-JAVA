package codechef_lib;

import java.util.Scanner;

public class INTRDSGN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int x_1=sc.nextInt();
			int y_1=sc.nextInt();
			int x_2=sc.nextInt();
			int y_2=sc.nextInt();
			System.out.println(Math.min(x_1+y_1, x_2+y_2));
		}

	}

}
//Ac