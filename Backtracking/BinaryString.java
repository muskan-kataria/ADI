import java.util.*;

class BinaryString{
	
	public static void generate_String(String str,int n){
		if(str.length()==n)
			System.out.println(str);
		else {
			generate_String(str+"0",n);
			generate_String(str+"1",n);
		}
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String str=new String();
		generate_String(str,n);
	}
}