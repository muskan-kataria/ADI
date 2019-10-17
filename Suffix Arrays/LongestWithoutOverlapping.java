import java.util.*;
class LongestWithoutOverlapping
{
	
	public  static String longestRepeatedSubstring(String str) { 
        int n = str.length(); 
        int Len[][] = new int[n + 1][n + 1]; 
        String res = "";  
        int res_length = 0;  
        int i, index = 0; 
        for (i = 1; i <= n; i++) { 
            for (int j = i + 1; j <= n; j++) {  
                if (str.charAt(i - 1) == str.charAt(j - 1) 
                        && Len[i - 1][j - 1] < (j - i)) { 
                    Len[i][j] = Len[i - 1][j - 1] + 1;  
                    if (Len[i][j] > res_length) { 
                        res_length = Len[i][j]; 
                        index = Math.max(i, index); 
                    } 
                } else { 
                    Len[i][j] = 0; 
                } 
            } 
        }  
        if (res_length > 0) { 
            for (i = index - res_length + 1; i <= index; i++) { 
                res += str.charAt(i - 1); 
            } 
        } 
  
        return res; 
    } 
public static void main(String args[])
{
 String str = "banana"; 
        System.out.println(longestRepeatedSubstring(str)); 
}
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           