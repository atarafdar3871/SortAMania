import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.InterruptedException;
import java.util.Comparator;

public class SortUtilities {
	
	private static long time;
	private static long [] avg;
	private static int count;
	
	public  int[] randomIntsArr(int num)
	{
		int [] arr = new int [num];
		while (num > 0)
		{
			num--;
			arr[num] = (int)(Math.random()*10000);
		}
		return arr;
	}
	
	public  int[][] randomIntsArr1(int num)
	{
		int [][] arr = new int[num][num];
		int i = 0;
		while (i < num)
		{
			arr[i] = randomIntsArr(num);
			i++;
		}
		return arr;
	}
	
	public  void startTime()
	{
		time = System.currentTimeMillis();
	}
	public  void stopTime()
	{
		time = System.currentTimeMillis() - time;
		avg[count] = time;
		count--;
		
	}
	
	public void printTime()
	{
		
		System.out.println(time + " milliseconds");
		
	}
	
	public  void setTest(int reps)
	{
		avg = new long[reps];
		count = reps - 1;
		
	}
	public double score(double[] times)
	{
		//Calculate standard deviation
		double sum = 0;
		double[] squareTimes = Arrays.copyOf(times, times.length);

		double mean = average(times);
		
		sum = 0;
		for (int i=0; i<times.length; i++)
		{

			sum += Math.pow((times[i] - mean),2.0); 
			
		}

		double stdDev = Math.sqrt(sum/times.length);
		
		//remove outliers
		for (int i = 0;i < times.length; i++)
		{
			if (times[i] > mean + (2*stdDev))
			{
				System.out.println("removing" + times[i]);
				times[i] = Double.NaN;
			}
			if (times[i] < mean - (2*stdDev))
			{				
				System.out.println("removing" + times[i]);
				times[i] = Double.NaN;
			}
		}
		sum  = average(times);
		System.out.println("\nAverage Time: " + sum +" milliseconds");
		return sum;

	}
	public double average(double[] times)
	{
		double sum = 0;
		for (double x : times)
		{
			if (x != Double.NaN)
			{
				sum += x;
			}

		}
		return sum/times.length;
	}

	public  String[] randomStringArr(int num, int length)
	{
		
		String [] arr = new String [num];
		while (num > 0)
		{
			int i = 0;
			String s = "";
			while (i < length)
			{
				char c = (char)((Math.random()*26)+97);
				s = s + c;
				i++;
			}
			num--;
			arr[num] = s;
		}
		return arr;
	}
	
	public  String[][] randomStringArr1(int num, int length)
	{
		
		String [][] arr = new String [num][num];
		while (num > 0)
		{
			num--;
			arr[num] = randomStringArr(num, length);
		}
		return arr;
	}
	
