import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class PDS
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                ChefPDS solver = new ChefPDS();
                solver.solve(1, in, out);
                out.close();
        }
}

class ChefPDS 
{
	long r0=1;
	long r1=10;
	long r2=100;
	long r3=1000;
	long r4=10000;
	long r5=100000;
	long r6=1000000;
	long r7=10000000;
	long r8=100000000;
	long r9=1000000000;
	long r10=r1*r9;
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		int input[]=new int[100001];
		int max=0;
		int inlen=0;
		//input[2000]=0;
		for(int i=0;i<100000;i++)
		{
			//int temp=(i+2)/2;
			int temp=in.nextInt();
			input[i]=temp;
			inlen++;
			max=temp>max?temp:max;
			if(temp==0)
			{
				i=100000;
			}
		}
		int tempind[]=new int[inlen];
		for(int i=0;i<inlen;i++)
		{
			tempind[i]=input[i];
		}
		Arrays.sort(tempind);
		//int myarr[]=new int[200];
		//myarr[0]=0;
		//for(int i=1;i<200;i++)
		//{
		//	myarr[i]=(i/2)+1;
		//}
		inlen=1;
		for(int i=1;i<tempind.length;i++)
		{
			if(tempind[i-1]!=tempind[i])
			{
				inlen++;
			}
		}
		//System.out.println("Length is: "+inlen);
		int ind[]=new int[inlen];
		int temp=1;
		ind[0]=tempind[0];
		for(int i=1;i<tempind.length;i++)
		{
			if(tempind[i-1]!=tempind[i])
			{
				ind[temp]=tempind[i];
				temp++;
			}
		}
		long ans[]=new long[inlen];
		Arrays.fill(ans,0);
		//int myarr[]=new int[200];
		preprocess(ind,ans,max);
		temp=0;
		while(input[temp]!=0)
		{
			int index=0;
			int q=input[temp];
			index=Arrays.binarySearch(ind,q);
			out.println(ans[index]);
			temp++;
		}
		





	}
	public void preprocess(int ind[],long ans[],int max)
	{
		long time1=System.currentTimeMillis();
		int index=1;
		int counter=0;
		long num=1;
		long nextnum=num+1;
		int nextcounter=0;
		int wc=0;
		while(counter<(max+1))
		{
			//System.out.println("counter: "+counter);
			wc++;
			int f=0;
			int checker=0;
			int sum=0;
			int prod=1;
			long n=num;
			int count=0;
			nextnum=num+1;
			if(false)
			{
			}
			else
			{
				while(n!=0)
				{
					int rem=(int)n%10;
					if(rem==0)
					{
						//counter++;
						checker=1;
						nextnum=n*power(count)+power(count);
						n=0;
						nextcounter=counter+(int)(nextnum-num);
						//System.out.println("num: "+num+" nextnum: "+nextnum+" counter: "+counter+" nextcounter: "+nextcounter);
						for(int g=index;g<ind.length&&ind[g]<=nextcounter;g++,index++)
						{
							ans[g]=num+(ind[g]-counter-1);
						}
						f=1;
					}
					else
					{
						prod*=rem;
						sum+=rem;
						n/=10;
						count++;
					}
				}
			}
			if((checker!=1)&&(prod%sum)==0)
			{
				checker=1;
			}
			if((checker==1)&&(f!=1))
			{
				counter++;
				nextcounter=counter;
				if(index<ind.length&&ind[index]==counter)
				{
					//System.out.println(num);
					ans[index]=num;
					index++;
				}
			}
			num=nextnum;
			counter=nextcounter;
		}
		long time2=System.currentTimeMillis();
		System.out.println("time: "+(time2-time1));
		//System.out.println("loop count: "+wc);
	}
	public boolean check(long n)
	{
		int sum=0;
		int prod=1;
		while(n!=0)
		{
			int rem=(int)n%10;
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
	public long power(int n)
	{
		
		switch(n)
		{
			case 0 : return r0;
			case 1 : return r1;
			case 2 : return r2;
			case 3 : return r3;
			case 4 : return r4;
			case 5 : return r5;
			case 6 : return r6;
			case 7 : return r7;
			case 8 : return r8;
			case 9 : return r9;
			default : return r10;
		}
		//long ret=1;
		//long m=10;
		//for(int i=0;i<n;i++)
		//{
			//ret=ret*m;
		//}
		//return ret;
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
