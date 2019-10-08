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
class NthNode
{
    public static int find_nth(int n,Node head) 
    { 
        int len = 0; 
        Node temp = head; 
  

        while (temp != null) { 
            temp = temp.next; 
            len++; 
        } 

        if (len < n) 
            return 0; 
  
        temp = head; 
 
        for (int i = 1; i < len - n + 1; i++) 
            temp = temp.next; 
  
     return temp.data; 
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

n=sc.nextInt();
   display(list);
     System.out.println(n+"th node:");
   n=find_nth(n,list.head);
    System.out.println(n);
  

}
}