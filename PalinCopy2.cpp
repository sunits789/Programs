#include<iostream>
using namespace std;
#include<string.h>
#define MAX 2000
//void fillIsPalin(boolean ispalin[][], string s)  //NOT USED

//Global arrays

int arr[MAX][MAX];
bool ispalin[MAX][MAX];

void solve(int testNumber, string s, string out) //solve function, s ->in
{
	//testNumber = 1; 							//temporary
	int l =s.length();							//cpp
	//cout << l;									//o
	
	//fillIsPalin(ispalin,s); HERE
		{
		int l=s.length();
		for(int i=0;i<l;i++)
		{
			ispalin[i][i]=true;;
		}
		for(int i=0;i<l-1;i++)
		{
			if(s[i]==s[i+1])
			{
				ispalin[i][i+1]=true;
			}
		}
		for(int i=2;i<l;i++)
		{
			for(int j=0;j<l-i;j++)
			{
				if(s[j]==s[j+i])
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
} //END IF ispaliln 

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
//cout<<(arr[i][j]);
}
}
int q=0;
cin>>q;
for(int i=0;i<q;i++)
{
	int a=0;
	int b=0;
	cin>>a>>b;
	cout<<arr[a][b]<<endl;
}
cout << endl;

	//cout << "here"  << endl;

}									//BRACE CHECK

int main()
{
	////////////////////////////////////////////o
	
//string strs = "abcdefghijkl";
  //              string st=strs.substr(2, 8-2); cout<<"st " <<(st)<<endl;			//o
   //             string str=st.substr(3);  cout<<(str)<<endl;      //o
	///////////////////////////////////////////o
	string s;
	string out;
	cin >> s;
	solve(1, s, out);
	
	return 0;
}

// void fillIsPalin(boolean ispalin[][], String s) //NOT USED


/********Keys to comme**
 * -> denotes variable substition from the original program
 *  temporary --> the extra variables/values assumed by me
 *  cpp --> the functions in cpp I have doubt in usingf
 * o --> checking outputs
 * CHECK BRACE
 * NOT USED
 -> * HERE =DESCRIBED BELOW
  //cout << "here"  << endl; -> program end
 */
