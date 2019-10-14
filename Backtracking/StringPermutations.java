import java.util.*;

class StringPermutations{
	
	public static void generate_String(String str,String ans){
		if(str.length()==0)
			System.out.println(ans);
		else {
			for(int i=0;i<str.length();i++){
				char ch=str.charAt(i);
				String res=str.substring(0,i)+str.substring(i+1);
				generate_String(res,ans+ch);
			}
		}
	}
	
		public static void distinct_String(String str,String ans){
		if(str.length()==0)
			System.out.println(ans);
		else {
			boolean arr[]=new boolean[26];
			for(int i=0;i<str.length();i++){
				char ch=str.charAt(i);
				String res=str.substring(0,i)+str.substring(i+1);
				if(arr[ch-'a']==false)
				distinct_String(res,ans+ch);
				arr[ch-'a']=true;
			}
		}
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String a=str;
		generate_String(str,"");
		System.out.println("DISTINCT");
		distinct_String(a,"");
	}
}