import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class B110 {
        public static void main(String[] Args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                CodeB110 solver = new CodeB110();
                solver.solve(1, in, out);
                out.close();
        }
}

class CodeB110
{
public void solve(int testNumber, InputReader in, PrintWriter out)
{

int n=in.nextInt();
int red[]=new int[n];
for(int i=0;i<n;i++)
{
	red[i]=in.nextInt();
}
Arrays.sort(red);
int nr=(n+1)/2;
int f=n-1;
double ar=0;
for(int i=0;i<nr;i++)
{
	if((f-1)!=-1)
	{
			ar+=(red[f]*red[f])-((red[f-1])*(red[f-1]));
	}
	else
	{
			ar+=red[f]*red[f];
	}
	f-=2;
}
ar*=3.141592653589793;
out.println(ar);


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
