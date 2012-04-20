#include<stdio.h>
#include<iostream>
using namespace std;
long long int arr[2000][2000];
void getarr(int q[2][2000],int len)
{
	int i=0;
	for(i=0;i<len;i++)
	{
		scanf("%d ",&q[0][i]);
		scanf("%d",&q[1][i]);
	}
}
void preprocess()
{
	long long int mod=1000000007;
	int i=0;
	int j=0;
	for(i=0;i<2000;i++)
	{
		arr[0][i]=1;
	}
	for(i=0;i<2000;i++)
	{
		arr[i][0]=1;
	}
	for(i=1;i<2000;i++)
	{
		for(j=1;j<2000;j++)
		{
			arr[i][j]=(arr[i][j-1]+arr[i-1][j-1]+arr[i-1][j])%mod;
		}
	}
}
int main()
{
	int t=0;
	scanf("%d",&t);
	int q[2][2000];
	getarr(q,t);
	preprocess();
	int i=0;
	for(i=0;i<t;i++)
	{
		cout<<arr[q[0][i]][q[1][i]]<<endl;
	}
}
