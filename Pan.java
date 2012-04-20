import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class Pan
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                ChefPan solver = new ChefPan();
                solver.solve(1, in, out);
                out.close();
        }
}

class ChefPan 
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		long dp[][]=new long[1000][1000];
		long ans[]=new long[1000];
		for(int i=0;i<1000;i++)
		{
			Arrays.fill(dp[i],0);
		}
		Arrays.fill(ans,0);
		preprocess(dp,ans);
		int t=in.nextInt();
		for(int i=0;i<t;i++)
		{
			int q=in.nextInt();
			out.println(ans[q-1]);
		}





	}
	public void preprocess(long dp[][],long ans[])
	{
		long m=1000000007;
		dp[0][0]=1;
		ans[0]=1;
		for(int i=1;i<1000;i++)
		{
			for(int j=0;j<1000;j++)
			{
				if(j==0)
				{
					dp[i][j]=1;
				}
				else
				{
					dp[i][j]=(dp[i-1][j-1]+(j+1)*dp[i-1][j])%m;
				}
				ans[i]+=dp[i][j];
				ans[i]%=m;
			}
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
    public void getArrayInt(int arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=nextInt();
		}
	}
	public void getArrayLong(long arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=nextLong();
		}
	}
	public void getArrayString(String arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=next();
		}
	}
}
