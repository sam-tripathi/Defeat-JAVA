package codechef_lib;

import java.util.Scanner;

public class EZSPEAK {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			char s[] = sc.next().toCharArray();
			boolean isVow=false;
			int cnt=0;//vow cnt
			boolean ans=true;
			int cnt_c=0;//const cnt
			for(char e:s) {
				if(e=='a') {
					cnt++;cnt_c=0;
					isVow=true;
				}else if(e=='e') {
					cnt++;cnt_c=0;
					isVow=true;
				}else if(e=='i') {
					cnt++;cnt_c=0;
					isVow=true;
				}else if(e=='o') {
					cnt++;cnt_c=0;
					isVow=true;
				}else if(e=='u') {
					cnt++;
					cnt_c=0;
					isVow=true;
				}else {
					isVow=false;
					cnt=0;
					cnt_c++;
					if(cnt_c>=4) {
						System.out.println("NO");
						ans=false;
						break;
					}
				}
			}
			if(ans) {
				System.out.println("YES");
			}
			
			
		}

	}
}
//AC