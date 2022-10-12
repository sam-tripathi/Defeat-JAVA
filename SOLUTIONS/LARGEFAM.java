package codechef_lib;

import java.util.Arrays;
import java.util.Scanner;

public class LARGEFAM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=sc.nextInt();
			}
			int ans=0;
			int sum=0;
			Arrays.sort(arr);
			for(int e:arr) {
				sum+=e;
				if(sum<n) {
					ans++;
				}else {
					break;
				}
			}
			System.out.println(ans);
		}
		

	}

}
//AC