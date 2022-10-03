package codechef_lib;

import java.util.Scanner;

public class FLOW014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			double h = sc.nextDouble();boolean h_t=false;
			double cc = sc.nextDouble();boolean cc_t = false;
			double ts = sc.nextDouble();boolean ts_t = false;
			if(h>50) {h_t=true;}
			if(cc<0.70) {cc_t=true;}
			if(ts>5600) {ts_t=true;}
			
			if(h_t && cc_t &&ts_t) {System.out.println("10");
			}else if(h_t&&cc_t) {System.out.println("9");
			}else if(ts_t&&cc_t) {System.out.println("8");
			}else if(h_t&&ts_t) {System.out.println("7");
			}else if(h_t||cc_t||ts_t) {System.out.println("6");
			}else if(!h_t&&!cc_t&&!ts_t) {System.out.println("9");}
			
		}

	}

}
