import java.util.Scanner;
/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Design a class JobScheduler to simulate FCFS (First Come First Serve) scheduling algorithm. 
FCFS means the process which arrives first, gets executed first. 

Assume that we are receiving a number of processes with their arrival time and burst time seconds in a two dimensional array as input.  For example:

[0][10]
[6][20]
[60][10]
[110][5]

Define methods to perform following operations: 

Calculate completion time for each process. 
Calculate waiting time for each process.
Calculate turn around time for each process.
Average waiting time of processes.
Maximum waiting time period for a process in queue.


Here we have simple formulae for calculating various times for given processes:

Completion Time: Time taken for the execution to complete, starting from arrival time of first process.
Turn Around Time: Time taken to complete after arrival. In simple words, it is the difference between the Completion time and the Arrival time.
Waiting Time: Total time the process has to wait before it's execution begins. It is the difference between the Turn Around time and the Burst time of the process.
Burst Time : Time required to execute a process.

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */



public class JobScheduler
{
	/* Process 
	 * process[n][0]-arrival time
	 * process[n][1]-burst time
	 * process[n][2]-waiting time
	 * process[n][3]-Completion time
	 * process[n][4]-turn around time
	*/
	static int process[][];
	/*
	 * variable for computation of maximum waiting time and average turn around time
	 */
	static int process_count=0;
	static int max_waiting=0;
	static int total_waiting=0;
	public static void main(String args[])
	{
		//fetchDetails(new int[][]{{0,10},{6,20},{60,10},{110,5}}); // Fetching process arrival and burst time
		//fetchDetails(new int[][]{{0,5},{0,10},{1,5},{10,2},{20,10}});// Case 2
		fetchDetails();
		calculate(); // Calculating other parameters from fetched details
		printDetails(); // Printing Details of various times related to process
	}
	
	// Taking input about the process arrival time and process burst time
	public static void fetchDetails(int arr[][])
	{
		process=new int[arr.length][5];
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
		 * Fetching can be stopped as soon as the user inputs negative value or number of processes mentioned by user are entered.
		 */
		System.out.println("Enter no of processes : ");
		int[][] arr=new int[scanner.nextInt()][2];
		int arrival;
		int burst;
		for(int n=0;n<arr.length;n++)
		{
			System.out.println("Enter arrival time for process "+(n+1));
			arrival=scanner.nextInt();
			System.out.println("Enter burst time for process "+(n+1));
			burst=scanner.nextInt();
			// Burst time can't be zero but arrival time for process can be zero
			if((arrival>=0 && burst>0))
			{
				arr[n][0]=arrival;
				arr[n][1]=burst;
			}
			else
			{
				scanner.close();
				break;
			}
		}
		fetchDetails(arr);
	}
	private static void calculate()
	{
		for(int n=0;n<process.length;n++)
		{
			/*
			 * Loop through array
			 */
			if(process[n][0]>=0)
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
			if(process[temp][0]>=0)
			{
				System.out.printf("|%5s\t|%5s\t|%5s\t|%5s\t|%5s\t|%5s\t|\n",temp+1,process[temp][0],process[temp][1],process[temp][2],process[temp][3],process[temp][4]);
			}
		}
		System.out.println("\nMaximum waiting time = "+(max_waiting));
		try
		{
			System.out.println("Average waiting time = "+(total_waiting/process_count));
		}
		catch(ArithmeticException e)
		{
			System.out.println("Average waiting time = "+0);
		}
	}
	
}
