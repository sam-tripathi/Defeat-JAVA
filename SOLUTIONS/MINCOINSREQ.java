package codechef_lib;

import java.util.Scanner;

public class MINCOINSREQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int x = sc.nextInt();
			int ans=(x-x/10*10);
			System.out.println(ans);
		}

	}

}
//AC