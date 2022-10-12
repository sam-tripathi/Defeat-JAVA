package codechef_lib;
import java.util.Scanner;
public class INTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int count =0;
		for(int i=1;i<=n;i++) {
			int ti = sc.nextInt();
			if(ti>=k && (ti%k==0)) {
				count++;
			}
		}
		System.out.println(count);

	}

}
