package codechef_lib;

import java.util.Scanner;

public class LASTLEVELS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int x =sc.nextInt();
			int y=sc.nextInt();
			int z=sc.nextInt();
			if(x%3==0) {
				System.out.println(x*y+z*(x/3-1));
			}else {
				System.out.println(x*y+z*(x/3));
			}
		}

	}

}
//Ac