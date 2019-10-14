import java.util.*;
import java.util.LinkedList;
class IntervalScheduling
{
	char id;
int start;
int end;
	
	IntervalScheduling(char c,int s,int e)
	{
		id=c;
		start=s;
		end=e;
	}
	
	public static void Schedule(IntervalScheduling interval[],int n)
	{
		int i,j;
			for(i=0;i<n;i++)
			{
				for(j=i+1;j<n;j++)
				{
					if(interval[i].end<interval[j].end)
					{
						IntervalScheduling temp;
						temp=interval[i];
						interval[i]=interval[j];
						interval[j]=temp;
						
					}
				}
			}
		
		i=interval[0].end;
		LinkedList<IntervalScheduling>  res=new LinkedList<>();
		res.add(interval[0]);
		for( j=1;j<n;j++){
			if(interval[j].start>=i){
				res.add(interval[j]);
				i=interval[j].end;
				
			}
		}
		for(IntervalScheduling k : res)
			System.out.println(k.id);
		
	}
public static void main(String args[])
{
IntervalScheduling interval[]=new IntervalScheduling[5];
	interval[0]=new IntervalScheduling('A',0,6);
	interval[1]=new IntervalScheduling('B',1,4);
	interval[2]=new IntervalScheduling('C',3,5);
	interval[3]=new IntervalScheduling('D',3,8);
	interval[4]=new IntervalScheduling('E',4,7);
	
	Schedule(interval,5);
	
}
}