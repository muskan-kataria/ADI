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
    Node tail=null;
    
public void addLast(int e) {                
    Node newest = new Node(e,null);   
    if (head==null)
    {head = newest;
    
    }
         else
         {
             Node curr=head;
             while(curr.next!=null)
             {
                 curr=curr.next;
               
             }
             curr.next=newest;
         }
  tail=newest;
  }
}
class Loop
{
   
   public static int find_loop(Node head)
   {
    Node slow = head, fast = head; 
        while (slow != null && fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
            if (slow == fast) { 
                removeLoop(slow,head); 
                return 1; 
            } 
        } 
        return 0; 
   }
    public static void removeLoop(Node loop, Node head) 
    { 
        Node ptr1 = null, ptr2 = null; 
  
        ptr1 =head; 
        while (true) { 
  
            ptr2 = loop; 
            while (ptr2.next != loop && ptr2.next != ptr1) { 
                ptr2 = ptr2.next; 
            } 

            if (ptr2.next == ptr1) { 
                break; 
            } 
 
            ptr1 = ptr1.next; 
        } 
  
        ptr2.next = null; 
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
    
  list.tail.next=list.head.next;  

 find_loop(list.head); 
    
    
    display(list);

}
}