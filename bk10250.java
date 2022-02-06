package baekjoon;

import java.util.Scanner;

public class bk10250 {

	public static void main(String[] args) throws Exception {

		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int H=sc.nextInt();
			int W=sc.nextInt();
			int N=sc.nextInt();
			int CH=0,CW=1;
		
			for(int i =0; i<N;i++) {
				CH++;
				if(CH>H) {
					CH=1;
					CW++;
					continue;
				}
				
			}
			if(CW<10)
				System.out.printf("%d0%d%n",CH,CW);
			else
				System.out.printf("%d%d%n",CH,CW);
			
		
	}
		}

}
