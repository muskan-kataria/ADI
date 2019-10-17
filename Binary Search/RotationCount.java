import java.util.*;

class BinarySearch{
	
	public static int findRCount(int arr[],int left,int right){
		if(left>right)
			return 0;
		else if(left==right)
			return left;
		int mid=left+(right-left)/2;
		if(mid<right && arr[mid+1]<arr[mid])
			return mid+1;
		else if(mid>left && arr[mid-1]>arr[mid])
			return mid;
		else if(arr[right]>arr[mid])
			return findRCount(arr,left,mid-1);
		else
			return findRCount(arr,mid+1,right);
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		System.out.println(findRCount(arr,0,n-1));
		
	}
}