 /* Miriam Monroe and Ramisha Sarwar
 * Sort-a-Mania 
 */

//import Utilities;

public class Team15SortCompetition extends SortCompetition
{

	public static void main (String[] args)
	{
		/*
		String[] list = {"Apple", "Zebra", "Grape", "Quart", "Phone"};
		System.out.println(challengeTwo(list, "Grape"));
		*/
		
		/*
		int[] x = {111, 2, 5, 70, 8, 3,};
		int[] y = {20, 2, 56, 72, 8, 32,};
		int [] z = {101, 22, 5, 7, 8, 31,};
		int[][] stuff = {x, y, z};
		System.out.println(challengeFour(stuff));
		*/
	}
	
	public String greeting()
	{
		String greeting = "Hello this is Team 15. :)";
		return greeting;
	}
	
	public int challengeOne(int[] list)
	{
		int median = 0;
		Utilities.bubbleSort(list);
		median = Utilities.median(list);
		return median;
	}
	
	public int challengeTwo(String[] arr, String str)
	{
		int index = 0;
		String[] things = Utilities.mergeSort(arr);
		index = Utilities.binarySearch(things, 0, arr.length-1, str);
		
		return index;
	}
	
	public int challengeThree(int[] list)
	{
		Utilities.bubbleSort(list);
		int median = Utilities.median(list);
		return median;
	}
	
	public int challengeFour(int[][] arr)
	{
		int[] medians = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++)
		{
			Utilities.bubbleSort(arr[i]);
			medians[i] = Utilities.median(arr[i]);
		}
		
		Utilities.bubbleSort(medians);
		return Utilities.median(medians);

	}
	public int challengeFive(Comparable[] arr, Comparable query)
	{
		return -1;
	}
	
	/*



	@Override
	public int compareTo(Object o)
	{
		if(this < o)
		{
			return -1;
		}
		
		if(this > o)
		{
			return 1;
		}
		
		if(this == o)
		{
			return 0;
		}
	}
	*/
	
}
