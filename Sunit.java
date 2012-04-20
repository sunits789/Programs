import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;
import java.lang.Math;


public class Sunit {
        public static void main(String[] args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                insomnia solver = new insomnia();
                solver.solve(1, in, out);
                out.close();
        }
}

class insomnia
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
int asize=((int)(Math.pow(2,n)));
int s[]=new int[n];
long ans[]=new long[asize];
int len[]=new int[asize];
int sum[]=new int[asize];
for(int i=0;i<n;i++)
{
s[i]=0;
}
for(int i=0;i<n;i++)
{
s[i]=trt(store[i],l[i]);
}
for(int i=0;i<n;i++)
{
int dummy=(int)Math.pow(2,i);
ans[dummy]=s[i];
len[dummy]=l[i];
sum[dummy]=dsum[i];
}
for(int i=1;i<asize;i++)
{
if(ans[i]==0)
{
getval(ans,len,sum,i);
}
}
out.println(ans[asize-1]);
}

public void getval(long ans[],int len[],int sum[],int ind)
{
String s=convert(ind);
int count=countone(s);
long max=0;
long sunit=0;
int ind1=0;
int ind2=0;
for(int i=0;i<count;i++)
{
ind1=0;
ind2=0;
int f=0;
for(int j=0;j<s.length();j++)
{
char c=s.charAt(j);
if(c=='1')
{
if(f==i)
{
ind2=(int)Math.pow(2,s.length()-j-1);
}
else
{
ind1+=(int)Math.pow(2,s.length()-j-1);
}
f++;
}
}
if(ans[ind1]==0)
{
getval(ans,len,sum,ind1);
}
if(ans[ind2]==0)
{
getval(ans,len,sum,ind2);
}
sum[ind]=sum[ind1]+sum[ind2];
len[ind]=len[ind1]+len[ind2];
sunit=ans[ind1]+((len[ind1]+1)*((len[ind1]*sum[ind2])+ans[ind2]));
if(sunit>max)
{
max=sunit;
}
}
ans[ind]=max;
}

public String convert(int n)
{
String num="";
int t=0;
while(n!=0)
{
num=String.valueOf(n%2)+num;
n/=2;
t++;
}
return num;
}

public int countone(String s)
{
int count=0;
for(int i=0;i<s.length();i++)
{
if(s.charAt(i)=='1')
{
count++;
}
}
return count;
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
