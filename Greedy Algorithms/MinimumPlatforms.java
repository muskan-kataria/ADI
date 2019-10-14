import java.util.Arrays;
class MinimumPlatforms
{
public static void main(String args[])
{
String[] arrival={"10:00","10:15","10:30","10:40"};
		String[] departure={"10:20","10:25","15:00","10:55"};
		
		String[][] result=new String[8][2];
		for(int i=0;i<4;i++)
		{
			result[i][0]=arrival[i];
			result[i][1]="A";
		}
		for(int i=0;i<4;i++)
		{
			result[i+4][0]=departure[i];
			result[i+4][1]="D";
		}
		
		for(int i=0;i<7;i++){
			for(int j=0;j<7-i;j++){
				if(result[j][0].compareTo(result[j+1][0])>0){
					String temp=result[j][0];
					result[j][0]=result[j+1][0];
					result[j+1][0]=temp;
					
					temp=result[j][1];
					result[j][1]=result[j+1][1];
					result[j+1][1]=temp;
				}
			}
		}
		int counter=0;
		int max=0;
		for(int i=0;i<8;i++){
			if(result[i][1]=="A"){
				counter++;
				if(max<counter)
					max=counter;
			}
			else
				counter--;
		}
	
			System.out.println(max);
}
}