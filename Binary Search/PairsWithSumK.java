import java.util.*;

class BinarySearch{
	
	public static int binarysearch(int arr[],int left,int right,int key){
		if(left<=right){
			int mid=left+(right-left)/2;
			if(arr[mid]==key)
				return mid;
			else if(arr[mid]<key)
				return binarysearch(arr,mid+1,right,key);
			else
				return binarysearch(arr,left,mid-1,key);
		}
		return -1;
	}
	
	public static int countPairs(int arr[],int n,int k){
		int count=0;
		for(int i=0;i<n-1;i++)
			if(binarysearch(arr,i+1,n-1,k-arr[i])!=-1){
				System.out.println(binarysearch(arr,i+1,n-1,k-arr[i]));
				count++;
			}
		return count;
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		Arrays.sort(arr);
		System.out.println("Enter required sum : ");
		int sum=sc.nextInt();
		System.out.println(countPairs(arr,n,sum));
		
	}
	}