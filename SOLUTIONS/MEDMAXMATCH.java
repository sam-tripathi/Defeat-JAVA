package codechef_lib;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MEDMAXMATCH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int j=0;j<n;j++) {
				a[j]=sc.nextInt();
			}
			int b_sum=0;
			Integer b[] = new Integer[n];
			for(int j=0;j<n;j++) {
				b[j]=sc.nextInt();
				b_sum+=b[j];
			}
			int idx_avg = 0;			
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			
			Integer ans[] = new Integer[n];
			for(int j=0;j<n;j++) {
				if(j<n/2) {
					ans[j]=a[j]+b[j];
				}else {
					ans[j]=a[j]+b[n-1-j+n/2];
				}
			}
			Arrays.sort(ans);
			System.out.println(ans[n/2]);
		}

	}

}
//Ac