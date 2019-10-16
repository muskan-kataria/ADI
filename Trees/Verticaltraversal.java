import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



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

 class Verticaltraversal
{

    Node root=null;
    
    Verticaltraversal(int d)
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
    
    	private static Map<Integer, List<Integer>> mapVerticalDistance = null;

	private static void verticalOrder(Node root, int distance) {
		if (null == root)
			return;

		List<Integer> list = null;
		if (mapVerticalDistance.containsKey(distance)) {
			list = mapVerticalDistance.get(distance);
		} else {
			list = new ArrayList<Integer>();
		}
		
		list.add(root.data);
		mapVerticalDistance.put(distance, list);
		verticalOrder(root.left, distance - 1);
		verticalOrder(root.right, distance + 1);
	}
    
  	public static void verticalOrderOfBTree(Node root) {
		
		if (null == mapVerticalDistance) {
			mapVerticalDistance = new HashMap<Integer, List<Integer>>();
		} else {
			mapVerticalDistance.clear();
		}
		
		verticalOrder(root, 0);
		mapVerticalDistance
				.forEach(
						(k, v) 
							-> System.out.println("Nodes at distance " + k + " = " + v)
			);
	
			}
	 
	 public static void Top_View()
	 {
		 mapVerticalDistance
				.forEach(
						(k, v) 
							-> System.out.print(" "+v.get(0))
			);
	 }
    
 	 public static void Bottom_View()
	 {
		 mapVerticalDistance
				.forEach(
						(k, v) 
							-> System.out.print(" "+v.get(v.size()-1))
			);
	 }
 
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    
    if(n==0)
        System.exit(0);
      Verticaltraversal b;
    
     int num=sc.nextInt();
  
    b=new Verticaltraversal(num);
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
    
    System.out.println("\n vertical order");
b.verticalOrderOfBTree(b.root);
	
	System.out.println("\n Top View:");
	b.Top_View();
	
	
    System.out.println("\n Bottom View:");
	b.Bottom_View();
    
  
}                                                                                                                                  
}	