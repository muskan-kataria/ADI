#include<stdio.h>

quicksort(int arr[],int low,int high)
{
	if(low<high)
	{
	int pi=partition(arr,low,high);
	
	quicksort(arr,low,pi-1);
    quicksort(arr,pi+1,high);	
	}
}

int partition(int arr[],int low,int high)
{
	if(low<high)
	{
		int pivot=arr[low],temp,p1=low+1,i;
		for(i=low+1;i<=high;i++)
		{
			if(arr[i]<pivot)
			{
				temp=arr[i];
				arr[i]=arr[p1];
				arr[p1]=temp;
				p1++;
				
			}
		}
		
	
		arr[low]=arr[p1-1];
			arr[p1-1]=pivot;
			
			return p1-1;
		
	}
}


int main()
{
	int n,i;
	scanf("%d",&n);
	int arr[n];
	
	for(i=0;i<n;i++)
	scanf("%d",&arr[i]);
	
	quicksort(arr,0,n-1);
	
	for(i=0;i<n;i++)
	printf("%d ",arr[i]);
return 0;	
}
