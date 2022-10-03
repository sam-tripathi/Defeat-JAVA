package codechef_lib;

import java.util.Scanner;

public class FLOW016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			long a =sc.nextLong();
			long b =sc.nextLong();
			System.out.println(gcd(a,b)+" "+lcm(a,b));
			
		}
	}
	public static long lcm(long a,long b) {
		for(int i=1;;i++) {
			if((a*i)%b==0) {
				return a*i;
			}else {
				continue;
			}
		}
	}
	
	public static long gcd(long a,long b) {
		for(long i =Math.min(a, b);;i--) {
			if(((a%i)==0)&&((b%i)==0)) {
				return i;
			}else {
				continue;
			}
		}
	}

}
