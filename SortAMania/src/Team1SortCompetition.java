import java.util.Arrays;

public class Team1SortCompetition extends SortCompetition {
	
	public  int challengeOne(int[] nums) //Counting Sort
	{
		countingSort(nums);
		return medianFixed(nums);
	}
	public int challengeTwo(String[] strings, String query) //Counting Sort
	{
		strings = TimSorts(strings);
		return(binarySearchTim(strings,query,0,strings.length));
	}
	public int challengeThree(int[] num) //Insertion Sort
	{
		insertionSort(num);
		return medianFixed(num);
	}
	public int challengeFour(int[][] nums) //Tim Sort
	{
		int[] associatedArray = new int[nums.length];
		for(int i = 0; i < nums.length; i++)
		{
			TimSortsOP(nums[i]);
			associatedArray[i] = medianFixed(nums[i]);
		}
		insertionSort(associatedArray,nums);
		return median(   medianFixed(	nums[	((int)nums.length/2)] ), medianFixed( nums[ ((int)nums.length/2)+1] )); 
	}
	public int challengeFive(Comparable[] arr, Comparable query) { //Tim Sort
		TimSortsOP(arr);
		return(binarySearchTim(arr,query,0,arr.length));
	}
	private static void insertionSort(int [] list1)
	{
		if(list1.length == 0)
		{
			return;
		}
		int fhp = 1;
		if(list1[0] > list1[1])
		{
			swapIntArray(list1,0,1);
		}
		while(true)
		{
			if(fhp >= list1.length-1)
			{
				break;
			}
			if(list1[fhp] <= list1[fhp+1])
			{
				fhp = fhp+1;
				continue;
			}
			if(list1[fhp] > list1[fhp+1])
			{
					swapIntArray(list1,fhp,fhp+1);
					int num = fhp;
					for(int i = fhp-1; i > -1; i--)
					{
						if(list1[i] <= list1[num])
						{
							break;
						}
						else
						{
							swapIntArray(list1,i,num);
							num = num -1 ;
						}
					}
					fhp = fhp + 1;
					continue;
			}	
		}
	}
	public static void insertionSortCom(Comparable [] list1)
	{
		int fhp = 1;
		if(list1[0].compareTo(list1[1]) > 0)
		{
			swapComparableArray(list1,0,1);
		}
		while(true)
		{
			if(fhp >= list1.length-1)
			{
				break;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) <= 0)
			{
				fhp = fhp+1;
				continue;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) > 0)
			{
					swapComparableArray(list1,fhp,fhp+1);
					int num = fhp;
					for(int i = fhp-1; i > -1; i--)
					{
						if(list1[i].compareTo(list1[num]) <= 0)
						{
							break;
						}
						else
						{
							swapComparableArray(list1,i,num);
							num = num -1 ;
						}
					}
					fhp = fhp + 1;
					continue;
			}	
		}
	}
	//Overloaded
	private static void insertionSort(int [] list1,int[][] nums)
	{
		if(list1.length == 0)
		{
			return;
		}
		int fhp = 1;
		if(list1[0] > list1[1])
		{
			swapIntArray(list1,0,1);
			swapArrayArray(nums,0,1);
		}
		while(true)
		{
			if(fhp >= list1.length-1)
			{
				break;
			}
			if(list1[fhp] <= list1[fhp+1])
			{
				fhp = fhp+1;
				continue;
			}
			if(list1[fhp] > list1[fhp+1])
			{
					swapIntArray(list1,fhp,fhp+1);
					swapArrayArray(nums,fhp,fhp+1);
					int num = fhp;
					for(int i = fhp-1; i > -1; i--)
					{
						if(list1[i] <= list1[num])
						{
							break;
						}
						else
						{
							swapIntArray(list1,i,num);
							swapArrayArray(nums,i,num);
							num = num -1 ;
						}
					}
					fhp = fhp + 1;
					continue;
			}	
		}
	}
	private static void countingSort(int[] array) {
		int[] hashedArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			hashedArray[array[i]] += 1;
		}
		
		for(int j = 1; j < hashedArray.length; j++) {
			hashedArray[j] += hashedArray[j - 1];
		}
		int count = 0;
		int numcount = 0;
		int startposition = 0;
		while(count < array.length) {
			for(int z = startposition; z < hashedArray[numcount]; z++) {
				array[count] = numcount;
				count++;
			}
			startposition = hashedArray[numcount];
			numcount++;
		}
	}
	public static int[] TimSortsOP(int[] nums)
	{
		if(nums.length < 8)
		{
			insertionSort(nums);
			return nums;
		}
		else
		{
			int half = (nums.length/2 );
			int[] oneHalf = Arrays.copyOfRange(nums, 0, half);
			int[] otherHalf = Arrays.copyOfRange(nums, half, nums.length);
			return mergeIntOptimized(  TimSortsOP( oneHalf ), TimSortsOP( otherHalf));		
		}
	}
	public static Comparable[] TimSortsOP(Comparable[] nums)
	{
		if(nums.length < 8)
		{
			insertionSortCom(nums);
			return nums;
		}
		else
		{
			int half = (nums.length/2 );
			Comparable[] oneHalf = Arrays.copyOfRange(nums, 0, half);
			Comparable[] otherHalf = Arrays.copyOfRange(nums, half, nums.length);
			return mergeComOptimized(  TimSortsOP( oneHalf ), TimSortsOP( otherHalf));		
		}
	}
	private static Comparable[] mergeComOptimized(Comparable[] nums1, Comparable[] nums2) {
		Comparable[] result = new Comparable[nums1.length+nums2.length];
		int onePosition = 0;
		int twoPosition = 0;
		while(true)
		{
			if(onePosition > nums1.length-1) //when all of list1 is in the results array
			{
				for(int i = twoPosition; i < nums2.length; i++)
				{
					result[nums1.length+i] = nums2[i];
				}
				break;
			}
			if(twoPosition > nums2.length-1) //when all of list2 is in the results array
			{
				for(int i = onePosition; i < nums1.length; i++)
				{
					result[nums2.length+i] = nums1[i];
				}
				break;
			}
			if(  nums1[onePosition].compareTo(nums2[twoPosition]) < 0) // if list1 is lower
			{
				result[onePosition+twoPosition] = nums1[onePosition];
				onePosition++;
				continue;
			}
			else if(  nums1[onePosition].compareTo(nums2[twoPosition]) > 0) // if list2 is lower
			{
				result[onePosition+twoPosition] = nums2[twoPosition];
				twoPosition++;
				continue;
			}
			else
			{
				result[onePosition+twoPosition] = nums2[twoPosition];
				twoPosition++;
				continue;
			}
		}
		return result;
	}
	private static int[] mergeIntOptimized(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length+nums2.length];
		int onePosition = 0;
		int twoPosition = 0;
		while(true)
		{
			if(onePosition > nums1.length-1) //when all of list1 is in the results array
			{
				for(int i = twoPosition; i < nums2.length; i++)
				{
					result[nums1.length+i] = nums2[i];
				}
				break;
			}
			if(twoPosition > nums2.length-1) //when all of list2 is in the results array
			{
				for(int i = onePosition; i < nums1.length; i++)
				{
					result[nums2.length+i] = nums1[i];
				}
				break;
			}
			if(  nums1[onePosition] < nums2[twoPosition] ) // if list1 is lower
			{
				result[onePosition+twoPosition] = nums1[onePosition];
				onePosition++;
				continue;
			}
			else if(  nums2[twoPosition] < nums1[onePosition] ) // if list2 is lower
			{
				result[onePosition+twoPosition] = nums2[twoPosition];
				twoPosition++;
				continue;
			}
			else
			{
				result[onePosition+twoPosition] = nums2[twoPosition];
				twoPosition++;
				continue;
			}
		}
		return result;
	}
	private static void swapIntArray(int[] array, int i, int j) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static void swapArrayArray(int[][] array, int i, int j) {

		int[] temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void swapComparableArray(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static int medianFixed(int[] nums)
	{
			return (nums[((int)nums.length/2)] + nums[((int)nums.length/2)+1])/2;    //ASK IF WE SHOULD RETURN A DOUBLE OR INT FOR MEDIAN
	}
	private static int median(int num1, int num2)
	{
			return (num1+num2)/2;		 
	}
	@Override
	public String greeting() {
		return "Greetings, Mortal.";
	}
	
	public static int binarySearchTim(Comparable[] array,  Comparable query,int first,int last) {
		if(last > first)
		{
			int index = (first+last)/2;
			Comparable guess = array[index];

			if(guess.compareTo(query) < 0)
			{
				return binarySearchTim(array,query,first,index);
			}
			else if(guess.compareTo(query) > 0)
			{
				return binarySearchTim(array,query,index+1,last);
			}
			else
			{
				return index;
			}
		}
		return -1;
	}

	public static void swapStringArray(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static String[] TimSorts(String[] nums)
	{
		if(nums.length < 8)
		{
			insertionSortStringBetter(nums);
			return nums;
		}
		else
		{
			int half = (nums.length/2 );
			String[] oneHalf = Arrays.copyOfRange(nums, 0, half);
			String[] otherHalf = Arrays.copyOfRange(nums, half, nums.length);
			return mergeString( TimSorts( oneHalf ), TimSorts( otherHalf));		
		}
	}

	public static String[] mergeString(String[] list1, String[] list2)
	{
		String[] result = new String[list1.length+list2.length];
		int onePosition = 0;
		int twoPosition = 0;
		while(true)
		{
			if(onePosition >= list1.length) //when all of list1 is in the results array
			{
				for(int i = twoPosition; i < list2.length; i++)
				{
					result[list1.length+i] = list2[i];
				}
				break;
			}
			if(twoPosition >= list2.length) //when all of list2 is in the results array
			{
				for(int i = onePosition; i < list1.length; i++)
				{
					result[list2.length+i] = list1[i];
				}
				break;
			}
			if(  list1[onePosition].compareTo(list2[twoPosition]) < 0 ) // if list1 is lower
			{
				result[onePosition+twoPosition] = list1[onePosition];
				onePosition++;
				continue;
			}
			else if(  list2[twoPosition].compareTo(list1[onePosition]) < 0 ) // if list2 is lower
			{
				result[onePosition+twoPosition] = list2[twoPosition];
				twoPosition++;
				continue;
			}
			else
			{
				result[onePosition+twoPosition] = list2[twoPosition];
				twoPosition++;
				continue;
			}
		}
		return result;
	}

	public static void insertionSortStringBetter(String [] list1)
	{
		int fhp = 1;
		if(list1[0].compareTo(list1[1]) > 0)
		{
			swapStringArray(list1,0,1);
		}
		while(true)
		{
			if(fhp >= list1.length-1)
			{
				break;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) < 0)
			{
				fhp = fhp+1;
				continue;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) > 0)
			{
					swapStringArray(list1,fhp,fhp+1);
					int num = fhp;
					for(int i = fhp-1; i > -1; i--)
					{
						if(list1[i].compareTo(list1[num]) < 0)
						{
							break;
						}
						else
						{
							swapStringArray(list1,i,num);
							num = num -1 ;
						}
					}
					fhp = fhp + 1;
					continue;
			}	
		}
	}
}
