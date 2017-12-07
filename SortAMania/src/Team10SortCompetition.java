import java.util.Random;

public class Team10SortCompetition extends SortCompetition{
	public static void main(String[] args)
	{
		//CHALLENGE ONE
		System.out.println();
		System.out.print("CHALLENGE ONE");
		int[] testOne = new int[10000];
		for (int i=0; i<testOne.length; i++)
		{
			testOne[i] = (int) Math.floor(Math.random()*10001);
		}
		long startTimeOne = System.nanoTime();
		int medianOne = challengeOne(testOne);
		long endTimeOne = System.nanoTime();
		long timeOne = endTimeOne-startTimeOne;
		for (int x : testOne)
		{
			System.out.print("["+x+"]");
		}
		System.out.println();
		System.out.println("Time in nanoseconds: "+timeOne);
		System.out.println("Median is "+medianOne);
		
		//CHALLENGE TWO
		System.out.println("CHALLENGE TWO");
		String[] testTwo = new String[10000];
		for (int i = 0; i < testTwo.length;i++) 
		{
			String s = "";
			for (int j = 0; j < 5; j++)
			{
				Random r = new Random();
				char c = (char)(r.nextInt(26)+'a');
				s = s+c;
			}
			testTwo[i] = s;
		}
		long startTimeTwo = System.nanoTime();
		System.out.println(testTwo[0]);
		int medianTwo = challengeTwo(testTwo,testTwo[0]);
		System.out.println(testTwo[medianTwo]);
		long endTimeTwo = System.nanoTime();
		long timeTwo = endTimeTwo-startTimeTwo;
		for(String x : testTwo)
		{
			System.out.print("["+x+"]");
		}
		System.out.println();
		System.out.println("Time in nanoseconds: "+timeTwo);
		System.out.println("Found at "+medianTwo);
	
		//CHALLENGE THREE
		System.out.println("CHALLENGE THREE");
		int[] testThree = new int[10000];
		for (int i=0; i<testThree.length; i++)
		{
			testThree[i] = (int) Math.floor(Math.random()*10001);
		}
		long startTimeThree = System.nanoTime();
		int medianThree = challengeThree(testThree);
		long endTimeThree = System.nanoTime();
		long timeThree = endTimeThree-startTimeThree;
		for(int x: testThree)
		{
			System.out.print("["+x+"]");
		}
		System.out.println();
		System.out.println("Time in nanoseconds: "+timeThree);
		System.out.println("Median is "+medianThree);
	
		//CHALLENGE FOUR
		System.out.println("CHALLENGE FOUR");
		int[][] testFour = new int[1000][1000];
		for(int i=0; i<testFour.length; i++)
		{
			for(int j=0; j<testFour[i].length; j++)
			{
				testFour[i][j] = (int) Math.floor(Math.random()*10001);
			}
		}
		long startTimeFour = System.nanoTime();
		int medianFour = challengeFour(testFour);
		long endTimeFour = System.nanoTime();
		long timeFour = endTimeFour-startTimeFour;
		for(int[] x : testFour)
		{
			for(int y : x)
			{
				System.out.print("["+y+"]");
			}
			System.out.println();
		}
		System.out.println("Time in nanoseconds: "+timeFour);
		System.out.println("Median is "+medianFour);
		

	}
	
	public int challengeOne(int[] arr)
	{
		insertionSort(arr);
		return findMedian(arr);
	}
	
	public int challengeTwo(String[] arr, String x)
	{
		bubbleSort(arr);
		return containsString(arr,x);
	}
	
	public int challengeThree(int[] arr)
	{
		bubbleSort(arr);
		return findMedian(arr);
	}
	
	public int challengeFour(int[][] arrMulti)

	public int challengeFive(Comparable[] arr, Comparable query)
	{
		
	}
	{
		double[] medians = new double[arrMulti.length];
		for (int i=0; i<arrMulti.length; i++)
		{
			insertionSort(arrMulti[i]);
			medians[i]=findMedian(arrMulti[i]);
		}
		
		for (int i=0; i<medians.length-1; i++)
		{
				if (medians[i+1]<medians[i])
				{
					boolean foundPlace= false;
					int j = i;
					while(!foundPlace)
					{
						if(j==-1)
						{
							foundPlace=true;
						}

						else if(medians[j]<medians[i+1])
						{
							foundPlace=true;
						}

						else
						{
							j--;
						}
					}
					
					double dummy= medians[i+1];
					int[] dummy1=arrMulti[i+1];
					moveOver(medians, j+1,i+1);
					moveOver(arrMulti,j+1,i+1);
					medians[j+1]= dummy;
					arrMulti[j+1]=dummy1;
				}
		}
		return findMedian(medians);

	}
	
