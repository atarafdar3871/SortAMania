/**
 * Edward Yaroslavsky and Kelvin Chen 
 * SortAMania Team 5
 * 12/7/17
 */
import java.util.Arrays;

public class Team5SortCompetition extends SortCompetition{

	public static void main(String[] args) {
/*		System.out.println("Challenge 1:");
		int[] list1 = {1,2,3,4,5,6,7,8};
		System.out.println(challengeOne(list1));
		for (int x = 0; x < list1.length; x++) {
			System.out.print(list1[x]);
		}
			
		System.out.println(); System.out.println();
		System.out.println("Challenge 2:");
		String[] list2 = {"Kelvi","AaAaA","Acccc","Black","Edwar"};
		System.out.println(challengeTwo(list2,"Edwar"));
		for (int x = 0; x < list2.length; x++) {
			System.out.print(list2[x]+ " ");
		}
		
		System.out.println(); System.out.println();
		System.out.println("Challenge 3:");
		int[] list3 = {4,8,6,7,3,2,3,4,1,5};
		System.out.println(challengeThree(list3));
		for (int x = 0; x < list3.length; x++) {
			System.out.print(list3[x]);
		}
	
		System.out.println(); System.out.println();
		System.out.println("Challenge 4:");
		int[][] list4 = {{4,5,6,6,8},{7,8,9,9,3},{1,2,3,3,7},{6,1,2,3,5},{8,1,5,3,5}};
		int median = (int) challengeFour(list4);
		System.out.println();
		for (int x = 0; x < list4.length; x++) {
			for (int y = 0; y < list4[0].length; y++) {
				System.out.print(list4[x][y]);
			}
			System.out.println();
		}
		
		
		String[] list5 = {"Kelvi","AaAaA","Acccc","Black","Edwar"};
		System.out.println(challengeFive(list5,"Kelvi"));
		for (int x = 0; x < list5.length; x++) {
			System.out.print(list5[x]+ " ");
		}
		*/
		
	}
	
	/**
	 * Sorts an array and finds its median
	 * @param arr - the array that holds the median value and is to be sorted
	 * @return the int median value of the array
	 */
	public int challengeOne(int[] arr) {
		quickSort(arr, 0, arr.length);
		return (int) median(arr);
	}
	
/*	public static double challengeOne(double[] arr)
	{
		quickSort(arr,0,arr.length);
		return median(arr);
	} */
	
	/**
	 * Sorts an array of Strings and finds if a certain String is in the array
	 * @param arr - the array to be sorted and searched through
	 * @param search - the String to be looked for in the array
	 * @return the position of the search word
	 */
	public int challengeTwo(String[] arr, String search)
	{
		String[] arr2 = mergeSort(arr);
		for(int i = 0; i < arr2.length;i++)
		{
			arr[i] = arr2[i];
		}
		// CONSIDER: FOR OR FOREACH TEST FOR SPEED.
		for(int x = 0; x < arr.length;x++)
		{
			if(search.equals(arr[x]))
			{
				return x;
			}
		}
		return -1;	
	}
	
	/**
	 * Sorts an array and finds its median
	 * @param arr - the array to be sorted
	 * @return the median of the array
	 */
	public int challengeThree(int[] arr) {
		return challengeOne(arr);
	}
	
	/**
	 * Sorts a 2D array and finds the median of medians
	 * @param arr2D - the 2D array that holds the median value and is to be sorted  
	 * @return the median of the medians in the 2D array
	 */
	public int challengeFour(int[][] arr2D) {
		int[] medianArr = new int[arr2D[0].length];
		for (int x = 0; x < arr2D.length; x++) {
			medianArr[x]= challengeOne(arr2D[x]);
		}
		int[] medianArrPos = new int[medianArr.length];
		for (int y = 0; y < medianArrPos.length; y++) {
			medianArrPos[y] = y;
		}
		bubbleSort(medianArr, medianArrPos);
		
		//System.out.println("Median Array Sorted: ");
		for (int z = 0; z < medianArrPos.length; z++) {
			//System.out.print(medianArr[z]+ " ");
		}
		//System.out.println("Median Array Positions:");
		for (int z = 0; z < medianArrPos.length; z++) {
			//System.out.print(medianArrPos[z]+ " ");
		}
		for(int i = 0; i < medianArrPos.length; i++)
		{
			int[] temp = new int [arr2D[0].length];
			temp = arr2D[i];
			arr2D[i] = arr2D[medianArrPos[i]];
			arr2D[medianArrPos[i]] = temp;
		}
		reverseColumnsInPlace(arr2D);
		return challengeOne(medianArr);
	}
	
