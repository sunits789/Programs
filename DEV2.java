import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class DEV2
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                DSort solver = new DSort();
                solver.solve(1, in, out);
                out.close();
        }
}

class Bundle implements Comparable
{
	int trt;
	int sum;
	int l;
	double sorter;
	public Bundle(int t, int s, int len)
	{
		trt=t;
		sum=s;
		l=len;
		sorter= ((double)(((double)sum)/((double)((l*l)+l)))+(double)(((double)trt)/((double)(l+1))));
	}
	public int getTRT()
	{
		return trt;
	}
	public int getSum()
	{
		return sum;
	}
	public int getLen()
	{
		return l;
	}
	public void printBundle()
	{
		System.out.println(trt+" "+sum+" "+l+" "+sorter);
	}
	public int compareTo(Object obj)
	{
		Bundle temp= (Bundle) obj;
		if(this.sorter>temp.sorter)
		{
			return 1;
		}
		if(this.sorter<temp.sorter)
		{
			return -1;
		}
		return 0;
	}
}

class DSort
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		int n=in.nextInt();
		int store[][]=new int[n][50];
		int l[]=new int[n];
		int dsum[]=new int[n];
		for(int i=0;i<n;i++)
		{
			l[i]=in.nextInt();
			dsum[i]=0;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<l[i];j++)
			{
				store[i][j]=in.nextInt();
				dsum[i]+=store[i][j];
			}
		}
		int s[]=new int[n];
		for(int i=0;i<n;i++)
		{
			s[i]=0;
		}
		for(int i=0;i<n;i++)
		{
			s[i]=trt(store[i],l[i]);
		}
		Bundle bundle[]=new Bundle[n];
		for(int i=0;i<n;i++)
		{
			bundle[i]=new Bundle(s[i], dsum[i], l[i]);
		}
		Arrays.sort(bundle);
		int len=bundle[0].getLen();
		int ans=bundle[0].getTRT();
		bundle[0].printBundle();
		for(int i=1;i<n;i++)
		{
			bundle[i].printBundle();
			ans+=(len+1)*((len*bundle[i].getSum())+(bundle[i].getTRT()));
			len+=bundle[i].getLen();
		}
		out.println(ans);



	}
	
	
	public int trt(int ar[],int len)
	{
		int store[][] = new int[len][len];
		int arr[] = new int[len];
		for(int i=0;i<len;i++)
		{
		arr[i]=ar[i];
		}
		for(int i=0; i<len; i++)
		{
		for(int j=0; j<len; j++)
		{
		store[i][j]=-1;
		}
		}
		for(int i=0; i<len;i++)
		{
		int start = 0;
		int end = start+i;
		for(start=0,end=start+i;end<len;start++,end++)
		{
		int m=len-(end-start);
		if(start==end)
		{
		store[start][end]=m*arr[start];
		}
		else
		{
		int a = arr[start]*m+store[start+1][end];
		int b = arr[end]*m+store[start][end-1];
		store[start][end]=(a>b)?a:b;
		}
		}
		}
		return store[0][len-1];
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
