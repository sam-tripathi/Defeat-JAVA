//This is a java program to print the matrix in the spiral form
public class Main
{
    public static void spiralPrint(int m,int n,int[][] arr)
    {
        int i,k=0,l=0;
        while(k<m && l<n)
        {
            // This loop is for moving the first row
            for(i=l;i<n;i++)
            {
                System.out.print(arr[k][i]+" ");
            }
            k++;
            //This loop is for moving  last column
             for(i=k;i<n;i++)
            {
                System.out.print(arr[i][n-1]+" ");
            }
            n--;
            if(k<m)//This loop  is for moving to the last row
            {
                 for(i=n-1;i>=l;i--)
            {
                System.out.print(arr[m-1][i]+" ");
            }
            m--; 
            }
            if(l<n)//This loop is for moving the first column
            {
                  for(i=m-1;i>=k;i--)
            {
                System.out.print(arr[i][l]+" ");
            }
            l++;
            }
            
        }
    }
	public static void main(String[] args) {
		int R = 4;
		int C = 4;
		//example data
		int a[][] = {{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}};

		//function call
		spiralPrint(R, C, a);
	}
}
