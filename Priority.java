import java.util.Scanner;

public class Priority {
	public static void main(String args[])
	{
		Scanner sn=new Scanner(System.in);
		System.out.print("Enter No of processes :");
		int n=sn.nextInt();
		
		int process[]=new int[n];
		int priority[]=new int[n];
		int arrival[]=new int[n];
		int brust[]=new int[n];
		int completion[]=new int[n];
		int WT[]=new int[n];
		int TAT[]=new int[n];
		int sum=0;
				float totalaroundtime=0,waittime=0;
		
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter Process "+(i+1)+"Brust Time :");
			brust[i]=sn.nextInt();
			
			System.out.print("Enter Process "+(i+1)+"Priority  :");
			priority[i]=sn.nextInt();
			
			process[i]=i+1;
		}
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(priority[i]<priority[j])
				{
					int temp=priority[i];
					priority[i]=priority[j];
					priority[j]=temp;
					
					temp=process[i];
					process[i]=process[j];
					process[j]=temp;
					
					temp=brust[i];
					brust[i]=brust[j];
					brust[j]=temp;
					
				}
			}
			
		}
			for(int i=0;i<n;i++)
			{
				sum=sum+brust[i];
				completion[i]=sum;
			}
			
			System.out.print("\n\nPriority \tProcess \tBrusttime \tCompletion \tWT \tTAT");
			for(int i=0;i<n;i++)
			{
				TAT[i]=completion[i]-arrival[i];
				totalaroundtime=totalaroundtime+TAT[i];
				
				WT[i]=TAT[i]-brust[i];
				waittime=waittime+WT[i];
				
				System.out.print("\n"+priority[i]+"\t\t"+process[i]+"\t\t"+brust[i]+"\t\t"+completion[i]+"\t\t"+WT[i]+"\t\t"+TAT[i]);
			}
			System.out.print("\n\nAvergae Turn Around Time :"+(totalaroundtime/n));
			System.out.print("\nAvergae Wait Time :"+(waittime/n));
			
			
		}
	}

