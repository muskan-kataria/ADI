import java.util.*;

class NQueen
{
	
	public static void printboard(int board[][],int n)
{
  for(int i=0;i<n;i++)
  {
    for(int j=0;j<n;j++)
   System.out.print(" "+board[i][j]);
    System.out.print("\n");
  }
 System.out.println(" ");
}

public static boolean isSafe(int board[][],int row,int col,int n)
{
  int i,j;

  for(i=0;i<col;i++)
  if(board[row][i]==1)
  return false;

  for(i=row,j=col;i>=0&&j>=0;i--,j--)
  if(board[i][j]==1)
  return false;

  for(i=row,j=col;i<n&&j>=0;i++,j--)
  if(board[i][j]==1)
  return false;

  return true;
}
public static boolean solveNQ(int board[][],int col,int n)
{
  if(col>=n)
  {
    printboard(board,n);
    return true;

  }
  boolean res=false;
  for(int i=0;i<n;i++)
  {
    if(isSafe(board,i,col,n))
    {
      board[i][col]=1;

      res=solveNQ(board,col+1,n)||res;

      board[i][col]=0;
    }
  }
  return res;
}


public static void nqueen(int n)
{
  int board[][]=new int[n][n];
  for(int i=0;i<n;i++)
    for(int j=0;j<n;j++)
    board[i][j]=0;

  if(solveNQ(board,0,n)==false)
  {
    System.out.println("solution does not exist");
  }
}

public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	nqueen(n);
}
}


