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
class ListMiddle
{
    
public static int middle(Node head)
{
Node slow=head,fast=head;
    if(head!=null)
    {
    while(fast!=null&&fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
    
    }
        return slow.data; 
    }
   return 0;
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
  int middle=middle(list.head);
    System.out.println("middle:"+middle);

}
}