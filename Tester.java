import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class Tester
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                MyTester solver = new MyTester();
                solver.solve(1, in, out);
                out.close();
        }
}

class MyTester
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		long num=0;
		int dum=0;
		long t1=System.currentTimeMillis();
		//int store[]=new int[1000000];
		for(int i=0;i<1;i++)
		{
			for(int j=0;j<1000000000;j++)
			{
				if(j%2==0)
				num++;
				/*num++;
				if(!check(num))
				{
					j--;
				}
				else
				{
					//out.println(num+" for "+(j+1));
				}*/
			}
		}
		long t2=System.currentTimeMillis();
		out.println(num);
		out.println("Time: "+(t2-t1));





	}
	public boolean check(long n)
	{
		int dum=0;
		int sum=0;
		int prod=1;
		while(n!=0)
		{
			dum+=2;
			dum++;
			dum+=2;
			int rem=(int)n%10;
			if(rem==0)
			{
				return true;
			}
			prod*=rem;
			sum+=rem;
			n/=10;
		}
		if((prod%sum)==0)
		{
			return true;
		}
		return false;
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
