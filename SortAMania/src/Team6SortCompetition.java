public class Team6SortCompetition extends SortCompetition{
	
//Start challengeOne
	public int challengeOne(int[] arr) {
		int median = -1;
		if(arr.length == 0) return -1;
		if(arr.length%2 == 0) {
			int firstBound = (int)((arr.length-1) / 2);
			int secondBound = firstBound+1;
			median = (((arr[firstBound]) + (arr[secondBound]))/2);
		}
		else {
			int medianPos = (int)((arr.length-1) / 2);
			median = arr[medianPos];
		}
				
		return median;
	}
	
	public static void insertionSort(int[] list1) {
		for (int i = 1; i < list1.length; i++) {
			int j = i-1;
			int k = i;
			while (j != -1 && list1[k] < list1[j]) {
				swap(list1, k, j);
				j--;
				k--;
			}
		}
	}
	
	public static void swap(int[] list, int pos1, int pos2) {
		int tempVar = -1;
		tempVar = list[pos1];
		list[pos1] = list[pos2];
		list[pos2] = tempVar;
	}
//End challengeOne
	
	
//Start challengeTwo
	public static void fastCmpSwap(String[] arr, int a, int b) {
		if(arr[a].compareTo(arr[b])>0) {
			String t = arr[a];
			arr[a] = arr[b];
			arr[b] = t;
		}
	}
	
	public static void sortNetwork(String[] arr) {
		fastCmpSwap(arr, 0, 1);
		fastCmpSwap(arr, 3, 4);
		fastCmpSwap(arr, 2, 4);
		fastCmpSwap(arr, 2, 3);
		fastCmpSwap(arr, 0, 3);
		fastCmpSwap(arr, 0, 2);
		fastCmpSwap(arr, 1, 4);
		fastCmpSwap(arr, 1, 3);
		fastCmpSwap(arr, 1, 2);
	}
	
	public int challengeTwo(String[] arr, String query) {
		sortNetwork(arr);
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].equals(query)) return i;
		}
		return -1;
	}
	
	
//End challengeTwo
	
//Start challengeThree
	public int challengeThree(int[] arr) {
		int median = -1;
		if(arr.length == 0) return -1;
		if(arr.length%2 == 0) {
			int firstBound = (int)((arr.length-1) / 2);
			int secondBound = firstBound+1;
			median = (((arr[firstBound]) + (arr[secondBound]))/2);
		}
		else {
			int medianPos = (int)((arr.length-1) / 2);
			median = arr[medianPos];
		}			
		return median;
	}
//End challengeThree

//Start challengeFour
	public int challengeFour(int[][] arr) {
		int[] medianArray = new int[5];
		for(int i = 0; i<arr.length; i++) {
			medianArray[i] = sortAndFindMedian(arr[i]);
			System.out.print(medianArray[i] + " ");
		}
		System.out.println();
		return sortAndFindMedian(medianArray);
	}
	
	public int sortAndFindMedian(int[] arr) {
		insertionSort(arr);
		int median = -1;
		if(arr.length == 0) return -1;
		if(arr.length%2 == 0) {
			int firstBound = (int)((arr.length-1) / 2);
			int secondBound = firstBound+1;
			median = (((arr[firstBound]) + (arr[secondBound]))/2);
		}
		else {
			int medianPos = (int)((arr.length-1) / 2);
			median = arr[medianPos];
		}
				
		return median;
	}

	
//End challengeFour

//Start challengeFive
	public int challengeFive(Comparable[] arr, Comparable query) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].equals(query)) return i;
		}
		return -1;
	}
//End challengeFive

	public String greeting() {
		return "Hello, and welcome to Team 6's Sorting Competition entry! Team 6 is made up of Nick Ragovski and Anis Tarfdar.";
	}

}

