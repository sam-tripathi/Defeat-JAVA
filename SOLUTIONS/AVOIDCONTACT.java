package codechef_lib;

import java.util.Scanner;

public class AVOIDCONTACT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int r = 0;
			if(y==x) {
				r+=y-1+x;
			}else if(x>y) {
				r+=2*y+(x-y);
			}
			System.out.println(r);
			
		}

	}

}
