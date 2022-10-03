package codechef_lib;

import java.util.Scanner;

public class FLOW010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			String a = sc.next();
			if(a.equals("b")||a.equals("B")) {
				System.out.println("BattleShip");
			}else if(a.equals("c")||a.equals("C")) {
				System.out.println("Cruiser");
			}else if(a.equals("d")||a.equals("D")) {
				System.out.println("Destroyer");
			}else if(a.equals("f")||a.equals("F")) {
				System.out.println("Frigate");
			}
		}

	}

}
