package codechef_lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MAKEPALAGAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {
			int n = sc.nextInt();
			String a = sc.next();
			int idx=0;
			HashMap<Character,ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
			for(char g: a.toCharArray()) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				if(map.containsKey(g)) {
					temp=(map.get(g));
				}
				temp.add(idx);
				map.put(g,temp);
				idx++;
			}
			if(n%2==0) {
				boolean flag=false;
				for(ArrayList<Integer> as:map.values()) {
					if(as.size()%2!=0) {
						System.out.println("NO");
						flag=true;
						break;
					}
				}
				if(!flag) {
					boolean f2=false;
					for(ArrayList<Integer> as:map.values()) {
						int cnt_e=0;int cnt_o=0;
						for(int e:as) {
							if(e%2==0) {
								cnt_e++;
							}else {
								cnt_o++;
							}
						}
						if(cnt_e!=cnt_o) {
							System.out.println("NO");
							f2=true;
							break;
						}
					}
					if(!f2) {
						System.out.println("YES");
					}
				}
			}else {//for odd
				int cnt=0;
				for(ArrayList<Integer> as:map.values()) {
					if(as.size()%2!=0) {
						cnt++;
					}
				}
				if(cnt!=1) {
					System.out.println("NO");
				}else {
					boolean f2=false;
					for(ArrayList<Integer> as:map.values()) {
						int cnt_e=0;int cnt_o=0;
						for(int e:as) {
							if(e%2==0) {
								cnt_e++;
							}else {
								cnt_o++;
							}
						}
						if(cnt_e!=cnt_o) {
							System.out.println("NO");
							f2=true;
							break;
						}
					}
					if(!f2) {
						System.out.println("YES");
					}
				}
			}
		}
		
	}

}
//Ac