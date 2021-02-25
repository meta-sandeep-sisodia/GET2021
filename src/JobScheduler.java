import java.util.Scanner;


public class JobScheduler
{
	// Global variable deceleration
	/* 
	 * process[n][0]-arrival time
	 * process[n][1]-burst time
	 * process[n][2]-waiting time
	 * process[n][3]-Completion time
	 * process[n][4]-turn around time
	*/
	static int process[][]=new int[10][5]; // 2D array of size 10 X 5 -flexible as per the requirement
	/*
	 * variable for computation of maximum waiting time and average turn around time
	 */
	static int process_count=0;
	static int max_waiting=0;
	static int total_waiting=0;
	public static void main(String args[])
	{
		//fetchDetails(new int[][]{{0,10},{6,20},{60,10},{110,5}}); // Fetching process arrival and burst time
		fetchDetails();
		calculate(); // Calculating other parameters from fetched details
		printDetails(); // Printing Details of various times related to process
	}
	
	// Taking input about the process arrival time and process burst time
	public static void fetchDetails(int arr[][])
	{
		/*
		 * For taking input in form of 2D array of size N X 2
		 * 0 - arrival time
		 * 1 - burst time
		 */
		for(int n=0;n<arr.length;n++)
		{
			process[n][0]=arr[n][0];
			process[n][1]=arr[n][1];
		}
	}
	public static void fetchDetails()
	{
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter arrival time or burst time in negative to finish entering data");
		/*
		 * For taking input from the user
		 * Fetching can be stopped as soon as the user inputs negative value
		 */
		int arrival;
		int burst;
		for(int n=0;n<process.length;n++)
		{
			System.out.println("Enter arrival time for process "+(n+1));
			arrival=scanner.nextInt();
			System.out.println("Enter burst time for process "+(n+1));
			burst=scanner.nextInt();
			// Burst time can't be zero but arrival time for process 1 can be zero
			if((arrival>0 && burst>0)||(arrival>=0 && burst>0 && n==0))
			{
				process[n][0]=arrival;
				process[n][1]=burst;
			}
			else
			{
				scanner.close();
				break;
			}
		}
	}
	private static void calculate()
	{
		for(int n=0;n<process.length;n++)
		{
			/*
			 * Loop through array, end of process can be stated if process arrival time is 0
			 * except for first process
			 */
			if(n==0||process[n][0]!=0)
			{
			// waiting time = completion time(previous process) - arrival time
			// waiting time will only be present if other process is executing at arrival of process
			if((n==0?0:process[n-1][3])>process[n][0])
				{
					process[n][2]=Math.abs((n==0?0:process[n-1][3])-process[n][0]);
				}
			// Maximum waiting time computation
			max_waiting = process[n][2]>max_waiting?process[n][2]:max_waiting;
			total_waiting+=process[n][2];
			// completion time = arrival time + burst time + waiting time
			process[n][3]=process[n][0]+process[n][1]+process[n][2];
			
			// turn around time = completion - arrival
			process[n][4]=process[n][3]-process[n][0];
			process_count++;
			}
		}
	}
	public static void printDetails()
	{
		/*
		 * Printing the calculated time for every processes
		 * printf is used so table does not distort due to variations in values
		 */
		System.out.println("AT - arrival time");
		System.out.println("BT - burst time");
		System.out.println("WT - waiting time");
		System.out.println("CT - completion time");
		System.out.println("TAT - turn around time\n");
		System.out.printf("|%5s|%5s\t|%5s\t|%5s\t|%5s\t|%5s\t|\n","Process","AT","BT","WT","CT","TAT");
		System.out.println("=================================================");
		for(int temp=0;temp<process.length;temp++)
		{
			if(temp==0||process[temp][0]!=0)
			{
				System.out.printf("|%5s\t|%5s\t|%5s\t|%5s\t|%5s\t|%5s\t|\n",temp+1,process[temp][0],process[temp][1],process[temp][2],process[temp][3],process[temp][4]);
			}
		}
		System.out.println("\nMaximum waiting time = "+(max_waiting));
		System.out.println("Average waiting time = "+(total_waiting/process_count));
	}
	
}
