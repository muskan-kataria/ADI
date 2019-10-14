import java.util.*;

class RatMaze
{
    
   public void solvemaze(int n,int x,int y,int maze[][])
   {
     int sol[][]=new int[n][n];
     int i,j;
       
       for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            sol[i][j]=0;
       
      if( solve(n,0,0,maze,sol)==true)
      {
          for(i=0;i<n;i++)
          {for(j=0;j<n;j++)
          {System.out.print(sol[i][j]+" "); 
          }
           System.out.println("");
          }
      }
       else
           System.out.println("path not exist");
       
       
   }
    
    
    public boolean isSafe(int n,int x,int y,int maze[][])
    {
        if(x<n&&y<n&&maze[x][y]==1)
            return true;
        
        return false;
    }
    
    
public boolean solve(int n,int x,int y,int maze[][],int sol[][])
 {
     
    if(x==n-1&&y==n-1)
    { sol[x][y]=1;
     return true;
    }
    
    if(isSafe(n,x,y,maze)==true)
    {
        sol[x][y]=1;
        
       if(solve(n,x+1,y,maze,sol))
           return true;
        
        
         if(solve(n,x,y+1,maze,sol))
           return true;
        
        
        sol[x][y]=0;
        return false;
        
        
        
        
    }
     
     
    return false; 
     
     
     
     
 }
    

public static void main(String args[])
{
    
    Scanner sc=new Scanner(System.in);

    int i,j,n;
    
    n=sc.nextInt();
    
    int maze[][]=new int[n][n];
    
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            maze[i][j]=sc.nextInt();
    RatMaze rat=new RatMaze();
rat.solvemaze(n,0,0,maze);
    
}

}