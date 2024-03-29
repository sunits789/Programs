import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class Format
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                Petr solver = new Petr();
                solver.solve(1, in, out);
                out.close();
        }
}

class Petr 
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		





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
	public void printArray(double arr[],PrintWriter out)
	{
		for(int i=0;i<arr.length;i++)
		{
			out.println(arr[i]);
		}
	}
	public void printArray(String arr[],PrintWriter out)
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
    public double nextDouble()
    {
        return Double.parseDouble(next());
    }
    public void getArray(int arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=nextInt();
		}
	}
	public void getArray(double arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=nextDouble();
		}
	}
	public void getArray(String arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=next();
		}
	}
	public void getArray2D(String arr[][])
    {
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				arr[i][j]=next();
			}
		}
	}
	public void getArray2D(int arr[][])
    {
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				arr[i][j]=nextInt();
			}
		}
	}
	public void getArray2D(double arr[][])
    {
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				arr[i][j]=nextDouble();
			}
		}
	}
}
