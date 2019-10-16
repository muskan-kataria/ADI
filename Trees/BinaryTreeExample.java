import java.util.*;




class Node
{
    int data;
    Node left,right;
    
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
    
    void setLeft(Node l)
    {
        left=l;
    }
     void setRight(Node r)
    {
        right=r;
    }
    
    int getData()
    {
      return data;  
    }
    
    Node getLeft()
    {
        return left;
    }
    Node getRight()
    {
        return right;
    }
}

class Path
{
    int sum;
    int size;
    Node arr[]=new Node[100];
}

public class BinaryTreeExample
{

    Node root=null;
    
    BinaryTreeExample(int d)
    {
        root=new Node(d);
    }
 public   void insert(int d)
    {
           Node n=new Node(d);
    insert(root,n,d);
    }
    
 public   void insert(Node r,Node n,int d)
    {
                  if(r==null)
        {
            r=n;
   
               System.out.println(" "+r.data);
        
        }
      
         else if(d<r.data&&r.left==null)
            {
          
        r.setLeft(n);
            }
        else if(d>=r.data&&r.right==null)
            {
                
                r.setRight(n);
            }
        
          else
          {
   
             if(d<r.data)
              {  
                  insert(r.left,n,d);
               
              }
              else
              {
           
                  insert(r.right,n,d);
              }
          }
        
    }    
   public void printInOrder(Node r)
    {
        if(r!=null)
        {
              
            printInOrder(r.left);
            System.out.print(r.data+"  ");
             printInOrder(r.right);
        }
    }
    
       public void printPreOrder(Node r)
    {
        if(r!=null)
        {
              
              System.out.print(r.data+"  ");
            printInOrder(r.left);
         
             printInOrder(r.right);
        }
    }
    
       public void printPostOrder(Node r)
    {

        if(r!=null)
        {
              
            printInOrder(r.left);
          
             printInOrder(r.right);
              System.out.print(r.data+"  ");
        }
    }
    
    public int find_height(Node r)
    {
      
        if(r==null)
            return 0;
        else
        {
           int  maxl=find_height(r.left);
           int maxr=find_height(r.right);
            
            if(maxl>maxr)
                return maxl+1;
            else
                return maxr+1;
        }
    }
    
    public int find_diameter(Node r)
    {
        if(r==null)
            return 0;
        
        int lh=find_height(r.left);
         int rh=find_height(r.right);
        
        int ld=find_diameter(r.left);
        int rd=find_diameter(r.right);
        
        return Math.max(lh+rh+1,Math.max(ld,rd));
        
    }
    
    public int find_common_node(Node r,int a,int b)
    {
        if(r==null)
            return 0;
   
        int ln=find_common_node(r.left,a,b);
          int rn=find_common_node(r.right,a,b);
        
        if(ln==1&&rn==1)
            return r.data;
        
             if(r.data==a||r.data==b)
            return 1;
        
        return 0;
        
    }
    
 

    public void In_Order_Stack(Node r)
    {
         if(r==null)
        return;
    
       Stack<Node> s=new Stack<Node>();

        while(r!=null||s.size()>0)
        {
            while(r!=null)
            {
                s.push(r);
                r=r.left;
            }
            r=s.pop();
            System.out.println(" "+r.data);
            r=r.right;
        }
        
    }
    
   
    
  public   void print_Level_Order(Node r) 
    { 
      if(r==null)
          return;
      Queue<Node> q=new LinkedList<Node>();
      q.add(r);
      while(q.size()>0)
      {
          Node temp;
          temp=q.poll();
          System.out.print(" "+temp.data);
          if(temp.left!=null)
              q.add(temp.left);
          if(temp.right!=null)
              q.add(temp.right);   
      }
      
    }
	
