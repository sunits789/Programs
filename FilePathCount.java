import java.io.*;
import java.util.*;
public class FilePathCount
{
	public static void main(String[] Args)throws FileNotFoundException
	{
		Formatter output=new Formatter("1o.txt");
		Scanner in=new Scanner(new File("1.txt"));
		//String s=in.next();
		//System.out.println(s);
		//s=in.next();
		//System.out.println(s);
		//System.exit(0);
		int t=in.nextInt();
		int q[][]=new int[2][t];
		for(int i=0;i<t;i++)
		{
			q[0][i]=in.nextInt();
			q[1][i]=in.nextInt();
		}
		long t1=System.currentTimeMillis();
		long arr[][]=new long[2000][2000];
		preprocess(arr);
		for(int i=0;i<t;i++)
		{
			output.format("%d\n",arr[q[0][i]][q[1][i]]);
		}
		long t2=System.currentTimeMillis();
		System.out.println("Time: "+(t2-t1));
		output.close();
	}
	
	public static void preprocess(long arr[][])
	{
		long mod=1000000007;
		Arrays.fill(arr[0],1);
		for(int i=0;i<2000;i++)
		{
			arr[i][0]=1;
		}
		for(int i=1;i<2000;i++)
		{
			for(int j=1;j<2000;j++)
			{
				arr[i][j]=(arr[i][j-1]+arr[i-1][j-1]+arr[i-1][j])%mod;
			}
		}
	}
}
