import java.util.Scanner;

class Knapsack{
	public  static void main(String args[]){
		float profit[]={10,5,15,7,6,18,3};
		float weight[]={2,3,5,7,1,4,1};
		float pw[]=new float[7];
		
		for(int i=0;i<7;i++)
			pw[i]=(float)profit[i]/weight[i];
		
		float W=15;
		
		for(int i=0;i<6;i++){
			for(int j=0;j<6-i;j++){
				if(pw[j]>pw[j+1]){
					float temp=pw[j];
					pw[j]=pw[j+1];
					pw[j+1]=temp;
					
					 temp=profit[j];
					profit[j]=profit[j+1];
					profit[j+1]=temp;
					
					temp=weight[j];
					weight[j]=weight[j+1];
					weight[j+1]=temp;
				}
			}
		}

		float cprofit=0;
		for(int i=6;i>=0 && W!=0;i--){
			if(weight[i]<W){
				W-=weight[i];
				cprofit+=profit[i];
			}
			else{
				cprofit+=((W/weight[i])*profit[i]);
				W=0;
			}
		}
		System.out.println(cprofit);
	}
}