import java.util.*;
public class KMP
{
  static void Search(String text,String pattern)
  {
    int m=text.length();
    int n=pattern.length();
    int lps[]=new int[n];
    calculate_Lps(pattern,n,lps);
    int i=0,j=0,k;
    while(i<m)
    {
      if(pattern.charAt(j)==text.charAt(i))
      {
        i++;
        j++;
      }
      if(j==n)
      {
        System.out.println("Pattern found at: "+(i-j));
        j=lps[j-1];
      }
      else if(i<m && pattern.charAt(j)!=text.charAt(i))
      {
        if(j!=0)
        {
          j=lps[j-1];
        }
        else
        i++;
      }
    }
  }

  static void calculate_Lps(String pattern,int n,int lps[])
  {
    int i=0,j;
    for(j=1;j<n;j++)
    {
      if(pattern.charAt(i)==pattern.charAt(j))
      {
        lps[j]=lps[j-1]+1;
        i++;
      }
      else
      i=0;
    }
  }


  public static void main(String args[])
  {
    String text="AAAAAAAAAAAAAAAAAB";
    String pattern="AAAAB";
    Search(text,pattern);
  }

}