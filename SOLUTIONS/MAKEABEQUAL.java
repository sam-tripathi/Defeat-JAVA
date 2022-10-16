package codechef_lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MAKEABEQUAL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases=sc.nextInt();
		while(cases--!=0) {
			int n = sc.nextInt();
			long a[] = new long[n];
			long b[] = new long[n];
			long cost=0;
			long suma=0;
			long sumb=0;
			for(int i=0;i<n;i++) {
				a[i]=sc.nextLong();
				suma+=a[i];
			}
			for(int i=0;i<n;i++) {
				b[i]=sc.nextLong();
				cost+=Math.abs(a[i]-b[i]);
				sumb+=b[i];
			}
			if(suma==sumb) {
				if(cost%2!=0) {
					System.out.println(-1);
				}else {
					System.out.println(cost/2);
				}
			}else {
				System.out.println(-1);
			}
			
		}

	}

}
//AC