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
}

 class Index{
		int index;
	}
	



class ConstructBST
{
	Node ArrRoot;     //Root of a tree constructing from array
	Node InPreRoot;   //Root of a tree constructing from InOrder and PreOrder
	Node InPostRoot;   //Root of a tree constructing from InOrder and PostOrder
	
		public static int search(int arr[],int s,int e,int key){
		int i;
		for( i=s;i<=e;i++)
			if(arr[i]==key)
				return i;
		return i;
	}
	
	public static Node Build_from_In_Pre(int in[],int pre[],int n){
		Index i=new Index();
		i.index=0;
		return Tree_In_Pre(in,pre,0,n-1,i);
	}
	
	public static Node Tree_In_Pre(int in[],int pre[],int s,int e,Index c){
		if(s>e)
			return null;
		Node node=new Node(pre[c.index]);
	c.index++;
		if(s==e)
			return node;
		int i=search(in,s,e,node.data);
		node.left=Tree_In_Pre(in,pre,s,i-1,c);
		node.right=Tree_In_Pre(in,pre,i+1,e,c);
		return node;
	}
	
	
	public static Node Tree_In_Post(int in[],int post[],int s,int e,Index c){
		if(s>e)
			return null;
		Node node=new Node(post[c.index]);
		c.index--;
		if(s==e)
			return node;
		int i=search(in,s,e,node.data);
		node.right=Tree_In_Post(in,post,i+1,e,c);
		node.left=Tree_In_Post(in,post,s,i-1,c);
		return node;
	}
	
	public static Node Build_from_In_Post(int in[],int post[],int n){
		Index i=new Index();
		i.index=n-1;
		return Tree_In_Post(in,post,0,n-1,i);
	}
	
	 public Node Build_from_Array(int[] arr, Node root, 
                                                int i) 
    { 
        if (i<arr.length){ 
            Node temp=new Node(arr[i]); 
            root=temp; 
            root.left=Build_from_Array(arr,root.left,2*i+1); 
            root.right=Build_from_Array(arr,root.right,2*i+2); 
        } 
        return root; 
    } 
	 public static void printInOrder(Node r)
    {
        if(r!=null)
        {
              
            printInOrder(r.left);
            System.out.print(r.data+"  ");
             printInOrder(r.right);
        }
    }
    
	
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.println("enter no of elements");
	int n=sc.nextInt();
	int in[]=new int[n];
	int pre[]=new int[n];
	int post[]=new int[n];
	int arr[]=new int[n];
	
	System.out.println("enter array elements");
	for(int i=0;i<n;i++)
		arr[i]=sc.nextInt();
	
	System.out.println("enter pre order");
	for(int i=0;i<n;i++)
		pre[i]=sc.nextInt();
	
	System.out.println("enter in order");
	for(int i=0;i<n;i++)
		in[i]=sc.nextInt();
	
	System.out.println("enter post order");
	for(int i=0;i<n;i++)
		post[i]=sc.nextInt();
	
	ConstructBST b=new ConstructBST();
	
b.InPreRoot=b.Build_from_In_Pre(in,pre,n);
b.InPostRoot=b.Build_from_In_Post(in,post,n);
	b.ArrRoot=null;
	b.ArrRoot=b.Build_from_Array(arr,b.ArrRoot,0);
	
System.out.print("\nInOrder from In and Pre");
				 printInOrder(b.InPreRoot);
System.out.print("\nInOrder from In and Post:");
				  printInOrder(b.InPostRoot);
	System.out.print("\nInOrder from Array:");
				  printInOrder(b.ArrRoot);
	
}
}