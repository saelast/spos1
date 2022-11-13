import java.util.ArrayList;
import java.util.Scanner;

public class LRU
{
	public static void main(String agrs[])
	{
		Scanner sn=new Scanner(System.in);
		
		System.out.print("\nEnter How Many Frames You Want :");
		int frame=sn.nextInt();
		
		System.out.print("How Many Pages You Want :");
		int pg=sn.nextInt();
		
		System.out.print("\nEnter Pages");
		int pages[]=new int[pg];
		for(int i=0;i<pg;i++)
		{
			pages[i]=sn.nextInt();
			
		}
		
		ArrayList<Integer> s=new ArrayList<>(frame);
		int count=0,pagefault=0;
		for(int i:pages)
		{
			if(!s.contains(i)) 
			{
				if(s.size()==frame)
				{
					s.remove(0);
					s.add(frame-1,i);
				}
				else
				{
					s.add(count,i);
					count++;
				}
					
				pagefault++;
				
			}else
			{
				s.remove((Object)i);
				s.add(s.size(),i);
			}
		}
		System.out.print("Page Fault :"+pagefault);
		
	}
}