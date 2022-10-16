package codechef_lib;
import java.util.Scanner;
public class HS08TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double m = (double)sc.nextInt();
		double bal = sc.nextDouble();
		if (m%5 ==0) {	
			if(m+0.50 <=bal) {
				bal = bal - (m+0.50);
				System.out.println(bal);
			}else {
				System.out.println(bal);
			}
		}else {
			System.out.println(bal);
		}
	}

}
