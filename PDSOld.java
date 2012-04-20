import java.io.InputStreamReader;

import java.io.IOException;

import java.util.Arrays;

import java.io.BufferedReader;

import java.io.OutputStream;

import java.io.PrintWriter;

import java.util.StringTokenizer;

import java.math.BigInteger;

import java.io.InputStream;

 

 

class PDSOld

{

        public static void main(String[] Args)

        {

                InputStream inputStream = System.in;

                OutputStream outputStream = System.out;

                InputReader in = new InputReader(inputStream);

                PrintWriter out = new PrintWriter(outputStream);

                ChefPDSOld solver = new ChefPDSOld();

                solver.solve(1, in, out);

                out.close();

        }

}

 

class ChefPDSOld 

{

	public void solve(int testNumber, InputReader in, PrintWriter out)

	{

		int input[]=new int[10001];

		int inlen=0;

		for(int i=0;i<10000;i++)

		{

			int temp=in.nextInt();

			input[i]=temp;

			inlen++;

			if(temp==0)

			{

				i=10000;

			}

		}

		int tempind[]=new int[inlen];

		for(int i=0;i<inlen;i++)

		{

			tempind[i]=input[i];

		}

		Arrays.sort(tempind);

		inlen=1;

		for(int i=1;i<tempind.length;i++)

		{

			if(tempind[i-1]!=tempind[i])

			{

				inlen++;

			}

		}

		System.out.println("Length is: "+inlen);

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

		preprocess(ind,ans);

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

	public void preprocess(int ind[],long ans[])

	{
		int ifc=0;
		int elc=0;
		long t1=System.currentTimeMillis();
		int index=1;

		int counter=0;

		long num=1;
		int lastsum=0;
		int lastprod=0;
		int last=0;

		while(counter<1000000001)

		{

			int checker=0;

			int sum=0;

			int prod=1;
			//last=0;

			long n=num;
			//System.out.println((num-1)+" "+lastsum+" "+lastprod);
			if(((lastsum!=0)&&(last!=0)))
			{
				ifc++;
				sum=lastsum+1;
				prod=(lastprod/last)*((last+1)%10);
				if(prod%sum==0)
				{
					counter++;
					//System.out.println(counter+" "+num);

					if(index<ind.length&&ind[index]==counter)

					{

						ans[index]=num;

						index++;

					}
				}
			}

			else
			{
				n=num;
				elc++;
				sum=0;

				prod=1;

				while(n!=0)
	
				{

					int rem=(int)n%10;

					prod*=rem;
	
					sum+=rem;

					n/=10;

				}
				if(prod%sum==0)
				{
					counter++;
					//System.out.println(counter+" "+num);

					if(index<ind.length&&ind[index]==counter)

					{

						ans[index]=num;

						index++;

					}
				}
			}

			num++;
			last++;
			last%=10;
			lastsum=sum;
			lastprod=prod;

		}
		long t2=System.currentTimeMillis();
		System.out.println("Time: "+(t2-t1));
		System.out.println("If: "+ifc+" Else: "+elc);

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
	public int getS(long n)
	{
		int sum=0;
		while(n!=0)
		{
			sum+=n%10;
			n/=10;
		}
		return sum;
	}
	public int getM(long n)
	{
		int pro=1;
		while(n!=0)
		{
			pro*=n%10;
			n/=10;
		}
		return pro;
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
