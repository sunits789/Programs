import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;

class Swap
{
        public static void main(String[] Args)
        {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                ChefSwap solver = new ChefSwap();
                solver.solve(1, in, out);
                out.close();
        }
}

class ChefSwap
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		int t=in.nextInt();
		for(int i=0;i<t;i++)
		{
			int l=in.nextInt();
			int arr[]=new int[l];
			in.getArray(arr);
			if(l==1)
			{
				printArray(arr,out);
			}
			else
			{
				int l1=l/2;
				int l2=l-l1;
				int arr1[]=new int[l1];
				int arr2[]=new int[l2];
				for(int j=0;j<l;j++)
				{
					if(j<l1)
					{
						arr1[j]=arr[j];
					}
					else
					{
						arr2[j-l1]=arr[j];
					}
				}
				//out.println();
				//printArray(arr1,out);
				//out.println();
				//printArray(arr2,out);
				int ans[]=merge(arr1,arr2);
				printArray(ans,out);
			}
		}
		





	}
	
	
	public int[] merge(int arr1[],int arr2[])
	{
		int l1=arr1.length;
		int l2=arr2.length;
		System.out.println("partition: ");
		for(int i=0;i<l1;i++)
		{
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for(int i=0;i<l2;i++)
		{
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		if(l1>1&&l2>1)
		{
			int l3=l1/2;
			int l4=l1-l3;
			int l5=l2/2;
			int l6=l2-l5;
			int arr3[]=new int[l3];
			int arr4[]=new int[l4];
			int arr5[]=new int[l5];
			int arr6[]=new int[l6];
			for(int i=0;i<l1;i++)
			{
				if(i<l3)
				{
					arr3[i]=arr1[i];
				}
				else
				{
					arr4[i-l3]=arr1[i];
				}
			}
			for(int i=0;i<l2;i++)
			{
				if(i<l5)
				{
					arr5[i]=arr2[i];
				}
				else
				{
					arr6[i-l5]=arr2[i];
				}
			}
			int ans1[]=merge(arr3,arr4);
			System.out.println("Recieved: ");
			for(int i=0;i<l1;i++)
			{
				System.out.print(ans1[i]+" ");
			}
			System.out.println();
			int ans2[]=merge(arr5,arr6);
			System.out.println("Recieved: ");
			for(int i=0;i<l2;i++)
			{
				System.out.print(ans2[i]+" ");
			}
			System.out.println();
			int index1=0;
			int index2=0;
			int ret[]=new int[(l1+l2)];
			for(int i=0;i<(l1+l2);i++)
			{
				if(index1>=l1)
				{
					ret[i]=ans2[index2];
					index2++;
				}
				else if((index2<l2)&&(ans1[index1]>(ans2[index2]+1)))
				{
					ret[i]=ans2[index2];
					index2++;
				}
				else
				{
					ret[i]=ans1[index1];
					index1++;
				}
			}
			return ret;
		}
		else if((l1+l2)==2)
		{
			int ret[]=new int[2];
			if(arr1[0]>(arr2[0]+1))
			{
				ret[0]=arr2[0];
				ret[1]=arr1[0];
			}
			else
			{
				ret[0]=arr1[0];
				ret[1]=arr2[0];
			}
			return ret;
		}
		else
		{
			if(l1==2)
			{
				if(arr1[0]>(arr1[1]+1))
				{
					int temp=arr2[0];
					arr2[0]=arr2[1];
					arr2[1]=temp;
				}
			}
			else
			{
				if(arr2[0]>(arr2[1]+1))
				{
					int temp=arr2[0];
					arr2[0]=arr2[1];
					arr2[1]=temp;
				}
			}
			int index1=0;
			int index2=0;
			int ret[]=new int[3];
			for(int i=0;i<3;i++)
			{
				if(index1>=l1)
				{
					ret[i]=arr2[index2];
					index2++;
				}
				else if((index2<l2)&&(arr1[index1]>(arr2[index2]+1)))
				{
					ret[i]=arr2[index2];
					index2++;
				}
				else
				{
					ret[i]=arr1[index1];
					index1++;
				}
			}
			return ret;
		}
	}
	
	public void printArray(int arr[],PrintWriter out)
	{
		for(int i=0;i<arr.length;i++)
		{
			out.print(arr[i]+" ");
		}
		out.println();
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
    public void getArray(int arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=nextInt();
		}
	}
	public void getArray(long arr[])
    {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=nextLong();
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
