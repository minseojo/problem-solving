#include <bits/stdc++.h>
using namespace std;

int arr[1000011];
int tmp[1000011];

void merge(int list[], int left,int mid, int right) {
	int i,j,k;
	i=left;
	j=mid+1;
	k=left;
	
	while(i<=mid && j<=right) {
		if(list[i]<list[j]) tmp[k++] = list[i++];
		else tmp[k++] = list[j++];
	}
 
	if(i>mid) {
		for(int l = j; l <= right; l++)
			tmp[k++] = list[l];
	}
	else {
		for(int l = i; l <= mid; l++)
			tmp[k++] = list[l];
	}
	
	for(int l=left; l<=right; l++) 
		list[l] = tmp[l];
}

void mergeSort(int list[], int left, int right) {
	if(left < right) {
		int mid = (left + (right-left)/2);
		mergeSort(list, left, mid); // 분할  T(N/2)
		mergeSort(list, mid+1, right); // 분할 T(N/2) => 2T(N/2)
		merge(list, left, mid, right); // 정복 T(N)
	}
	// (T(N) + 2T(N/2)) => O(N*log(N))
}

int main() {
	int n;
	scanf("%d", &n);
	for(int i=0; i<n; i++) 
		scanf("%d", &arr[i]);
	
	mergeSort(arr, 0, n-1);
	
	for(int i=0; i<n; i++) 
		printf("%d\n", arr[i]);
		
	return 0; 
}
