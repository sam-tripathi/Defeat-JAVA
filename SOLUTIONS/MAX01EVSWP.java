package codechef_lib;

import java.util.Scanner;

public class MAX01EVSWP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			String s = sc.next();
			char s_arr[] = s.toCharArray();
			int count=0;
			for(int j=0;j<s_arr.length-1;j++) {//10010//1010010
				if(s_arr[j]=='0') {
					if((j+1)%2==0) {//zero at eve position
						for(int k=0;k<s_arr.length;k+=2) {//looking for 1 at odd pos
							if(s_arr[k]=='1') {
								
								s_arr[k]='A';s_arr[j]='A';
								count++;System.out.println("v1");
							}
						}
					}else {
						for(int k=1;k<s_arr.length;k+=2) {//looking for 1 at odd pos
							if(s_arr[k]=='1') {
								s_arr[k]='A';s_arr[j]='A';
								count++;System.out.println("v2");
							}
						}
					}
				}
			}
			System.out.println(count);
			
		}

	}
	
}
