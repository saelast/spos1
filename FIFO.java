import java.util.Scanner;

public class FIFO {
	public static void main(String args[]) {
		Scanner sn = new Scanner(System.in);

		System.out.print("Enter Frame Size :");
		int fr = sn.nextInt();
		int frame[] = new int[fr];

		System.out.print("Enter How Many Pages You Want to Enter :");
		int pg = sn.nextInt();
		int pages[] = new int[pg];

		System.out.print("Enter Pages You Want :");
		for (int i = 0; i < pg; i++) {
			pages[i] = sn.nextInt();
		}

		int hits = 0;
		int faults = 0;
		int j = 0;
		boolean check;

		for (int i = 0; i < fr; i++) {
			frame[i] = -1;
		}

		for (int i = 0; i < pg; i++) {
			check = false;

			for (int k = 0; k < fr; k++)
				if (frame[k] == pages[i]) {
					check = true;
					hits = hits + 1;
				}
			if (check == false) {
				frame[j] = pages[i];
				j++;
				if (j >= fr)
					j = 0;
				faults = faults + 1;

			}

		}

		System.out.print("Hits :" + hits + "\nFaults :" + faults);

	}
}
