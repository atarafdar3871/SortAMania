
public class Team7SortCompetition extends SortCompetition
{
	public int challengeOne(int[] arr)
	{
		quickSort(arr,0,arr.length - 1);
		if(arr.length%2 == 0)
		{
			return (arr[(arr.length/2)]) + (arr[(arr.length/2 + 1)])/2;
		}
		return arr[arr.length/2];
		
	}
	public int challengeTwo(String[] arr, String query)
	{
		
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
	public int challengeThree(int[] arr)
	{
		insertionSort(arr);
		if(arr.length%2 == 0)
		{
			return (arr[(arr.length/2)]) + (arr[(arr.length/2 + 1)])/2;
		}
		return arr[arr.length/2];
		
	}
	public int challengeFive(Comparable[] arr, Comparable query)
	{
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i].compareTo(query)==0)
			{
				return i;
			}
		}
		return -1;
	}
	public static int indexOfMin(int first, int[] list1)
	{
		int temp = list1[first];
		int index = first;
		for(int i  = first; i < list1.length; i++)
		{
			if(temp > list1[i]) {
				temp = list1[i];
				index = i;
			}
		}
		return index;
	}
	public static int indexOfMinMedian(int first, int[][] list1)
	{
		int temp = list1[first][500];
		int index = first;
		for(int i  = first; i < list1.length; i++)
		{
			if(temp > list1[i][500]) {
				temp = list1[i][500];
				index = i;
			}
		}
		return index;
	}
	public static void selectionSort(int[] list1) {
		for(int i = 0; i < list1.length; i++)
		{
			swap(list1, i, indexOfMin(i, list1));
		}
	}
	public static void selectionSortDeux(int[][] list1) {
		for(int i = 0; i < list1.length; i++)
		{
			swap(list1, i, indexOfMinMedian(i, list1));
		}
	}
	public int challengeFour(int[][] arr)
	{
		for(int i=0; i< arr.length; i++)
		{
			selectionSort(arr[i]); //sorts all sub arrays into ascending order
		}
		for(int i=0; i<arr.length;i++)
		{
			selectionSortDeux(arr);
		}
		return arr[500][500];
	}
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void swap(int[][] arr, int i, int j)
	{
		int[] temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void insertionSort(int[] list1)
	{
		int index = 0;
		for (int i = 0; i < list1.length - 1; i++)
		{
			if (list1[i] > list1[i + 1])
			{
				index = i + 1;
				for (int j = i; j > -1; j--)
				{
					if (list1[index] < list1[j])
					{
						swap(list1, index, j);
						index = j;
					}
				}
			}
		}
	}
	public static void insertionSort(Comparable[] list1)
	{
		int index = 0;
		for (int i = 0; i < list1.length - 1; i++)
		{
			if (list1[i].compareTo(list1[i + 1]) > 0)
			{
				index = i + 1;
				for (int j = i; j > -1; j--)
				{
					if (list1[index].compareTo(list1[j])<0)
					{
						swap(list1, index, j);
						index = j;
					}
				}
			}
		}
	}
	public static void swap(Comparable[] arr, int i, int j)
	{
		Comparable temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int partition(int[] list1,int front,int back ){ 
		int pivot = (front+back)/2;
		boolean partition = false;
		while(!partition)
		{
			partition = true;
		
		for(int i = 0; i < pivot; i++)
		{
			
			if(list1[i] > list1[pivot])
			{
				//System.out.println("Pivot: "+list1[pivot]);
				//System.out.println(i);
				//System.out.println(pivot);
				partition = false;
				//System.out.println("Switching: "+list1[i]+" "+list1[pivot]);
				swap(list1, pivot, i);
				pivot = i;

			}
			if(i == pivot)
			{
				break;
			}
		}
		for(int j = back; j > pivot; j--)
		{
			
			if(list1[j] < list1[pivot])
			{
				//System.out.println("Pivot: "+list1[pivot]);
				///System.out.println(j);
				//System.out.println(pivot);
				partition = false;

				//System.out.println("Switching: "+list1[j]+" "+list1[pivot]);
				swap(list1, pivot, j);
				pivot = j;

			}
			if(j == pivot)
			{
				break;
			}
		}
	}

		return pivot;
	}
	
	public static void quickSort(int[] list1, int front, int back)
	{
		if(front < back) {
			if(back - front > 1)
			{
				quickSort(list1,front, partition(list1,front, back)); 
				quickSort(list1,partition(list1,front, back)+1, back); 
			}
		}
	}
	public static void swap(String[] arr, int i, int j)
	{
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void bubbleSort(String[] list) {
		boolean sorted = false;
		while(!sorted){
			sorted = true;
			for(int i = 0; i < list.length-1; i++) {
				if(list[i].compareTo(list[i+1])>0)
				{
					swap(list, i, i + 1);
					sorted = false;
				}
			}
		}
	}
	@Override
	public String greeting() {
		// TODO Auto-generated method stub
		return "Never forget greetings; they are important.";
	}
}
