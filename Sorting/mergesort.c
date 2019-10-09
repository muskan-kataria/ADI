#include<stdio.h>


void merge(int arr[], int l, int m, int r) 
{ 
    int i, j, k; 
    int n1 = m - l + 1; 
    int n2 =  r - m; 
  
 
    int L[n1], R[n2]; 
  
    for (i = 0; i < n1; i++) 
        L[i] = arr[l + i]; 
    for (j = 0; j < n2; j++) 
        R[j] = arr[m + 1+ j]; 
 
    i = 0; 
    j = 0;
    k = l;
    while (i < n1 && j < n2) 
    { 
        if (L[i] <= R[j]) 
        { 
            arr[k] = L[i]; 
            i++; 
        } 
        else
        { 
            arr[k] = R[j]; 
            j++; 
        } 
        k++; 
    } 

    while (i < n1) 
    { 
        arr[k] = L[i]; 
        i++; 
        k++; 
    } 

    while (j < n2) 
    { 
        arr[k] = R[j]; 
        j++; 
        k++; 
    } 
} 


void mergeSort(int arr[],int s,int e) 
{ 
    if (s<e) 
    { 
        int m = s+(e-s)/2; 
        mergeSort(arr, s, m); 
        mergeSort(arr, m+1, e); 
        merge(arr, s, m, e); 
    } 
} 

int main()
{
	int n,i;
	scanf("%d",&n);
	int arr[n];
	
	for(i=0;i<n;i++)
	scanf("%d",&arr[i]);
mergeSort(arr,0,n- 1); 
	
	for(i=0;i<n;i++)
	printf("%d ",arr[i]);
return 0;	
}