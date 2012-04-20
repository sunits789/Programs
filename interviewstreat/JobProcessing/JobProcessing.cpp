#include<iostream>
#include<cmath>
#include<algorithm>
#include<limits>
#include<vector>
#include<bitset>
#include<cstdlib>
#include<cstdio>
#include<cstring>
#include<map>

using namespace std;

#define REP(i,n) for(int i=0;i<n;i++)
#define FOR(i,FROM,n) for(int i=FROM;i<n;i++)
#define FORR(i,n) for(int i=n;i>=0;i--)
#define ll long long int
#define llu long long unsigned int
#define si(n) scanf("%d",&n)
#define sl(n) scanf("%lld",&n)
#define slu(n) scanf("%llu",&n)
#define sf(n) scanf("%f",&n)
#define sd(n) scanf("%lf",&n)
#define ss(n) scanf("%s",n)

ll gcd(ll r0, ll r1)
{
    if(r0==0 || r1==0)
    return 1;

    if(r0<r1)
    return gcd(r1,r0);

    if(r0%r1==0)
    return r1;

    return gcd(r1,r0%r1);
}
ll findInverse(ll a, ll b)
{
    ll x[3];
    ll y[3];
    ll quotient  = a / b;
    ll remainder = a % b;
    x[0] = 0;
    y[0] = 1;
    x[1] = 1;
    y[1] = quotient * -1;

    ll i = 2;
    for (; (b % (a%b)) != 0; i++)
    {
        a = b;
        b = remainder;
        quotient = a / b;
        remainder = a % b;
        x[i % 3] = (quotient * -1 * x[(i - 1) % 3]) + x[(i - 2) % 3];
        y[i % 3] = (quotient * -1 * y[(i - 1) % 3]) + y[(i - 2) % 3];
    }
    //x[i — 1 % 3] is inverse of a
    //y[i — 1 % 3] is inverse of b
    return x[(i - 1) % 3];
}

int t,n,m;

/*
bool myfunction(data i,data j)    //use it to sort vectors
{
    if( i.x < j.x ) return true;
    if( j.x < i.x ) return false;
    return j.y > i.y;
}
*/

ll a[100000],sum[100000];

int see(ll v) {
    ll sum=0;
    int at=0;
    REP(i,m) {
        while(at<n && sum+a[at]<=v) {
            sum+=a[at];
            at++;
        }
        sum=0;
    }
    if(at==n) {
        return 1;
    }
    return 0;
}

ll binary(ll start, ll end) {
    if(start==end) {
        return start;
    }
    int mid=(start+end)/2;
    if(see(mid)) {
        return binary(start,mid);
    } else {
        return binary(mid+1,end);
    }
}

int main()
{
   //freopen("input.txt","r",stdin);
   //freopen("output.txt","w",stdout);

   //scanf("%d",&t);
   //for(int prob=0;prob<t;prob++)
   si(n);
   si(m);
   REP(i,n) {
       sl(a[i]);
   }
   sum[0]=a[0];
   FOR(i,1,n) {
       sum[i]=sum[i-1]+a[i];
   }
   printf("%lld\n",binary(0,sum[n-1]));

   //system("pause");
   return 0;

}
