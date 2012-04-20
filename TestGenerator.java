import java.io.*;
import java.util.*;
public class TestGenerator
{
	public static void main(String[] Args)throws FileNotFoundException
	{
		Formatter output=new Formatter("1.txt");
		Random rand = new Random();
		int t=50;
		output.format("%d \n", t);
		for(int i=0;i<t;i++)
		{
			int a=rand.nextInt(50);
			output.format("%d ",a);
			a=rand.nextInt(50);
			output.format("%d\n",a);
		}
		output.close();
	}
}
