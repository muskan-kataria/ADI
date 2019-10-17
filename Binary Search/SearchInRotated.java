import java.util.*;

class BinarySearch{
	
	
	public static int find(int arr[],int low,int high,int key){
		if(low>high)
			return -1;
		int mid=low+(high-low)/2;
		if(arr[mid]==key)
			return mid;
		else if(arr[low]<=arr[mid]){
			if(key>=arr[low] && key<=arr[mid])
				return find(arr,low,mid-1,key);
			else
			return find(arr,mid+1,high,key);
		}
		else{
			if(key>=arr[mid] && key<=arr[high])
				return find(arr,mid+1,high,key);
			else
				return find(arr,low,mid-1,key);
		}
	}
	
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		System.out.println("Enter number : ");
		int key=sc.nextInt();
		System.out.println(find(arr,0,n-1,key));
		
	}
}