#include<iostream>
using namespace std;

void Heapify(int a[],int i,int size)
{
    int l,r,max,c;
    l=2*i;
    r=2*i+1;
    if(l<size&&a[l]>a[i])
    max=l;
    else
    max=i;
    if(r<size&&a[r]>a[i])
    max=r;
    
    if(max!=i)
    {
        c=a[i];
        a[i]=a[max];
        a[max]=c;
        
        Heapify(a,max,size);
    }
}


void HeapSort(int a[],int n)
{
    if(n==0)
    return;
    
    int i,c;
    c=a[0];
        a[0]=a[n-1];
        a[n-1]=c;
        
        n--;
        
        for(i=n/2;i>=0;i--)
{
  Heapify(a,i,n);  
}
  HeapSort(a,n);  
    
}

void display(int a[],int n)
{
    int i;
    for(i=0;i<n;i++)
    cout<<a[i]<<" ";
}

void BuildHeap()
{
int n,i;
cin>>n;
int a[n];

for(i=0;i<n;i++)
cin>>a[i];

for(i=n/2;i>=0;i--)
{
  Heapify(a,i,n);  
}
//display(a,n);
cout<<'\n';
HeapSort(a,n);

display(a,n);
}


int main()
{
   BuildHeap();
   return 0;
}