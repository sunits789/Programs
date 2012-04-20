import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.EOFException;


class PassManager  {
        public static void main(String[] Args)throws IOException {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                PassMan solver = new PassMan();
                solver.solve(1, in, out);
                out.close();
        }
}

class PassMan
{
public void solve(int testNumber, InputReader in, PrintWriter out)throws IOException
{
	int choice=0;
	do
	{
		System.out.println("Enter choice: ");
		System.out.println("1. Add Record: ");
		System.out.println("2. Edit Record: ");
		System.out.println("3. Search Record: ");
		System.out.println("4. Delete Record: ");
		System.out.println("5. Show all record: ");
		System.out.println("6. Delete all record: ");
		System.out.println("0. Exit");
		choice=in.nextInt();
		if(choice!=0)
		{
			if(choice==1)
			{
				addrecord(in);
			}
			else if(choice==2)
			{
				editrecord(in);
			}
			else if(choice==3)
			{
				searchrecord(in);
			}
			else if(choice==4)
			{
				deleterecord(in);
			}
			else if(choice==5)
			{
				show();
			}
			else if(choice==6)
			{
				deleteall();
			}
			else
			{
				System.out.println("Wrong Choice: ");
			}
		}
	}while(choice!=0);
		




}



public void addrecord( InputReader in)throws IOException
{
		ObjectInputStream input=new ObjectInputStream(new FileInputStream("encrypt.ser"));        // Input file just file name in place of System.in
		String arr[][]=new String[1000][3];
		int count=0;
		try
		{
			while(true)
			{
				Information infor=(Information)input.readObject();
				arr[count][0]=infor.getw();
				arr[count][1]=infor.getu();
				arr[count][2]=infor.getp();
				count++;
			}
		}
		catch(EOFException endoffileexception)
		{
			;
		}
		catch(ClassNotFoundException classnotfound)
		{
			System.err.println("Error code: 1");
		}
		ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("encrypt.ser"));
		System.out.println("Enter Website: ");
		String w=in.next();
		System.out.println("Enter Username: ");
		String u=in.next();
		System.out.println("Enter Password: ");
		String p=in.next();
		Information info = new Information(w,u,p);
		System.out.println("Object Information:");
		info.printinfo();
		for(int i=0;i<count;i++)
		{
			Information infor=new Information(arr[i][0],arr[i][1],arr[i][2]);
			output.writeObject(infor);
		}
		output.writeObject(info);
}


public void editrecord(InputReader in)throws IOException
{
		ObjectInputStream input=new ObjectInputStream(new FileInputStream("encrypt.ser"));        // Input file just file name in place of System.in
		String arr[][]=new String[1000][3];
		int count=0;
		try
		{
			while(true)
			{
				Information infor=(Information)input.readObject();
				arr[count][0]=infor.getw();
				arr[count][1]=infor.getu();
				arr[count][2]=infor.getp();
				count++;
			}
		}
		catch(EOFException endoffileexception)
		{
			;
		}
		catch(ClassNotFoundException classnotfound)
		{
			System.err.println("Error code: 1");
		}
		System.out.println("Enter Username: ");
		String u=in.next();
		System.out.println("Enter Website: ");
		String w=in.next();
		int ind=-1;
		for(int i=0;i<count;i++)
		{
			if((w.compareTo(arr[i][0])==0)&&(u.compareTo(arr[i][1])==0))
			{
				ind=i;
				i=count;
				System.out.println("Data match found, specify the change: ");
				System.out.println("1. Username: ");
				System.out.println("2. Password: ");
				int choice=0;
				choice=in.nextInt();
				if(choice==1)
				{
					System.out.println("Enter new Username: ");
					arr[ind][1]=in.next();
				}
				else if(choice==2)
				{
					System.out.println("Enter new Password: ");
					arr[ind][2]=in.next();
				}
				else
				{
					System.out.println("Wrong choice! ");
				}
			}
		}
		if(ind==-1)
		{
			System.out.println("Data not found ");
		}
		ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("encrypt.ser"));
		for(int i=0;i<count;i++)
		{
			Information infor=new Information(arr[i][0],arr[i][1],arr[i][2]);
			output.writeObject(infor);
		}
}