	public void Reverse_Level(Node r,int level)
	{
		if(r==null)
			return;
		if(level==1)
			System.out.print(r.data+" ");
		 else if (level > 1)  
        { 
            Reverse_Level(r.left, level - 1); 
            Reverse_Level(r.right, level - 1); 
        } 
	}
    
    public void print_Spiral(Node r)
    {
        if(r==null)
            return;
        Stack<Node> s1=new Stack<Node>();
           Stack<Node> s2=new Stack<Node>();
        
        s1.push(r);
        
        while(s1.size()>0||s2.size()>0)
        {
            while(s1.size()>0)
            {
                Node temp;
                temp=s1.peek();
                s1.pop();
                System.out.print(" "+temp.data);
                if(temp.right!=null)
                s2.push(temp.right);
                if(temp.left!=null)
                s2.push(temp.left);
            }
            while(s2.size()>0)
            {
                Node temp;
                temp=s2.peek();
                s2.pop();
                System.out.print(" "+temp.data);
                if(temp.left!=null)
                s1.push(temp.left);
                if(temp.right!=null)
                s1.push(temp.right);
            }
        }
        
            
    }
    
    public void find_max_path(Path p,Node r)
    {
        
        if(r==null)
            return ;
        
        Stack<Node> s1=new Stack<Node>();
          Stack<Node> s2=new Stack<Node>();
        
        find_path(s1,s2,r);
        
        while(s1.size()>0)
        {
           p.arr[p.size]=s1.peek();
            System.out.print(" "+(p.arr[p.size]).data);
            s1.pop();
            p.size++;
        }
  
          while(s2.size()>0)
        {
           p.arr[p.size]=s2.peek();
              System.out.print(" "+(p.arr[p.size]).data);
            s2.pop();
            p.size++;
        }
    }
    
    public int find_path(Stack s1,Stack s2,Node r)
    {
        if(r==null)
            return 0;
        int ls=find_path(s1,s2,r.left);
        int rs=find_path(s1,s2,r.right);
        
        if(ls>rs)
        {
            s1.push(r);
            while(s2.size()>0)
                s2.pop();
            
        }
        else
        {
            s2.push(r);
            while(s1.size()>0)
                s1.pop();  
        }
        return r.data;
    }
    
    public int find_max_sum(Path p,Node r)
    {
        if(r==null)
            return 0;
        int ls=find_max_sum(p,r.left);
        int rs=find_max_sum(p,r.right);
        
        return (ls>rs?ls:rs)+r.data;
    }
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    
    if(n==0)
        System.exit(0);
      BinaryTreeExample b;
    
     int num=sc.nextInt();
  
    b=new BinaryTreeExample(num);
    n--;
  
    
    while(n>0)
    {
     num=sc.nextInt();
        
    b.insert(num);
        
      n--;  
    }
    
        
    
    System.out.println("IN ORDER:");
      b.printInOrder(b.root);
     System.out.println("\nPre ORDER:");
      b.printPreOrder(b.root);
     System.out.println("\nPost ORDER:");
      b.printPostOrder(b.root);
    
    int h=b.find_height(b.root);
        System.out.println("\nHeight: "+h);

       
    System.out.println("\nLevel order traversal of binary tree is "); 
       b.print_Level_Order(b.root); 
    
    System.out.println("\nLevel order spiral traversal of binary tree is"); 
       b.print_Spiral(b.root); 
    
    Path p=new Path();
    p.sum=0;
    p.size=0;
 
    p.sum=b.find_max_sum(p,b.root);
    System.out.println("\n max sum:"+p.sum);
   
        System.out.println("\n path:");
    b.find_max_path(p,b.root);
    
       int dia=b.find_diameter(b.root);
        System.out.println("\nDiameter: "+dia);
    
      int no=b.find_common_node(b.root,1,20);
        System.out.println("\nCommon Node: "+no);
	
	
	System.out.println("\n Reverse level order");
	for(int j=h;j>=1;j--)
	{
		b.Reverse_Level(b.root,j);
	}
}
}