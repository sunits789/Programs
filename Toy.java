import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class Toy
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                InsomToy solver = new InsomToy();
                solver.solve(1, in, out);
                out.close();
        }
}

class InsomToy
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		int arr[]=new int[10000001];
		Arrays.fill(arr,0);
		for(int i=1;i<6;i++)
		{
			arr[i]=i;
		}
		preprocess(arr);
		int t=in.nextInt();
		for(int i=0;i<t;i++)
		{
			int q=in.nextInt();
			out.println(arr[q]);
		}





	}
	public void preprocess(int arr[])
	{
		for(int n=6;n<10000001;n++)
		{
			int i,a=n;
			for(i=2;i<a;i++)
			{
				if(n%i==0)
				{
					if(a>i+arr[(n/i)])
						a=i+arr[(n/i)];
				}
				else
				{
					if(a>i+arr[(n/i+1)])
					a=i+arr[(n/i+1)];
				}
			}
			arr[n]=a;
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
