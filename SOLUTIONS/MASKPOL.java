package codechef_lib;

import java.util.Scanner;

public class MASKPOL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int diff = n-a;
			if(diff>=a) {
				System.out.println(a);
			}else if(diff<a) {
				System.out.println(diff);
			}
		}

	}

}
