import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class Play
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                ChefPlay solver = new ChefPlay();
                solver.solve(1, in, out);
                out.close();
        }
}

class ChefPlay
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		int t=in.nextInt();
		for(int i=0;i<t;i++)
		{
			int l=in.nextInt();
			int arr[]=new int[l];
			for(int j=0;j<l;j++)
			{
				arr[j]=in.nextInt();
			}
			int max[]=new int[l];
			Arrays.fill(max,0);
			max[l-1]=arr[l-1];
			for(int j=l-2;j>=0;j--)
			{
				if(arr[j]>max[j+1])
				{
					max[j]=arr[j];
				}
				else
				{
					max[j]=max[j+1];
				}
			}
			int ans=0;
			for(int j=0;j<l;j++)
			{
				if((max[j]-arr[j])>ans)
				{
					ans=max[j]-arr[j];
				}
			}
			if(ans==0)
			{
				out.println("UNFIT");
			}
			else
			{
				out.println(ans);
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
}
