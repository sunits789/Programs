import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


class PalinCopy {
        public static void main(String[] args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
               // String s = "abcdefghijkl";
                //String st=s.substring(2, 8); System.out.println("st "+st);			//o
                //String str=st.substring(3);  System.out.println(str);      //o
                
                
                Palindrome solver = new Palindrome();
                solver.solve(1, in, out);
                out.close();
        }
}

class Palindrome
{
public void solve(int testNumber, InputReader in, PrintWriter out)
{
String s=in.next();
int l=s.length();
int arr[][]=new int[l][l];
boolean ispalin[][]=new boolean[l][l];
fillIsPalin(ispalin,s);
for(int i=0;i<l;i++)
{
arr[i][i]=1;
}
for(int i=1;i<l;i++)
{
for(int j=0;j<l-i;j++)
{
int a=arr[j][j+i-1];
// int b=arr[j+1][j+i];
int count=0;
//String st=s.substring(j,j+i+1);
for(int k=0;k<i+1;k++)
{
// String str=st.substring(0,k+2);
// if(isPalin(str))
{
// count++;
}
//String str=st.substring(k);
if(ispalin[j+k][j+i])
{
count++;
}
}
arr[j][j+i]=a+count;
}
}
for(int i=0;i<l;i++)
{
for(int j=i;j<l;j++)
{
out.print(arr[i][j]);
}
out.println();
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
public boolean isPalin(String s)
{
for(int i=0;i<(s.length()/2);i++)
{
if(s.charAt(i)!=s.charAt(s.length()-i-1))
{
return false;
}
}
return true;
}

}






class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    }