	/**
	 * Sorts Comparable Objects and finds the position of a certain key Object in the array
	 * @param arr - the Comparable array to be sorted and searched
	 * @param query - the Comparable key Object to be searched for
	 * @return the position of the query in the array
	 */
	public int challengeFive(Comparable[] arr, Comparable query)
	{
		Comparable[] arr2 = mergeSort2(arr);
		for(int i = 0; i < arr2.length;i++)
		{
			arr[i] = arr2[i];
		}
		for(int x = 0;x < arr.length;x++)
		{
			if(arr2[x].equals(query))
			{
				return x;
			}
		}
		return -1;
	}
	
	/**
	 * Introduces the sorter with a greeting 
	 * @return String of the greeting
	 */
	public String greeting()
	{
		return "KELVIN AND EDWARD'S AMAZING SORTER: "
				+ "\nHow many programmers does it take to screw in a light bulb?"
				+ "\nNone ... That's a hardware problem.";
	}
	
	/**
	 * Finds the median of an array
	 * @param arr - the array that holds the median value
	 * @return the double median of the array
	 */
	public double median(int[] arr) {
		if (arr.length % 2 == 0) {
			return (double)((arr[arr.length/2] + arr[arr.length/2 - 1]) / 2.0);
		}
		return (double)(arr[(arr.length-1) / 2]);
	}
	

/*	public static double median(double[] arr) {
		if (arr.length % 2 == 0) {
			return ((arr[arr.length/2] + arr[arr.length/2 - 1]) / 2.0);
		}
		return (arr[(arr.length-1) / 2]); 
	} */
	
	/**
	 * Uses a pivot from an array to partition the array so that numbers less than the pivot would be to its left, 
	 * and numbers greater to its right.
	 * @param list1 - the array to be partitioned
	 * @param front - the front position of the array
	 * @param back - the back position of the array
	 * @return the new position of the pivot
	 */
	public int partition(int[] list1, int front, int back) {
			int pivot = list1[front];
			int front2 = front;
			int pivotPos = front;
			for (int x = front+1; x < back; x++) 
			{
				if (list1[x] <= pivot)
				{
					if (pivotPos == front2) 
					{
						pivotPos = x;
					}
					int temp = list1[front2];
					list1[front2] = list1[x];
					list1[x] = temp;
					front2++;
				}	
			}
			int temp = list1[pivotPos];
			list1[pivotPos] = list1[front2];
			list1[front2] = temp;
			return front2+1;
		}
	
	/**
	 * Uses a pivot from an array to partition the array so that numbers less than the pivot would be to its left, 
	 * and numbers greater to its right.
	 * @param list1 - the array to be partitioned
	 * @param front - the front position of the array
	 * @param back - the back position of the array
	 * @return the new position of the pivot
	 */
	public int partition(double[] list1, int front, int back) {
			double pivot = list1[front];
			int front2 = front;
			int pivotPos = front;
			for (int x = front+1; x < back; x++) 
			{
				if (list1[x] <= pivot)
				{
					if (pivotPos == front2) 
					{
						pivotPos = x;
					}
					double temp = list1[front2];
					list1[front2] = list1[x];
					list1[x] = temp;
					front2++;
				}	
			}
			double temp = list1[pivotPos];
			list1[pivotPos] = list1[front2];
			list1[front2] = temp;
			return front2+1;
		}
	
	/**
	 * Sorts an array through recursion and constant use of partition 
	 * @param list1 - the array to be sorted
	 * @param front - the front position of the array
	 * @param back - the back position of the array
	 */
	public void quickSort(int[] list1, int front, int back) {
		if(back - front <= 1)
		{
			return;
		}
		else {
			int pivotPos = partition(list1, front, back)-1;	
			quickSort(list1, front, pivotPos);
			quickSort(list1, pivotPos+1, back); 
		}

	}
	
	/*/**
	 * Sorts an array through recursion and constant use of partition 
	 * @param list1 - the array to be sorted
	 * @param front - the front position of the array
	 * @param back - the back position of the array
	 
	public static void quickSort(double[] list1, int front, int back) {
		if(back - front <= 1)
		{
			return;
		}
		else {
			int pivotPos = partition(list1, front, back)-1;	
			quickSort(list1, front, pivotPos);
			quickSort(list1, pivotPos+1, back); 
		}

	}
	*/
	
	/**
	 * Quick sorts the 2D array through partition and recursion
	 * @param pos - position of the pivot
	 * @param front - int of the front location
	 * @param back - int of the back location
	 * @param arr - 2D array to be sorted
	 */
	public void quickSort(int[] pos, int front, int back, int[][] arr)
	{
		if(back - front <= 1)
		{
			return;
		}
		else {
			int pivotPos = partition(pos, front, back, arr)-1;	
			quickSort(pos, front, pivotPos, arr);
			quickSort(pos, pivotPos+1, back, arr); 
		}
	}
	
