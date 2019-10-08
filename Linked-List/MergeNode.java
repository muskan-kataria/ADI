import java.util.*;

class Node
{
int data;
Node next;
    
    public Node(int e, Node n) 
    {
    data = e;
      next = n;
    }
}
class SinglyLinkedList
{
    Node head=null;
    
public void addLast(int e) {                
    Node newest = new Node(e,null);   
    if (head==null)
      head = newest;  
         else
         {
             Node curr=head;
             while(curr.next!=null)
             {
                 curr=curr.next;
               
             }
             curr.next=newest;
         }
 
  }
}
class MergeNode
{
       

 

public static void display(SinglyLinkedList list)
{
   
        Node current = list.head;    
            
        if(current == null) {    
            System.out.println("List is empty");    
            return;    
        }    
        System.out.println("Nodes of singly linked list: ");    
        while(current != null) {    
         
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();   
}
    
    public static void Merge_Point(Node head1,Node head2)
    {
        Node A=head1,B=head2;
        
        int sizeA=0,sizeB=0,c=0,d;
        
        while(A!=null)
        {sizeA++;
         A=A.next;
        }
        while(B!=null)
        {sizeB++;
         B=B.next;
        }
        
        if(sizeA>sizeB)
        {c=sizeA-sizeB;
         A=head1;
         B=head2;
           d=find(c,A,B);
        }
        else
        {
          c=sizeB-sizeA;
         A=head1;
            B=head2; 
              d=find(c,B,A);
        }
        
        if(d==-1)
            System.out.println("no merge point");
        
        else
            System.out.println("merge point:"+d);
       
    }
    
    public static int find(int c,Node A,Node B)
    {
        for (int i = 0; i < c; i++) { 
            if (A == null) { 
                return -1; 
            } 
            A= A.next; 
        } 
        while (A != null &&B != null) { 
            if (A.data == B.data) { 
return A.data;
            } 
            A= A.next; 
            B= B.next; 
        } 
  
        return -1; 
    }

public static void main(String args[])
{
SinglyLinkedList list1=new SinglyLinkedList();
SinglyLinkedList list2=new SinglyLinkedList();
    
Scanner sc=new Scanner(System.in);

int n;
n=sc.nextInt();
for(int i=0;i<n;i++)
{
int d=sc.nextInt();
list1.addLast(d);
}

    n=sc.nextInt();
for(int i=0;i<n;i++)
{
int d=sc.nextInt();
list2.addLast(d);
}

    list2.head.next.next=list1.head.next.next.next;
    
   display(list1);
    display(list2);
 
 Merge_Point(list1.head,list2.head);       

}
}