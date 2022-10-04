package codechef_lib;

import java.util.Scanner;

public class FLIPSORT {

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			String s = sc.next();
			char arr[] = s.toCharArray();
			boolean cont=false;
			int count=0;
			for(int j =1;j<n;j++) {
//				if(arr[j]==arr[j-1]) {
//					cont=true;
//				}
//				if(cont && arr[j]!=arr[j-1]) {
//					arr=flip(0,j-1,arr);
//					count++;
//					cont=false;
//				}else if(!cont && arr[j]!=arr[j-1]){
//					arr=flip(0,j-1,arr);
//					count++;
//				}
				
				if(arr[j]==arr[j-1]) {
					cont=true;
				}else {
					cont=false;
				}
				if(cont && )
			}
			//Printing
			for(char g:arr) {
				System.out.print(g+" ");
			}
			System.out.println();
			System.out.println(count);
			
		}


	}
	public static char[] flip(int st,int end,char arr[]) {
		for(int i=st;i<=end;i++) {
			if(arr[i]=='1') {
				arr[i]='0';
			}else {
				arr[i]='1';
			}
		}
		return arr;
	}

}
