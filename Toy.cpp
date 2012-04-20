#include<iostream>
#include<math.h>
int f(int);
int d[1000000]={0};
using namespace std;
int main()
{
    int t;
    for(t=1;t<6;t++)
    d[t]=t;
    cin>>t;
    while(t--)
    {
              int n;
              cin>>n;
              cout<<f(n)<<endl;
                                 }
                                 return 0;
                                 }
int f(int n)
{
    if(n<1000000)
    if(d[n])
    return d[n];
    int i,a=n;
    for(i=2;i<a;i++)
    {
                    if(n%i==0)
                    {
                                            if(a>i+f(n/i))
                                            a=i+f(n/i);
                                            }
                                            else
                                            {
                                            if(a>i+f(n/i+1))
                                            a=i+f(n/i+1);
                                            }
                                            }
                                            if(n<1000000)
                                            d[n]=a;
                                            return a;
                                            }
