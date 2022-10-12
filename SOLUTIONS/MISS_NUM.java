package codechef_lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MISS_NUM {
	public static ArrayList<Integer> arr = new ArrayList<>(4);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int res1 = -1;
			int res2 = -1;
			for(int j =0;j<4;j++) {
				arr.add(sc.nextInt());
			}
			Collections.sort(arr);
			for(int j=3;j>=0;j--) {
				for(int k=j;k>=0;k--) {
					int a = (arr.get(j)+arr.get(k))/2;
					int b = (arr.get(j)-arr.get(k))/2;
					int flag=0;
					if(a>0&&b>0&&a<=1e4&&b<=1e4) {
						int mul = a*b;
						int div = a/b;
						for(int l=0;l<4;l++) {
							if(l==k || l==j) {
								continue;
							}
							if(arr.get(l)==mul) {
								flag++;
							}else if(arr.get(l)==div) {
								flag++;
							}
						}
						if(flag==2) {
							res1=a;
							res2=b; 
						}
					}
					
				}
			}
			System.out.println(res1+" "+res2);
		}

	}

	

}
//Accepted