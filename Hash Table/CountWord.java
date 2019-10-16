import java.util.*;

class CountWord
{
public static void main (String args[])
{
Scanner sc=new Scanner(System.in);
String str=sc.nextLine();
str=str.trim().replaceAll("\\s{2,}", " ");
//System.out.println(str);
	
	String words[]=str.split(" ");
	
 HashMap<String,Integer> hmap =  
                new HashMap<String,Integer>(); 
	
	for(int i=0;i<words.length;i++)
	{
		 Integer c = hmap.get(words[i]); 
		
		if(c==null)
			hmap.put(words[i],1);
		else
			hmap.put(words[i],++c);
			
	}
	
	System.out.println(hmap);
	
	
}
}