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
class ListPalin
{
       
public static Node reverse(Node head)
{
       Node prev=null,curr=head,next=null;
    while(curr!=null)
    {
    next=curr.next;
    curr.next=prev;
    prev=curr;
    curr=next;
        
    }
    head=prev;
    return head;
    
 }
    
    public static int check_palin(Node l1,Node l2)
    {
        if(l1==null)
            return 1;
        
        while(l1!=null)
        {
            if(l1.data==l2.data)
            {
                
            }
            else
                return 0;
            
            l1=l1.next;
            l2=l2.next;
        }
        return 1;
    }

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

public static void main(String args[])
{
SinglyLinkedList list=new SinglyLinkedList();
SinglyLinkedList revlist=new SinglyLinkedList();
    
Scanner sc=new Scanner(System.in);

int n;
n=sc.nextInt();
for(int i=0;i<n;i++)
{
int d=sc.nextInt();
list.addLast(d);
}


   display(list);
    
  revlist.head=reverse(list.head);
  int res=check_palin(list.head,revlist.head);
    if(res==1)
        System.out.println("yes");
    else
         System.out.println("no");  
        

}
}