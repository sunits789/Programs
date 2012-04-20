#include<iostream>
using namespace std;
int main()
{
	int f=0;
	do
	{
		int n=0;
		cin>>n;
		if(n!=42)
		{
			cout<<n<<endl;
		}
		else
		{
			f=1;
		}
	}while(f==0);
	return 0;
}
