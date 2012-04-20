import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class PathCount
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                InsomPathCount solver = new InsomPathCount();
                solver.solve(1, in, out);
                out.close();
        }
}

class InsomPathCount
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		int t=in.nextInt();
		int q[][]=new int[2][t];
		in.getArray(q);
		long t1=System.currentTimeMillis();
		long arr[][]=new long[2000][2000];
		preprocess(arr);
		for(int i=0;i<t;i++)
		{
			out.println(arr[q[0][i]][q[1][i]]);
		}
		long t2=System.currentTimeMillis();
		System.out.println("Time: "+(t2-t1));
	}
	public void preprocess(long arr[][])
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
	
	public void printArray(int arr[],PrintWriter out)
	{
		for(int i=0;i<arr.length;i++)
		{
			out.println(arr[i]);
		}
	}
	public void printArray(long arr[],PrintWriter out)
	{
		for(int i=0;i<arr.length;i++)
		{
			out.println(arr[i]);
		}
	}
	public void printArray(float arr[],PrintWriter out)
	{
		for(int i=0;i<arr.length;i++)
		{
			out.println(arr[i]);
		}
	}
}








class InputReader
{
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream)
    {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next()
    {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
        {
            try
            {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt()
    {
        return Integer.parseInt(next());
    }

    public long nextLong()
    {
        return Long.parseLong(next());
    }
    public void getArray(int arr[][])
    {
		for(int i=0;i<arr[0].length;i++)
		{
			arr[0][i]=nextInt();
			arr[1][i]=nextInt();
		}
	}
	public void getArray(long arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=nextLong();
		}
	}
	public void getArray(String arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=next();
		}
	}
}