	/*
	 * Find Median
	 * Finds the median of an array of integers.
	 * @param double[] arr
	 * @return double
	 */
	public static int findMedian(double[] arr)
	{
		if (arr.length % 2==0)
		{
			return (int) ((arr[arr.length/2]+arr[(arr.length/2)-1])/2);
		}
		return (int) arr[(arr.length-1)/2];
	}

	/*
	 * Find Median
	 * Finds the median of an array of integers.
	 * @param int[] arr
	 * @return double
	 */
	public static int findMedian(int[] arr)
	{
		if (arr.length % 2==0)
		{
			return (int)(arr[arr.length/2]+arr[(arr.length/2)-1])/2;
		}
		return (int)arr[(arr.length-1)/2];
	}
	
	/*
	 * Bubble Sort (integers)
	 * Sorts an array of integers by swapping adjacent numbers when needed until there is no more
	 * swaps needed.
	 * @param int[] list1
	 * @return void
	 */
	public static void bubbleSort(int[] list1)
	{
		boolean swapZero = false;
		while(!swapZero)
		{
			int numSwap=0;
			for(int i=0; i<list1.length-1; i++)
			{
				
				if(list1[i]>list1[i+1])
				{
					int dummy= list1[i];
					list1[i]=list1[i+1];
					list1[i+1]=dummy;
					numSwap++;
					
				}
			}
			if(numSwap==0)
			{
				swapZero=true;
			}
		}
	}

	
	/*
	 * Insertion Sort 
	 * Sorts an array of integers by taking each element from the array and adding it to the front of the array
	 * in the correct order.
	 * @param int[] list1
	 * @return void
	 */
	public static void insertionSort(int[] list1)
	{
		for (int i=0; i<list1.length-1; i++)
		{
				if (list1[i+1]<list1[i])
				{
					boolean foundPlace= false;
					int j = i;
					while(!foundPlace)
					{
						if(j==-1)
						{
							foundPlace=true;
						}

						else if(list1[j]<list1[i+1])
						{
							foundPlace=true;
						}

						else
						{
							j--;
						}
					}
					
					int dummy= list1[i+1];
					moveOver(list1, j+1,i+1);
					list1[j+1]= dummy;
				}
			}
	}

	/*
	 * Move Over function
	 * Moves each item in the array over one position in the given interval.
	 * @param double[] array
	 * @param int x starting position of interval inclusive
	 * @param int y ending position of interval inclusive
	 * @return void
	 */
	public static void moveOver(int[][]array, int x, int z)
	{
		int[] nextNum= array[x];
		for(int y=x; y<z; y++)
		{
			int[] dummy = array[y+1];
			array[y+1]= nextNum;
			nextNum = dummy;
		}
	}
	
	/*
	 * Move Over function
	 * Moves each item in the array over one position in the given interval.
	 * @param double[] array
	 * @param int x starting position of interval inclusive
	 * @param int y ending position of interval inclusive
	 * @return void
	 */
	public static void moveOver(double[]array, int x, int z)
	{
		double nextNum= array[x];
		for(int y=x; y<z; y++)
		{
			double dummy = array[y+1];
			array[y+1]= nextNum;
			nextNum = dummy;
		}
	}
	
	/*
	 * Move Over function
	 * Moves each item in the array over one position in the given interval.
	 * @param int[] array
	 * @param int x starting position of interval inclusive
	 * @param int y ending position of interval inclusive
	 * @return void
	 */
	public static void moveOver(int[]array, int x, int z)
	{
		int nextNum= array[x];
		for(int y=x; y<z; y++)
		{
			int dummy = array[y+1];
			array[y+1]= nextNum;
			nextNum = dummy;
		}
	}
	public static  int containsString(String[] list1, String value)
	{
		for(int i=0; i<list1.length; i++)
		{
			if(list1[i]==value)
				return i;
		}
		return -1;
		
    }
	public static void bubbleSort(String[] list1)
	{
		boolean swapZero = false;
		while(!swapZero)
		{
			int numSwap=0;
			for(int i=0; i<list1.length-1; i++)
			{
				
				if((list1[i].compareToIgnoreCase(list1[i+1]))>0)
				{
					String dummy= list1[i];
					list1[i]=list1[i+1];
					list1[i+1]=dummy;
					numSwap++;
					
				}
			}
			if(numSwap==0)
			{
				swapZero=true;
			}
		}
	}
}
