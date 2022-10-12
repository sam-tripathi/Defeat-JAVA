package codechef_lib;
import java.util.Arrays;
import java.util.Scanner;
public class MINFD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i =1;i<=num;i++) {
			int n =sc.nextInt();
			int x = sc.nextInt();
			int arr [] = new int[n];
			for (int j =0;j<n;j++) {
				int ai = sc.nextInt();
				arr[j] = ai;
			}
			Arrays.sort(arr);
			int current_val = 0;
			int count =0;
			if(x>current_val) {
				for (int k =n-1;k>=0;k--) {
					if(current_val<x) {
						current_val = current_val +arr[k];
						count++;
					}else if(current_val>=x) {
						break;
					}
				}
				if(current_val<x) {
					System.out.println("-1");
				}
			}
			if(current_val>=x) {
				System.out.println(count);
			}
		}

	}

}
