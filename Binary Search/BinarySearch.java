import java.util.*;

class BinarySearch{
	
	public static int binarysearch(int arr[],int n,int key){
		int left=0,right=n-1;
		while(left<=right){
			int mid=(left+right)/2;
			if(arr[mid]==key)
				return mid;
			else if(arr[mid]<key)
				left=mid+1;
			else
				right=mid-1;
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
		System.out.println("Enter number to be searched : ")
		int num=sc.nextInt();
		System.out.println(binarysearch(arr,n,num));
		
	}
}