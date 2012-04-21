import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class Triplet
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                CodeTriplet solver = new CodeTriplet();
                solver.solve(1, in, out);
                out.close();
        }
}

class CodeTriplet
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		int n=in.nextInt();
		double arr[][]=new double[n][2];
		in.getArray(arr);
		int c=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				for(int k=j+1;k<n;k++)
				{
					double x=0;
					double y=0;
					x=(arr[j][0]+arr[k][0])/2;
					y=(arr[j][1]+arr[k][1])/2;
					if(x==arr[i][0]&&y==arr[i][1])
					{
						c++;
						/*out.println(x+" "+y);
						out.println(arr[j][0]+" "+arr[j][1]);
						out.println(arr[k][0]+" "+arr[k][1]);
						out.println("Here");
						* */
					}
					x=0;
					y=0;
					x=(arr[i][0]+arr[k][0])/2;
					y=(arr[i][1]+arr[k][1])/2;
					if(x==arr[j][0]&&y==arr[j][1])
					{
						c++;
						/*
						out.println(x+" "+y);
						out.println(arr[i][0]+" "+arr[i][1]);
						out.println(arr[k][0]+" "+arr[k][1]);
						out.println("Here2");
						* */
					}
					x=0;
					y=0;
					x=(arr[j][0]+arr[i][0])/2;
					y=(arr[j][1]+arr[i][1])/2;
					if(x==arr[k][0]&&y==arr[k][1])
					{
						c++;
						/*
						out.println(x+" "+y);
						out.println(arr[i][0]+" "+arr[i][1]);
						out.println(arr[j][0]+" "+arr[j][1]);
						out.println("Here3");
						* */
					}
				}
			}
		}
		out.println(c);




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
    public double nextDouble()
    {
		return Double.parseDouble(next());
	}
    public void getArray(int arr[][])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i][0]=nextInt();
			arr[i][1]=nextInt();
		}
	}
	public void getArray(long arr[][])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i][0]=nextLong();			
			arr[i][1]=nextLong();			
		}
	}
	public void getArray(double arr[][])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i][0]=nextDouble();			
			arr[i][1]=nextDouble();			
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
