#include <bits/stdc++.h>
using namespace std;

long long pow(long long a, long long b,long long c)
{
	long long sum=0;
	if(b==0) return 1;
	sum = pow(a,b/2,c);
	long long result = sum*sum%c;
	if(b%2!=0) return result*a%c;
	return result;
}
int main()
{
	long long a,b,c;
	scanf("%d %d %d",&a,&b,&c);
	printf("%d",pow(a,b,c));
}