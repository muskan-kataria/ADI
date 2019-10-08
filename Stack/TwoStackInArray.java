import java.util.*;

class Stack
{
int size;
int arr[];
int top1,top2;
Stack(int n)
{
size=n;
arr=new int[n];
top1=-1;
top2=n;
}

void push1(int d)
{
if(top1<top2-1)
{
top1++;
arr[top1]=d;
}
else
{
System.out.println("stack overflow");
}
}

void push2(int d)
{
if(top1<top2-1)
{
top2--;
arr[top2]=d;
}
else
{
System.out.println("stack overflow");
}
}

int pop1()
{
if(top1>=0)
{
int x=arr[top1];
top1--;
return x;
}
else
{
System.out.println("stack underflow");
    System.exit(1);
}
    return 0;
}

int pop2()
{
if(top2<size)
{
int x=arr[top2];
top2++;
return x;
}
else
{
System.out.println("stack underflow");
       System.exit(1);
}
    return 0;
}


void display1()
{
System.out.println("stack1");
while(top1>=0)
{
System.out.print(" "+pop1());
}
System.out.println("");
}

void display2()
{
System.out.println("stack2");
while(top2<size)
{
System.out.print(" "+pop2());
}
System.out.println("");
}
}

class TwoStackInArray
{
public static void main(String args[])
{
Stack s=new Stack(5);

s.push1(1);
s.push1(2);
s.push2(3);
s.push1(4);
s.push2(5);

s.display1();
s.display2();

}
}