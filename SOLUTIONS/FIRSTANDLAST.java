package codechef_lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FIRSTANDLAST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			List<Integer> arr = new ArrayList<Integer>();
			for(int j=0;j<n;j++) {
				arr.add(sc.nextInt());
			}
			int max=0;
			for(int j=0;j<n;j++) {
				int sum=arr.get(0)+arr.get(n-1);
				if(sum>max) {
					max=sum;
				}
				int el=arr.remove(n-1);arr.add(0, el);
			}
			System.out.println(max);
		}

	}

}
//AC