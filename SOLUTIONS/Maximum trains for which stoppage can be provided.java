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
