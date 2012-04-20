import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


class solution
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
		int n=in.nextInt();
		int m=in.nextInt();
		int arr[]=new int[n];
		int total=0;
		for(int i=0;i<n;i++)
		{
			arr[i]=in.nextInt();
			total+=arr[i];
		}
		int max=0;
		int tempsum=0;
		int tempsumnext=0;
		int counter=0;
		for(int i=0;i<m-1;i++)
		{
			//System.out.println("Looking for: "+i);
			//System.out.println("Counter is: "+counter);
			tempsum=0;
			tempsumnext=0;
			tempsum+=arr[counter];
			counter++;
			tempsumnext=tempsum+arr[counter];
			double min=0;
			min=abs((double)((double)tempsum-(double)((double)(total-tempsum)/(double)(m-i-1))));
			while((abs((double)((double)tempsumnext-(double)((double)(total-tempsumnext)/(double)(m-i-1))))<min)&&(counter<(n-(m-i-1))))
			{
				//System.out.println("Counter is: "+counter);
				//System.out.println("Min is: "+min);
				tempsum+=arr[counter];
				//System.out.println("Tempsum: "+tempsum+"Tempsumnext: "+tempsumnext);
				//System.out.println("Checking:  "+abs((double)((double)tempsumnext-(double)((double)(total-tempsumnext)/(double)(m-i-1))))+" "+abs((double)((double)tempsum-(double)((double)(total-tempsum)/(double)(m-i-1)))));
				counter++;
				tempsumnext=tempsum+arr[counter];
				min=abs((double)((double)tempsum-(double)((double)(total-tempsum)/(double)(m-i-1))));
				//System.out.println("In while it would be: "+abs(((double)((double)tempsumnext-(double)((double)(total-tempsumnext)/(double)(m-i-1))))/(m-i-1)));
			}
			if(max<tempsum)
			{
				max=tempsum;
			}
			//System.out.println(tempsum);
			total=total-tempsum;
		}
		//System.out.println(total);
		max=(total>max)?total:max;
		out.println(max);
		

	}
	
	
	public double abs(double d)
	{
		return (d>0)?d:(0-d);
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
