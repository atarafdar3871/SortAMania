import java.util.Arrays;
import java.util.Random;

public class Team16SortCompetition extends SortCompetition{

	public static void main(String[] args)
	{
		Team16SortCompetition bot = new Team16SortCompetition();		
	}
	
	@Override
	public int challengeOne(int[] arr) {
		selectionSort(arr);                                                
		return Median(arr);
	}

	@Override
	public int challengeTwo(String[] arr, String query) {
		bubbleSort(arr);
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].equals(query)) 
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public int challengeThree(int[] arr) {
		for (int i = 0; i < arr.length*.75; i++)
		{
			for (int j = i+1; j < arr.length*.75; j++)
			{
				if (arr[i] > arr[j])
				{
					swap(arr,i,j);
				}
			}
		} 
		return Median(arr);
	}

	@Override
	public int challengeFour(int[][] arr) {
		int[] medianArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			selectionSort(arr[i]);
			medianArr[i] = Median(arr[i]);
		}
		return Median(medianArr);
	}

	@Override
	public int challengeFive(Comparable[] arr, Comparable query) {
		mergeSort(arr);
		for(int i=0; i < arr.length; i++)
		{
			if(arr[i] == query)
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public String greeting() {
		return "Omae wa mou shindeiru";
	}

	public static void selectionSort(int[] list1)
	{
		for (int i = 0; i < list1.length-1; i++)
		{
			for (int j = i+1; j < list1.length; j++)
			{
				if (list1[i] > list1[j])
				{
					swap(list1,i,j);
				}
			}
		} 
	}
	
	public static void bubbleSort(String[] list1)
	{
		for (int i = 0; i < list1.length; i++)
		{
			for (int j = i+1; j < list1.length; j++)
			{
				if (list1[i].compareTo(list1[j]) < 0)
				{
					String temp = list1[i];
					list1[i] = list1[j];
					list1[j] = temp;
				}
				if (list1[j].compareTo(list1[i]) < 0)
				{
					String temp = list1[j];
					list1[j] = list1[i];
					list1[i] = temp;
				}
			}
		}
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

	public static int Median(int[] list)
	{
		if(list.length%2==1)
		{
			return list[(list.length)/2];
		}
		else
		{
			return (list[(list.length/2)] + list[list.length/2-1])/2;
		}
	}
	
	public static void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static int[] generateIntArr()
	{
		int[] name = new int[10000];
		Random rand = new Random();
		int x = rand.nextInt(10000) + 1;
		for(int i = 0; i<name.length;i++)
		{
			name[i] = x;
		}
		return name;
	}
	
	public static int[][] generateMDIntArr()
	{
		int[][] name = new int[1000][1000];
		Random rand = new Random();
		int x = rand.nextInt(10000) + 1;
		for(int i = 0; i<name.length;i++)
		{
			for(int j = 0; j<name[i].length; j++)
			{
				name[i][j] = x;
			}
		}
		return name;
	}
	
	public static String[] generateStringArr()
	{
		String[] randomLetts = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y","z"};
		String[] strings = new String[10000];
		Random rand = new Random();
		String construct = "";
		int item1 = rand.nextInt(26) + 1;
		int item2 = rand.nextInt(26) + 1;
		int item3 = rand.nextInt(26) + 1;
		int item4 = rand.nextInt(26) + 1;
		int item5 = rand.nextInt(26) + 1;
		for (int i = 0; i < strings.length; i++)
		{
			construct = randomLetts[item1] + randomLetts[item2] + randomLetts[item3] +randomLetts[item4] + randomLetts[item5];
			strings[i] = construct;
			construct = "";
		}
		return strings;
	}
}
