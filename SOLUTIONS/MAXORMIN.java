package codechef_lib;

import java.util.ArrayList;
import java.util.Scanner;

public class MAXORMIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n =sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int j=0;j<n;j++) {
				arr.add(sc.nextInt());
			}
			int c_1=0; int c_0=0;
			for(Integer j:arr) {
				if(j==1) {
					c_1++;
				}else {
					c_0++;
				}
			}
			if(c_1==arr.size()) {
				System.out.println(1);
			}else if(c_0==arr.size()) {
				System.out.println(0);
			}else {
				if(c_1==1) {
					if(arr.size()>=3) {
						System.out.println(0);
					}else {
						System.out.println(1);
					}
				}else if(c_0==1) {
					System.out.println(1);
				}else {
					if(c_1<c_0) {
						System.out.println(0);
					}else if(c_1>c_0) {
						System.out.println(1);
					}else {
						System.out.println(1);
					}
				}
			}
		}

	}

}
//Accepted