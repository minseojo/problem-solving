#include <stdio.h>

int main()
{
	int n, m,d=0;
	scanf("%d %d", &n, &m);
	while (1)
	{
		if (n%m == 0)
		{
			d += 0;
			break;
		}
		else if (m%n == 0)
		{
			d += ((m / n) - 1)*n;
			break;
		}
		else if (m > n)
		{
			d += (m / n) *n;
			m -= (m/n)*n;
		}
		else if (m < n)
		{
			n = n - m;
		}
	}
	printf("%d", d);
}

