import java.util.*;

class BinarySearch{
	
	public static int findmissing(int arr[],int n){
		int left=0,right=n-1,mid=0;
		
		while(left<=right){
			 mid=(left+right)/2;
			
			if(arr[mid]!=(mid+1) && arr[mid-1]==mid)
				return mid+1;
			else if(arr[mid]!=mid+1)
				right=mid-1;
			else
				left=mid+1;
		}
		
		return -1;
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		Arrays.sort(arr);
		System.out.println(findmissing(arr,n));
		
	}
}