package codechef_lib;

import java.util.Scanner;

public class KSUB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int cases=sc.nextInt();
		while(cases--!=0) {
			//For every Testcase
			int n=sc.nextInt();
			int k = sc.nextInt();
			
			//Arr
			int g=0;
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
				g=gcd(g,arr[i]);
			}
			int curr_g=0; int cnt=0;
			for(int i=0;i<n;i++) {
				curr_g=gcd(curr_g,arr[i]);
				if(curr_g==g) {
					cnt++;
					curr_g=0;
				}
				if(cnt==k) {
					break;
				}
			}
			if(cnt==k) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}

	}
	public static int gcd(int a,int b) {
		if(b==0) {
			return a;
		}else {
			return gcd(b,a%b);
		}
	}

}
//AC