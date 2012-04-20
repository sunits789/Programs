import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class Palin
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                InsomPalin solver = new InsomPalin();
                solver.solve(1, in, out);
                out.close();
        }
}

class InsomPalin
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		
		String s=in.next();
		int l=s.length();
		boolean ispalin[][]=new boolean[l][l];
		for(int i=0;i<l;i++)
		{
			Arrays.fill(ispalin[i],false);
		}
		fillIsPalin(ispalin,s);
		int prepalincounter[][]=new int[l][l];
		for(int i=0;i<l;i++)
		{
			Arrays.fill(prepalincounter[i],0);
		}
		fillPrePalinCounter(prepalincounter,ispalin,s);
		int dp[][]=new int[l][l];
		for(int i=0;i<l;i++)
		{
			Arrays.fill(dp[i],0);
		}
		fillDP(dp,prepalincounter,ispalin,s);
		int n=in.nextInt();
		for(int i=0;i<n;i++)
		{
			int ind1=in.nextInt();
			int ind2=in.nextInt();
			out.println(dp[ind1][ind2]);
		}




	}
	
	public void fillIsPalin(boolean ispalin[][], String s)
	{
		int l=s.length();
		for(int i=0;i<l;i++)
		{
			ispalin[i][i]=true;;
		}
		for(int i=0;i<l-1;i++)
		{
			if(s.charAt(i)==s.charAt(i+1))
			{
				ispalin[i][i+1]=true;
			}
		}
		for(int i=2;i<l;i++)
		{
			for(int j=0;j<l-i;j++)
			{
				if(s.charAt(j)==s.charAt(j+i))
				{
					ispalin[j][i+j]=ispalin[j+1][j+i-1];
				}
			}
		}
		//for(int i=0;i<l;i++)
		//{
		//	for(int j=i;j<l;j++)
		//	{
		//		System.out.print(ispalin[i][j]+" ");
		//	}
		//	System.out.println();
		//}
	}
	
	public void fillPrePalinCounter(int prepalincounter[][], boolean ispalin[][], String s)
	{
		int l=s.length();
		for(int i=0;i<l;i++)
		{
			prepalincounter[i][i]=1;
		}
		for(int i=l-1;i>=0;i--)
		{
			for(int j=1;j<=i;j++)
			{
				//System.out.println("Going to change "+ (i-j) +" "+i+" Influenced by "+ (i-j+1)+" "+i);
				//System.out.println("Value "+prepalincounter[i-j+1][i]);
				if(ispalin[i-j][i])
				{
					//System.out.println("Found palin");
					prepalincounter[i-j][i]=prepalincounter[i-j+1][i]+1;
				}
				else
				{
					prepalincounter[i-j][i]=prepalincounter[i-j+1][i];
				}
				//System.out.println("got value"+prepalincounter[i-j][i]);
			}
		}
		//for(int i=0;i<l;i++)
		//{
		//	for(int j=i;j<l;j++)
		//	{
		//		System.out.print(prepalincounter[i][j]+" ");
		//	}
		//	System.out.println();
		//}
	}
	
	public void fillDP(int dp[][],int prepalincounter[][], boolean ispalin[][], String s)
	{
		int l=s.length();
		for(int i=0;i<l;i++)
		{
			dp[i][i]=1;
		}
		for(int i=0;i<l-1;i++)
		{
			for(int j=i+1;j<l;j++)
			{
				dp[i][j]=dp[i][j-1]+prepalincounter[i][j];
			}
		}
		//for(int i=0;i<l;i++)
		//{
		//	for(int j=i;j<l;j++)
		//	{
		//		System.out.print(dp[i][j]+" ");
		//	}
		//	System.out.println();
		//}
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