	public void checkTest1(int testArr[], int origArr[], int median)
	{
		System.out.println("Checking Test Results");
		Arrays.sort(origArr);
		
		if (Arrays.equals(testArr,origArr))
		{
			System.out.print("Sorted");
		}

		else
		{
			System.out.print("Unsorted : (");
		}

		if (median(origArr) == median)
		{
			System.out.print(" Median Correct ");
		}

		else
		{
			System.out.print(" Median Not Correct ");
		}
		pause(1000);
		
	}
	public void checkTest2(String testArr[], String origArr[], int index, String Key)
	{
		System.out.println("Checking Test Results");
		Arrays.sort(origArr);
		
		if (Arrays.equals(testArr,origArr))
		{
			System.out.println("\nSorted : )\n");
		}

		else
		{
			System.out.println("\nUnsorted : (\n");
		}

		if (Arrays.binarySearch(origArr, Key) == index)
		{
			System.out.println("\nIndex Correct : )\n");
		}

		else
		{
			System.out.println("\n Index Not Correct : (\n");
		}
		pause(1000);
	}
	public Generic[] randomGeneric(int x)
	{
		Generic[] arr = new Generic[x];
		
		for (int i = 0; i < x; i++)
		{
			arr[i] = new Generic();
		}
		return arr;
	}
	public void checkTest5(Generic testArr[], Generic origArr[], int index, Generic Key)
	{
		System.out.println("Checking Test Results");
		Arrays.sort(origArr);
		
		if (Arrays.equals(testArr,origArr))
		{
			System.out.println("\nSorted : )\n");
		}

		else
		{
			System.out.println("\nUnsorted : (\n");
		}

		if (Arrays.binarySearch(origArr, Key) == index)
		{
			System.out.println("\nIndex Correct : )\n");
		}

		else
		{
			System.out.println("\n Index Not Correct : (\n");
		}
		pause(1000);
	}
	public void checkTest3(int testArr[], int origArr[], int median)
	{
		System.out.println("Checking Test Results");
		Arrays.sort(origArr);
		
		if (Arrays.equals(testArr,origArr))
		{
			System.out.println("\nSorted : )\n");
			pause(100);
		}

		else
		{
			System.out.println("\nUnsorted : (\n");
			pause(100);
		}

		if (median(origArr) == median)
		{
			System.out.println("\nMedian Correct : )\n");
			pause(100);
		}
		else
		{
			System.out.println("\nMedian Not Correct : (\n");

		}
		pause(1000);
		
	}
	public void checkTest4(int[][] testArr, int [][] origArr, int median)
	{
		System.out.println("Checking Test Results");
		int [] medArr = new int[origArr.length];
		for (int i  = 0; i<origArr.length; i++)
		{
			medArr[i] = median(origArr[i]);
		}
		
		Arrays.sort(origArr, new Comparator<int[]>(){
			public int compare(int [] a, int [] b)
			{
				return median(a) - median(b);
			}
		});

		Arrays.sort(medArr);
		int temp = median(medArr);
		
		
		if (Arrays.equals(testArr,origArr))
		{
			System.out.println("\n Sorted : )\n");
		}
		else
		{
			System.out.println("\n Unsorted : (\n");
		}
		pause(100);
		if (temp == median)
		{
			System.out.println("\nMedian Correct : )\n");
		}
		else
		{
			System.out.println("\nMedian Not Correct : (\n");
			pause(1000);
		}
		
	}
	
	public void unSort(int[]arr)
	{
		int percent = (int)(Math.random()*10);
		int count = (arr.length*percent)/100;
		
		while (count > 0)
		{
			int spot = (int)(Math.random()*arr.length);
			int swap = (int)(Math.random()*arr.length);
			int i = arr[spot];
			arr[spot] = arr[swap];
			arr[swap] = i;
			count--;
		}
		
	}
	public int median (int [] arr)
	{
		if (arr.length % 2 == 1) return arr[(arr.length/2)];
		
		return ((arr[(arr.length/2)-1] + arr[(arr.length/2)])/2);
	}
	
	public void pause(long ms)
	{
		try 
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
		}
	}
	public void rollcall(ArrayList<SortCompetition> teams)
	{
		System.out.println("\n*******************************Bracket Update********************************");
		for (int i = 0; i < teams.size(); i++)
		{
			if (i == teams.size() - 1 && teams.size()%2 == 1)
			{
				System.out.println("\t\t\tBye: Team " + teams.get(i).getNum());
			}
			else if (i%2 == 0 )
			{
				System.out.print("\t\t\tTeam " + teams.get(i).getNum() + " V ");

			}
			else 
			{
				System.out.print("Team " + teams.get(i).getNum());
				System.out.println();
			}


		}
		System.out.println("*******************************Bracket Update********************************");
		pause(10000);
	}
	
	public void scramble(ArrayList<SortCompetition> teams)
	{
		int i = 0;
		while(i <  teams.size())
		{
			int rand = (int)(Math.random() * teams.size());
			SortCompetition temp = teams.remove(rand);
			teams.add(temp);
			i++;
		}
	}
}
	

