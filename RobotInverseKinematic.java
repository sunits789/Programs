import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;
public class RobotInverseKinematic
{
	public static void main(String[] Args)
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Robot solver = new Robot();
		solver.solve(1, in, out);
		out.close();
	}
}
class Robot 
{
	public void solve(int testNumber, InputReader in, PrintWriter out)
	{
		System.out.println("Enter the l0 l1 l2: ");
		double l3=in.nextDouble();
		double l2=in.nextDouble();
		double l1=in.nextDouble();
		System.out.println("Enter the coordinate of destination: ");
		double x=in.nextDouble();
		double y=in.nextDouble();
		double z=in.nextDouble();
		double temp=0.0;
		if(x>=0)
		{
			temp=Math.atan(y/x);
			temp*=(180/Math.PI);
		}
		else
		{
			temp=Math.atan(y/x);
			temp+=(y>=0)?Math.PI:(-Math.PI);
			temp*=(180/Math.PI);
		}
		double d=Math.sqrt((x*x)+(y*y));
		double diff=(l1>l2)?(l1-l2):(l2-l1);
		if((d>(l1+l2))||(d<diff)||(z>l3))
		{
			out.println("The destination point is out of reach.");
		}
		else
		{
			double cosA=((l1*l1)+(l2*l2)-(d*d))/(2*l1*l2);
			double cosB=((d*d)+(l2*l2)-(l1*l1))/(2*d*l2);
			double cosC=((l1*l1)+(d*d)-(l2*l2))/(2*l1*d);
			double A=Math.acos(cosA);
			double B=Math.acos(cosB);
			double C=Math.acos(cosC);
			A*=(180/Math.PI);
			B*=(180/Math.PI);
			C*=(180/Math.PI);
			double theta1=B+temp;
			double theta2=A;
			theta1=(theta1>180)?(theta1-360):theta1;
			double l=l3-z;
			out.println("The parameters are : \n Theta1: "+theta1+"\n Theta2: "+theta2+"\n Length: "+l);
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
    public double nextDouble()
    {
		return Double.parseDouble(next());
	}
}
