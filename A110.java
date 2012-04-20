
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class A110 {
        public static void main(String[] Args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                CodeA110 solver = new CodeA110();
                solver.solve(1, in, out);
                out.close();
        }
}

class CodeA110
{
public void solve(int testNumber, InputReader in, PrintWriter out)
{

int n=in.nextInt();
int sumr[]=new int[n];
int sumc[]=new int[n];
Arrays.fill(sumr,0);
Arrays.fill(sumc,0);
for(int i=0;i<n;i++)
{
		for(int j=0;j<n;j++)
		{
				int temp=in.nextInt();
				sumr[i]+=temp;
				sumc[j]+=temp;
		}
}
int count=0;
for(int i=0;i<n;i++)
{
		for(int j=0;j<n;j++)
		{
			if(sumc[i]>sumr[j])
			{
				count++;
			}
		}
}

out.println(count);

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
