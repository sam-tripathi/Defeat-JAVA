package codechef_lib;
import java.util.Scanner;
public class FLOW007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			int n_rev =0;
			while(n!=0) {
				n_rev = n_rev + n%10;
				n_rev = n_rev*10;
				n=n/10;
			}
			System.out.println(n_rev/10);
		}

	}

}
