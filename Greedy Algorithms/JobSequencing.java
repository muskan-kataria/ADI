import java.util.*;

class JobSequencing
{
	char id;
	int deadline;
	int profit;
	
	JobSequencing(char c,int d,int p)
	{
		id=c;
		deadline=d;
		profit=p;
	}
	
	public static void JobScheduling(JobSequencing job[],int n)
	{
		int i,j;
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(job[i].profit>job[j].profit)
				{
					JobSequencing temp;
					temp=job[i];
					job[i]=job[j];
					job[j]=temp;
				}
			}
		}
		
//		for(i=0;i<n;i++)
//			System.out.print(" "+job[i].id);
		
		int result[]=new int[n];
		boolean slot[]=new boolean[n];
		 for (i=0; i<n; i++) 
        slot[i] = false;
		
		for(i=0;i<n;i++)
		{
			for(j=(n<job[i].deadline?n:job[i].deadline)-1;j>=0;j--)
			{
				if(slot[j]==false)
				{
					result[j]=i;
					slot[j]=true;
					break;
				}
			}
		}
		
		System.out.print("job sequencing order: ");
		for(i=0;i<n;i++)
		{
			if(slot[i]==true)
				System.out.print(" "+job[result[i]].id);
		}
		
		
	}
public static void main(String args[])
{
JobSequencing job[]=new JobSequencing[5];
	job[0]=new JobSequencing('a',2,100);
	job[1]=new JobSequencing('b',1,19);
	job[2]=new JobSequencing('c',2,27);
	job[3]=new JobSequencing('d',1,25);
	job[4]=new JobSequencing('e',3,15);
	
	JobScheduling(job,5);
}
}