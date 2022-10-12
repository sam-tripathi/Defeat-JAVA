package codechef_lib;

import java.util.Scanner;

public class INFERNO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n =sc.nextInt();int x = sc.nextInt();
			int arr[] = new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=sc.nextInt();
			}
			int c_1=0;
			int c_x=arr.length;
			for(int j:arr) {
				if(j>c_1) {
					c_1=j;
				}
				if(j>x) {
					int temp=((int)j/x-1);
					if(j%x==0) {
						c_x+=temp;
					}else {
						c_x+=temp+1;
					}
				}
			}
			System.out.println((int)Math.min(c_1, c_x));
			
			
			
		}

	}

}
//Accepted