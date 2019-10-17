import java.util.*;

class BinarySearch{
	
	public static int firstoccurence(int arr[],int n,int left,int right,int key){
		if(left<=right){
			int mid=left+(right-left)/2;
			if((mid==0 || key!=arr[mid-1]) && arr[mid]==key)
				return mid;
			else if(arr[mid]<key)
				return firstoccurence(arr,n,mid+1,right,key);
			else
				return firstoccurence(arr,n,left,mid-1,key);
		}
		return -1;
	}
	
	public static int lastoccurence(int arr[],int n,int left,int right,int key){
		if(left<=right){
			int mid=left+(right-left)/2;
			if((mid==n-1 || key!=arr[mid+1]) && arr[mid]==key)
				return mid;
			else if(arr[mid]<key)
				return firstoccurence(arr,n,mid+1,right,key);
			else
				return firstoccurence(arr,n,left,mid-1,key);
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
		System.out.println("Enter number to be searched : ");
		int num=sc.nextInt();
		System.out.println(firstoccurence(arr,n,0,n-1,num));
		System.out.println(lastoccurence(arr,n,0,n-1,num));
	}
}