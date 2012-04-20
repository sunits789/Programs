import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


class SolnDollarEx {
        public static void main(String[] args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                Dollar solver = new Dollar();
                solver.solve(1, in, out);
                out.close();
        }
}

class Dollar
{
public void solve(int testNumber, InputReader in, PrintWriter out)
{
int n=in.nextInt();
int store[][]=new int[n][200];
long l[]=new long[n];
long dsum[]=new long[n];
for(int i=0;i<n;i++)
{
l[i]=in.nextLong();
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
int asize=((int)(Math.pow(2,n)));
long s[]=new long[n];

for(int i=0;i<n;i++)
{
s[i]=0;
}
for(int i=0;i<n;i++)
{
int abc=(int)l[i];
s[i]=(long)trt(store[i],abc);
}


double sorter[]=new double[n];
for(int i=0;i<n;i++)
{
sorter[i]=(double)(((double)dsum[i])/((double)l[i]));
}
for(int i=0;i<n;i++)
{
for(int j=i;j<n;j++)
{
if(sorter[i]>sorter[j])
{
double t=sorter[i];
sorter[i]=sorter[j];
sorter[j]=t;
long temp=s[i];
s[i]=s[j];
s[j]=temp;
temp=l[i];
l[i]=l[j];
l[j]=temp;
temp=dsum[i];
dsum[i]=dsum[j];
dsum[j]=temp;
}
}
}
long prtrt=s[0];
long prsum=dsum[0];
long prl=l[0];
for(int i=1;i<n;i++)
{
prtrt=prtrt+s[i]+dsum[i]*prl;
prsum=prsum+dsum[i];
prl+=l[i];
}
out.println(prtrt);
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
