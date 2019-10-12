import java.util.*;
class Z
{
	public static void get_array(String concat,int arr[])
	{
		int n=concat.length();
		int i,j;
		
		for( i=1;i<n;i++)
		{
			arr[i]=0;
			int k=i;
			
			for(i=0,j=k ;i<j&&j<n;j++)
			{
				if(concat.charAt(i)==concat.charAt(j))
				{arr[k]++;
				 i++;
				}
				else
					break;
			}
			i=k;
		}
		System.out.println("concat array:");
		for(i=0;i<n;i++)
			System.out.print(" "+arr[i]);
			
	}
public static void Search(String text,String pattern)
{
 int m=text.length();
	int n=pattern.length();
	int arr[]=new int[m+n+1];
	
	String concat=pattern+"$"+text;
	
	get_array(concat,arr);
	
	int i;
	
	for(i=0;i<concat.length();i++)
	{
		if(arr[i]==n)
		{
			System.out.println("\npattern found at index: "+(i-n-1));
			break;
		}
	}
	
	if(i==concat.length())
		System.out.println("\nNo Pattern Found");

		
}
public static void main(String args[])
{
String text="baabaa";
String pattern="aab";
Search(text,pattern);
	

}
}