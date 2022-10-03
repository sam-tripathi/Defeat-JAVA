package codechef_lib;

import java.util.Scanner;

public class FLOW005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int money = sc.nextInt();
			int c =0;
			while(money!=0) {
				if(note_val(money)<=money) {
					money = money-note_val(money);c++;
				}
			}
			System.out.println(c);
		}

	}
	public static int note_val(int money) {
		if(money>=100) {
			return 100;
		}else if(money<100 && money>=50) {
			return 50;
		}else if(money<50 && money>=10) {
			return 10;
		}else if(money<10 && money>=5) {
			return 5;
		}else if(money<5 && money>=2) {
			return 2;
		}else {
			return 1;
		}
	}

}
