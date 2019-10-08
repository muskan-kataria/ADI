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
class ListReverse
{
    
public static Node reverse_iteratively(Node head)
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
    
public static Node reverse_recursively(Node head)
{
 if(head==null||head.next==null)
     return head;
    
    Node node=reverse_recursively(head.next);
    head.next.next=head;
    head.next=null;
    return node;
     
     
}
    
public static Node reverse_usingstack(Node head)
{
    Stack <Node> s=new Stack<Node>();
    Node ptr=head;
    while(ptr.next!=null)
    {
        s.push(ptr);
        ptr=ptr.next;
    }
    head=ptr;
    
    while(!s.empty())
    {ptr.next=s.peek();
     ptr=ptr.next;
     s.pop();
    }
    ptr.next=null;
    return head;
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

Scanner sc=new Scanner(System.in);

int n;
n=sc.nextInt();
for(int i=0;i<n;i++)
{
int d=sc.nextInt();
list.addLast(d);
}
   display(list); 
  list.head=reverse_usingstack(list.head);
    System.out.println("after reverse:");
display(list);
}
}