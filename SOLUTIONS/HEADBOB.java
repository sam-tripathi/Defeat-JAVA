package codechef_lib;

import java.util.Scanner;

public class HEADBOB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			String word = sc.next();
			String arr[] = word.split("");
			int val =0;//0 for not sure... 1 for indiann... 2 for not india
			for(String a:arr) {
				if(a.equals("N")) {
					continue;
				}else if(a.equals("I")) {
					val=1;System.out.println("INDIAN");
					break;
				}else if(a.equals("Y")) {
					val=2;System.out.println("NOT SURE");
					break;
				}
			}
			if(val==0) {
				System.out.println("NOT INDIAN");
			}
			
		}

	}

}
