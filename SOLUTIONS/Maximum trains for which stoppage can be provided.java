/*
This is description:-
We are given n-platform and two main running railway track for both direction. Trains which needs to stop at your station must occupy one platform for their stoppage and the trains which need not to stop at your station will run away through either of main track without stopping. Now, each train has three value first arrival time, second departure time and third required platform number. We are given m such trains you have to tell maximum number of train for which you can provide stoppage at your station.

Examples:

Input : n = 3, m = 6 
Train no.|  Arrival Time |Dept. Time | Platform No.
    1    |   10:00       |  10:30    |    1
    2    |   10:10       |  10:30    |    1
    3    |   10:00       |  10:20    |    2
    4    |   10:30       |  12:30    |    2
    5    |   12:00       |  12:30    |    3
    6    |   09:00       |  10:05    |    1
Output : Maximum Stopped Trains = 5
Explanation : If train no. 1 will left 
to go without stoppage then 2 and 6 can 
easily be accommodated on platform 1. 
And 3 and 4 on platform 2 and 5 on platform 3.


*/


import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
       
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
         Info in[]=new Info[m];
        for(int i=0;i<m;i++)
        {
            
            int a=sc.nextInt();
             int d=sc.nextInt();
              int p=sc.nextInt();
             // System.out.println(p);
              in[i]=new Info(a,d,p);
        }
        train(in,n,m);
        return;
	}
	public static void train(Info info[],int n,int m)
	{
	    int sb[]=new int[n];
	     
	    Arrays.sort(info,new Compare());
	    sb[info[0].pno-1]=info[0].dt;
	     
	    int count=1;
	    
	    for(int i=1;i<info.length;i++)
	    {
	        
	        if(info[i].pno==info[i-1].pno)
	        {
	           
	            if((info[i].at)>sb[info[i].pno-1])
	            {
	                sb[info[i].pno-1]=info[i].dt;
	                count++;
	                
	            }
	        }
	        else
	        {
	             //sb[info[i-1].pno-1]=info[i-1].dt;
	              sb[info[i].pno-1]=info[i].dt;
	              count++;
	              System.out.println("i="+i+" "+count);
	        }
	         
	        
	    }
	    System.out.println(count);
	}
	
}
class Info
{
    int at,dt,pno;
    Info(int a,int d,int p)
    {
        at=a;
        dt=d;
        pno=p;
    }
}
class Compare implements Comparator<Info>
{
    public int compare(Info a,Info b)
    {
        if(a.pno==b.pno)
        {
            return a.dt-b.dt;
        }
        else
        {
            return a.pno-b.pno;
        }
        
        
    }
}
