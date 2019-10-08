import java.util.Stack;
class QueueUsingStack{
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
	int size=0;
	public void enqueue(int x){
		s1.push(x);
	}
	
	public void dequeue(){
		if(!s2.isEmpty())
			System.out.println("Element popped is: "+s2.pop());
		else{
while(!s1.isEmpty()){
        s2.push(s1.pop());
			}
		System.out.println("Element popped is : "+s2.pop());
		}
	}
		
	public static void main(String args[]){
		QueueUsingStack q=new QueueUsingStack();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
	}
}