import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class C110{
        public static void main(String[] Args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                CodeC110 solver = new CodeC110();
                solver.solve(1, in, out);
                out.close();
        }
}

class CodeC110
{
public void solve(int testNumber, InputReader in, PrintWriter out)
{

String s=in.next();
String sub=in.next();
int n=s.length()+sub.length();
char arr[][]=new char[2][n];
int max=0;
for(int st=0;st<n;st++)
{
Arrays.fill(arr[1],'A');
Arrays.fill(arr[0],'B');
for(int i=0;i<st;i++)
{
	//arr[0][i]='A';
}
int k=0;
for(int i=st;i<n&&k<s.length();i++)
{
		arr[0][i]=s.charAt(k);
		k++;
}
k=0;
for(int i=n-sub.length();i<n;i++)
{
	arr[1][i]=sub.charAt(k);
	k++;
}
for(int i=0;i<n;i++)
{
//	out.print(arr[0][i]);
}
//out.println();
for(int i=0;i<n;i++)
{
//	out.print(arr[1][i]);
}
//out.println("\n");
int count=0;
for(int i=0;i<n;i++)
{
	if(arr[0][i]==arr[1][i])
	{
		count++;
	}
}
if(count>max)
{
	max=count;
	//out.println(count);
}

}
out.println(sub.length()-max);
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
