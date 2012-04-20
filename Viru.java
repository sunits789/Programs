import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class Viru
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                InsomViru solver = new InsomViru();
                solver.solve(1, in, out);
                out.close();
        }
}

class InsomViru
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		int t=0;
		int num=0;
        t=in.nextInt();
		while(t>0)
		{
			num=in.nextInt();
			if(num%2+(num/10)%2+(num/100)%2+(num/1000)%2==0)
			{
                out.println("Rupika");
                
			}    
        else
                out.println("Vihan");
        t--;
		}    
    //clock_t end=clock();
    //printf("\n%d\n",(end-start)/CLOCKS_PER_SEC);
            
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

