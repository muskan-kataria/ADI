import java.util.*; 
import java.util.Stack;

class MyStack 
{ 
    Stack<Integer> s; 
    Integer minEle; 

    MyStack() { s = new Stack<Integer>(); } 
 
    void getMin() 
    { 
        if (s.isEmpty()) 
            System.out.println("Stack is empty"); 

        else
            System.out.println("Minimum Element in the " + 
                               " stack is: " + minEle); 
    } 

 
    void pop() 
    { 
        if (s.isEmpty()) 
        { 
            System.out.println("Stack is empty"); 
            return; 
        } 
  
        System.out.print("Top Most Element Removed: "); 
        Integer t = s.pop(); 

        if (t < minEle) 
        { 
            System.out.println(minEle); 
            minEle = 2*minEle - t; 
        } 
  
        else
            System.out.println(t); 
    } 
  
 
    void push(Integer x) 
    { 
        if (s.isEmpty()) 
        { 
            minEle = x; 
            s.push(x); 
                  
        System.out.println("Number Inserted: " + x); 
            return; 
        } 
  
   
        if (x < minEle) 
        { 
            s.push(2*x - minEle); 
     
            minEle = x; 
        } 
  
        else
            s.push(x); 
  
        System.out.println("Number Inserted: " + x); 
    } 
}
  

public class MinInStack 
{ 
    public static void main(String[] args) 
    { 
        MyStack s = new MyStack(); 
        s.push(1); 
        s.push(2); 
          s.push(3); 
        s.push(-1);
          s.push(4);  
        s.getMin();
        
        s.pop();
        s.pop();
        
        s.getMin();
         
    } 
} 