	/**
	 * Partitions the arrays
	 * @param pos - position of the pivot array
	 * @param front - int of the front location
	 * @param back - int of the back location
	 * @param list1 - 2D array to be partitioned
	 * @return the int position of the pivot array
	 */
	public int partition(int[] pos, int front, int back, int[][] list1) {
		int pivot = pos[front];
		int front2 = front;
		int pivotPos = front;
		for (int x = front+1; x < back; x++) 
		{
			if (pos[x] <= pivot)
			{
				if (pivotPos == front2) 
				{
					pivotPos = x;
				}
				int temp = pos[front2];
				pos[front2] = pos[x];
				pos[x] = temp;
				int[] temp2 = list1[front2];
				list1[front2] = list1[x];
				list1[x] = temp2;
				front2++;
			}	
		}
		int temp = pos[pivotPos];
		pos[pivotPos] = pos[front2];
		pos[front2] = temp;
		int[] temp2 = list1[pivotPos];
		list1[pivotPos] = list1[front2];
		list1[front2] = temp2;
		return front2+1;
	}
	
	/**
	 * Reverses the order of the 2D array
	 * @param arr - the 2D array that needs to be reversed
	 */
	public void reverseColumnsInPlace(int[][] arr){
        for(int x = 0;x < arr[0].length; x++){
            for(int y = 0; y < arr.length/2; y++) {
                int temp = arr[y][x];
                arr[y][x] = arr[arr.length - y - 1][x];
                arr[arr.length - y - 1][x] = temp;
            }
    }
}
	
	/**
	 * Merges two lists in alphabetical order
	 * @param list1 - first array to be looked at
	 * @param list2 - second array to be looked at
	 * @return - A merged String array in alphabetical order
	 */
	public Comparable[] merge2(Comparable[] list1, Comparable[] list2) {
		Comparable[] list3 = new Comparable[list1.length + list2.length];
		int x = 0;
		int y = 0;
		int index = 0;
		while(x < list1.length || y < list2.length)
		{
			if(x == list1.length) //full of x
			{
				list3[index] = list2[y];
				y++;
				index++;
			}
			else if(y == list2.length) //full of y
			{
				list3[index] = list1[x];
				x++;
				index++;
			}
			else if(list1[x].compareTo(list2[y]) < 0) // if list1's item is smaller than list2's item
			{
				list3[index]= list1[x];
				x++;
				index++;
			}
			else
			{
				list3[index]= list2[y];
				y++;
				index++;
			}
		}
		return list3;
	}
	
	/**
	 * Sorts an array through use of recursion and the merge method
	 * @param list - the array to be sorted
	 * @return - the String array in its sorted form
	 */
	public Comparable[] mergeSort2(Comparable[] list) {
		if (list.length == 1) {
			return list;
		}
		else {
			Comparable[] newList = Arrays.copyOfRange(list,0,list.length / 2);
			Comparable[] newList2 = Arrays.copyOfRange(list,list.length / 2,list.length);
			return merge2(mergeSort2(newList),mergeSort2(newList2));
			
		}
	}
	
	/**
	 * Creates a merged list
	 * @param list1 - first String array to be merged 
	 * @param list2 - second String array to be merged
	 * @return the new merged String array
	 */
	public String[] merge(String[] list1, String[] list2) {
		String[] list3 = new String[list1.length + list2.length];
		int x = 0;
		int y = 0;
		int index = 0;
		while(x < list1.length || y < list2.length)
		{
			if(x == list1.length) //full of x
			{
				list3[index] = list2[y];
				y++;
				index++;
			}
			else if(y == list2.length) //full of y
			{
				list3[index] = list1[x];
				x++;
				index++;
			}
			else if(list1[x].compareTo(list2[y]) < 0) // if list1's item is smaller than list2's item
			{
				list3[index]= list1[x];
				x++;
				index++;
			}
			else
			{
				list3[index]= list2[y];
				y++;
				index++;
			}
		}
		return list3;
	}
	
	/**
	 * Sorts an array through use of recursion and the merge method
	 * @param list - the array to be sorted
	 * @return - the String array in its sorted form
	 */
	public String[] mergeSort(String[] list) {
		if (list.length == 1) {
			return list;
		}
		else {
			String[] newList = Arrays.copyOfRange(list,0,list.length / 2);
			String[] newList2 = Arrays.copyOfRange(list,list.length / 2,list.length);
			return merge(mergeSort(newList),mergeSort(newList2));
			
		}
	}
	
	/**
	 * Sorts a String array by checking items next to each other to see which holds greater value
	 * @param medianArr - the array to be sorted
	 */
	public void bubbleSort(int[] medianArr, int[] medianArrPos) {
		int counter = medianArr.length-1;
		while (counter > 0) {
			for (int x = 0; x < medianArr.length-1; x++) {
				for (int y = x+1; y < medianArr.length; y++) {
					if (medianArr[x] > (medianArr[y])) {
						int temp = medianArr[x];
						medianArr[x] = medianArr[y];
						medianArr[y] = temp;
						int temp2 = medianArrPos[x];
						medianArrPos[x] = medianArrPos[y];
						medianArrPos[y] = temp2;
					}
					else {
						counter--;
					}
				}
			}
		}	
	}
}
