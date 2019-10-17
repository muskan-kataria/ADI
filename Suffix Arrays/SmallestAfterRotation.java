import java.util.*;

class SmallestAfterRotation
{
public static String Rotation(String s)
{
    int n = s.length();
String[] suffies = new String[n];
    suffies[0] = s.substring(1)+s.charAt(0);
        for (int i = 1; i < n; i++) 
            suffies[i] = suffies[i-1].substring(1)+suffies[i-1].charAt(0);
            
            Arrays.sort(suffies);

        for (int i =0 ; i < suffies.length; i++){
            System.out.println(i + " :: " + suffies[i] );
        }
        String result = "";
        
        result=suffies[0];
        
        return result;
}
public static void main(String[] args)
{
String str="hello";
String ans=Rotation(str);
System.out.println("smallest string of "+str+" : "+ans);
}
}