public void searchrecord(InputReader in)throws IOException
{
		ObjectInputStream input=new ObjectInputStream(new FileInputStream("encrypt.ser"));        // Input file just file name in place of System.in
		String arr[][]=new String[1000][3];
		int count=0;
		try
		{
			while(true)
			{
				Information infor=(Information)input.readObject();
				arr[count][0]=infor.getw();
				arr[count][1]=infor.getu();
				arr[count][2]=infor.getp();
				count++;
			}
		}
		catch(EOFException endoffileexception)
		{
			;
		}
		catch(ClassNotFoundException classnotfound)
		{
			System.err.println("Error code: 1");
		}
		System.out.println("Enter name of website: ");
		String w=in.next();
		String searchresult[][]=new String[1000][3];
		int c=0;
		for(int i=0;i<count;i++)
		{
			if(w.compareTo(arr[i][0])==0)
			{
				searchresult[c][0]=arr[i][0];
				searchresult[c][1]=arr[i][1];
				searchresult[c][2]=arr[i][2];
				c++;
			}
		}
		System.out.println(c+" search results found for "+w+" website.");
		for(int i=0;i<c;i++)
		{
			System.out.println((i+1)+" "+searchresult[i][1]);
		}
		System.out.println("Show entry for: ");
		int choice=in.nextInt();
		if((choice<=c)&&(choice!=0))
		{
			System.out.println("Password: "+searchresult[choice-1][2]);
		}
		else
		{
			System.out.println("Wrong choice! ");
		}
}

public void deleterecord(InputReader in)throws IOException
{
		ObjectInputStream input=new ObjectInputStream(new FileInputStream("encrypt.ser"));        // Input file just file name in place of System.in
		String arr[][]=new String[1000][3];
		int count=0;
		try
		{
			while(true)
			{
				Information infor=(Information)input.readObject();
				arr[count][0]=infor.getw();
				arr[count][1]=infor.getu();
				arr[count][2]=infor.getp();
				count++;
			}
		}
		catch(EOFException endoffileexception)
		{
			;
		}
		catch(ClassNotFoundException classnotfound)
		{
			System.err.println("Error code: 1");
		}
		System.out.println("Enter name of website: ");
		String w=in.next();
		String searchresult[][]=new String[1000][3];
		int c=0;
		for(int i=0;i<count;i++)
		{
			if(w.compareTo(arr[i][0])==0)
			{
				searchresult[c][0]=arr[i][0];
				searchresult[c][1]=arr[i][1];
				searchresult[c][2]=arr[i][2];
				c++;
			}
		}
		System.out.println(c+" search results found for "+w+" website.");
		for(int i=0;i<c;i++)
		{
			System.out.println((i+1)+" "+searchresult[i][1]);
		}
		System.out.println("Enter choice to Delete ");
		int choice=in.nextInt();
		w=searchresult[choice-1][0];
		String u=searchresult[choice-1][1];
		String p=searchresult[choice-1][2];
		ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("encrypt.ser"));
		for(int i=0;i<count;i++)
		{
			if((c==0)||(arr[i][0].compareTo(w)!=0)||(arr[i][1].compareTo(u)!=0)||(arr[i][2].compareTo(p)!=0))
			{
				Information infor=new Information(arr[i][0],arr[i][1],arr[i][2]);
				output.writeObject(infor);
			}
		}
}

public void show()throws IOException
{
		ObjectInputStream inp=new ObjectInputStream(new FileInputStream("encrypt.ser")); 
		int count=0;
		try
		{
			while(true)
			{
				Information infor=(Information)inp.readObject();
				infor.printinfo();
				count++;
			}
		}
		catch(EOFException endoffileexception)
		{
			System.out.println("Total number of records: "+count);
		}
		catch(ClassNotFoundException classnotfound)
		{
			System.err.println("Error code: 1");
		}

}

public void deleteall()throws IOException
{
	ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("encrypt.ser"));
	output.close();
}


}

class Information implements Serializable
{
		private String w;
		private String u;
		private String p;
		public String getw()
		{
				return w;
		}
		public String getu()
		{
				return u;
		}
		public String getp()
		{
				return p;
		}
		public void printinfo()
		{
			System.out.println(w+" "+u+" "+p);
		}
		public Information(String w, String u, String p)
		{
				this.w=w;
				this.u=u;
				this.p=p;
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
