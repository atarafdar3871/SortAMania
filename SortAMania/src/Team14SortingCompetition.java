
import java.util.Random;
import java.util.Arrays;
public class Team14SortingCompetition extends SortCompetition {

	public static void main(String[]args) {
		Team14SortingCompetition bot = new Team14SortingCompetition();
		int[] list = new int[10000];
		int[][] list2 = new int[1000][1000];
		generateNum(list2);
		//generateNum(list);
		bubbleSort(list);
		//printIntArray(list);
		//System.out.println(ChallangeOne(list));
		//System.out.println(Arrays.deepToString(list2));
		System.out.println(bot.challengeFour(list2));
	}
	public int challengeOne(int[] arr) {
		//bubbleSort(list);
		if(arr.length % 2 == 1) {
			return arr[arr.length/2];
		}
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
		// TODO Auto-generated method stub
		return 0;
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
		bubbleSort(arr);
		for(int i = 0; i < arr.length; i++) {
			
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
	
	public static void printIntArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print("[" + arr[i] + "] ");
		}
		System.out.println();
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public static int median(int[]arr) {
		if(arr.length % 2 == 1) {
			return arr[arr.length/2];
		}
		return(arr[arr.length/2] + arr[(arr.length/2)-1])/2;
	}
}


