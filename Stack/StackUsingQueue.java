import java.util.*;
class StackUsingQueue{
	Queue<Integer> q1=new LinkedList<>();
	Queue<Integer> q2=new LinkedList<>();
	int size=0;
	public void push(int x){
		size++;
		q2.add(x);
		while(!q1.isEmpty()){
			q2.add(q1.peek());
			q1.remove();
		}
		Queue<Integer> q=q2;
		q2=q1;
		q1=q;
	}
	
	public void pop(){
		if(q1.isEmpty())
			return;
		System.out.println("Element popped is "+q1.remove());
		size--;
	}
	
	
	
	public static void main(String args[]){
		StackUsingQueue s=new StackUsingQueue();
		s.push(1);
		s.push(2);
		s.push(3);
        s.push(4);
        s.push(5);
        s.pop();
        s.pop();

	}
}