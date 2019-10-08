import java.util.*;


public class Paranthesis 
{
    
    
    public static void main(String args[])
    {
        Stack<Character> st=new Stack<>(); 
        
        Scanner sc=new Scanner(System.in);
        
        String str=sc.next();
        
        int len=str.length();
    
        int i;
        for(i=0;i<len;i++)
        {
        char ch=str.charAt(i);
            
            if(ch=='('||ch=='{'||ch=='[')
                st.push(ch);
            
            else if(ch==')')
            {
              char c=st.pop();
                if(c!='(')
                {
                    System.out.println("NOT BALANCED");
                    System.exit(0);
                }
            }
            
             else if(ch=='}')
            {
              char c=st.pop();
                if(c!='{')
                {
                    System.out.println("NOT BALANCED");
                    System.exit(0);
                }
            }
            
             else if(ch==']')
            {
              char c=st.pop();
                if(c!='[')
                {
                    System.out.println("NOT BALANCED");
                    System.exit(0);
                }
            }
            
            
            
        }s
        
      System.out.println("BALANCED");  
    }
}





