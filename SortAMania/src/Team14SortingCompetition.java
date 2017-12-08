
import java.util.Random;
import java.util.Arrays;
public class Team14SortingCompetition extends SortCompetition {

	public static void main(String[]args) {
		Team14SortingCompetition bot = new Team14SortingCompetition();
		int[] list = new int[10000];
		int[][] list2 = new int[1000][1000];
		generateNum(list2);
		generateNum(list);
		printIntArray(list);
		//System.out.println(ChallangeOne(list));
		//System.out.println(Arrays.deepToString(list2));
		System.out.println(bot.challengeThree(list));
		System.out.println(bot.challengeFour(list2));
		//System.out.println(bot.challengeFive(list3,5));
	}
	public int challengeOne(int[] arr) {
		bubbleSort(arr);
		return median(arr);
	}
	public int challengeTwo(String[] arr, String query) {
	{
		bubbleSort(arr);
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].compareTo(query) == 0)
			{
				return i;
			}
		}
		return -1;
	}
		}
	
	public int challengeThree(int[] arr) {
		
		int[] arr1 = new int[arr.length/4];
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i];
			//System.out.println(arr[i]);
		}
		for(int j = 0; j < arr1.length; j++) {
			arr[j] = arr1[j];
		}
		bubbleSort(arr);
		//printIntArray(arr1);
		return median(arr);
	}
	
	public int challengeFour(int[][] arr) {
		int[] arr2 = new int[1000];
		for(int i = 0; i < arr.length; i++) {
			bubbleSort(arr[i]);
			arr2[i] = median(arr[i]);
		}
			bubbleSort(arr2);
			return(median(arr2));
	}
	
	
	public int challengeFive(Comparable[] arr, Comparable query) {
		mergeSort(arr);
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==query)
			{
				return i;
			}
		}
		return -1;
	}
	
	public static Comparable[] merge(Comparable[] list1, Comparable[] list2)
	{
		Comparable[] merged = new Comparable[list1.length + list2.length];
		int z = 0;
		int firstList = 0;
		int secList = 0;
		while(firstList < list1.length && secList < list2.length)
		{
			if (list1[firstList].compareTo(list2[secList]) == 0)
			{
				merged[z] = list1[firstList];
				firstList++;
				secList++;
				z++;
			}
			else if (list1[firstList].compareTo(list2[secList]) < 0)
			{
				merged[z] = list1[firstList];
				firstList++;
				z++;
			}
			else if (list2[secList].compareTo(list1[firstList]) < 0)
			{
				merged[z] = list2[secList];
				secList++;
				z++; 
			}
		}
		
		if (firstList >= list1.length)
		{
			while (secList < list2.length)
			{
				merged[z] = list2[secList];
				z++;
				secList++;
			}
		}
		if(secList >= list2.length)
		{
			while (firstList < list1.length)
			{
				merged[z] = list1[firstList];
				z++;
				firstList++;
			}
		}
		return merged;
	}
	
	public static Comparable[] mergeSort(Comparable[] list)
	{
		if (list.length == 1)
		{
			return list;
		}
		else
		{
			int half = list.length/2;
			Comparable[] firstHalf = Arrays.copyOfRange(list, 0, half);
			Comparable[] secondHalf = Arrays.copyOfRange(list, half, list.length);
			return merge(mergeSort(firstHalf), mergeSort(secondHalf));
		}
	}
	
	public static void bubbleSort(int[]list1) {
		for(int i = 0; i < list1.length-1; i++) {
			for(int j = i+1; j < list1.length; j++) {
				if(list1[i] > list1[j]) {
					int temp = list1[j];
					list1[j] = list1[i];
					list1[i] = temp;
				}
			}
		}
	}
	public static void bubbleSort(String[]list1) {
		for(int i = 0; i < list1.length-1; i++) {
			for(int j = i+1; j < list1.length; j++) {
				if(list1[i].compareTo(list1[j]) < 0) {
					String temp = list1[j];
					list1[j] = list1[i];
					list1[i] = temp;
				}
			}
		}
	}
	
	public static void insertionSort(int[]list1) {
		for(int i = 0; i < list1.length - 1; i++) {
			int num = list1[i];
			int j = i-1;
			while(j >= 0 && list1[j] > num) {
				list1[j+1] = list1[j];
				j = j-1;
			}
			list1[j+1] = num;
		}
	}
	
	public static void printIntArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print("[" + arr[i] + "] ");
		}
		System.out.println();
	}
	
	public static int generateNum() {
			Random rand = new Random();
			int  n = rand.nextInt(10000) + 1;
			return n;
	}
	
	public static void generateNum(int[]list) {
		for(int i = 0; i < list.length; i++) {
			Random rand = new Random();
			int  n = rand.nextInt(10000) + 1;
			list[i] = n;
		}
	}
	
	public static void generateNum(int[][]list) {
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j <list[i].length; j++) {
				Random rand = new Random();
				int  n = rand.nextInt(10000) + 1;
				list[i][j] = n;
			}
		}
		//System.out.println("finished");
	}
	public String greeting() {
		return "Hello";
	}
	
	public static int median(int[]arr) {
		if(arr.length % 2 == 1) {
			return arr[arr.length/2];
		}
		return(arr[arr.length/2] + arr[(arr.length/2)-1])/2;
	}
}


