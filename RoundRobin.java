import java.util.Scanner;

public class RoundRobin {
	public static void main(String args[])
	{
		Scanner sn=new Scanner(System.in);
		System.out.print("Enter How Many Processes You Want :");
		int n=sn.nextInt();
		
		int process[]=new int[n];
		int arrival[]=new int[n];
		int brust[]=new int[n];
		int completion[]=new int[n];
		int WT[]=new int[n];
		int TAT[]=new int[n];
		
		int oribrust[]=new int[n];
		int count,i,tq,temp,sum=0;
		float totalavgtime = 0,totalwaittime=0;
		
		for(i=0;i<n;i++)
		{
			System.out.print("Enter Process "+(i+1)+" brust time ");
			brust[i]=sn.nextInt();
			
			process[i]=i+1;
			oribrust[i]=brust[i];
			
		}
		
		System.out.print("Enter Time Quantum :");
		tq=sn.nextInt();
		
		while (true) {
		for(i=0,count=0;i<n;i++)
		{
			temp=tq;
			if(brust[i]==0)
			{
				count++;
				continue;
			}
			
			if(brust[i]>tq)
			{
				brust[i]=brust[i]-tq;
			}
			else if(brust[i]>=0)
				{
					temp=brust[i];
					brust[i]=0;
					count++;
				}
			
			sum=sum+temp;
			completion[i]=sum;
			
			
		}
		if(n==count)
		{
			break;
		}
		}
		System.out.print("\nProcess\t      Burst Time\t       completion\t		Turnaround Time          Waiting Time\n");
		
		for(i=0;i<n;i++)
		{
			TAT[i]=completion[i]-arrival[i];
			totalavgtime=totalavgtime+TAT[i];
			
			WT[i]=TAT[i]-oribrust[i];
			totalwaittime=totalwaittime+WT[i];
			
			System.out.print("\n " + (i + 1) + "\t\t " +oribrust[i] + "\t\t\t " +completion[i] +"\t\t\t"+ TAT[i] + "\t\t\t " + WT[i] + "\n");
		}
		System.out.println("\nAverage waiting Time = " +(totalwaittime / n));
		System.out.println("\nAverage turnaround time = " +(totalavgtime / n));
	}
	}
	

