package codechef_lib;

import java.util.Arrays;
import java.util.Scanner;

public class LAPIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			String s = sc.next();
			char arr[] = s.toCharArray();
			if(arr.length%2==0) {//make for odd 
				char p1[] = new char[arr.length/2];
				char p2[] = new char[arr.length/2];
				for (int k=0;k<(arr.length/2);k++) {
					p1[k]=arr[k];
					p2[k]=arr[(arr.length/2)+k];
				}
				Arrays.sort(p1);
				Arrays.sort(p2);
				boolean isLapin = true;
				for (int k=0;k<(arr.length/2);k++) {
					if(p1[k]!=p2[k]) {
						isLapin = false;
						break;
					}
				}
				if(isLapin) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}else if(arr.length%2!=0) {
				char p1[] = new char[(arr.length-1)/2];
				char p2[] = new char[(arr.length-1)/2];
				for (int k=0;k<((arr.length-1)/2);k++) {
					p1[k]=arr[k];
					p2[k]=arr[((arr.length-1)/2)+k+1];
				}
				Arrays.sort(p1);
				Arrays.sort(p2);
				boolean isLapin = true;
				for (int k=0;k<((arr.length-1)/2);k++) {
					if(p1[k]!=p2[k]) {
						isLapin = false;
						break;
					}
				}
				if(isLapin) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}

	}

}

