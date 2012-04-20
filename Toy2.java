import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class Toy2
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                InsomToy2 solver = new InsomToy2();
                solver.solve(1, in, out);
                out.close();
        }
}

class InsomToy2
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		int d[]=new int[1000000];
		Arrays.fill(d,0);
		for(int i=1;i<6;i++)
		{
			d[i]=i;
		}
		int t=in.nextInt();
		for(int i=0;i<t;i++)
		{
			int q=in.nextInt();
			out.println(f(q,d));
		}





	}
	public int f(int n,int d[])
	{
		if(n<1000000)
		{
			if(d[n]!=0)
			{
				return d[n];
			}
		}
		int a=n;
		for(int i=2;i<a;i++)
		{
			if(n%i==0)
			{
				if(a>i+f(n/i,d))
				{
					a=i+f(n/i,d);
				}
			}
			else
			{
				if(a>i+f(n/i+1,d))
				{
					a=i+f(n/i+1,d);
				}
			}
			if(n<1000000)
			{
				d[n]=a;
			}
		}
     
		return a;
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
