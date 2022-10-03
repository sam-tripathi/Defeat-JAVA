package codechef_lib;

import java.util.Scanner;

public class FLOORS {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int fl_x=(x-1)/10+1;
			int fl_y=(y-1)/10+1;
			System.out.println(Math.abs(fl_x-fl_y));
		}
	}

}
//AC