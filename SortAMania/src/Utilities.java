 /* Miriam Monroe and Ramisha Sarwar
 * Sort-a-Mania
 * Miriam is editing these files
 */


import java.util.Arrays;

public class Utilities
{
	public static void bubbleSort(int[] list1)
	{
		for(int i = 0; i < list1.length-1; i++)
		{
			for(int j = 0; j < list1.length-i-1; j++)
			{
				if(list1[j+1] < list1[j])
				{
					swap(list1, j, j+1);
				}
			}
		}
	}
	
	
	
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int median(int[] list)
	{
		int median = 0;
		if(list.length % 2 == 0)
		{
			int x = list.length - 2;
			int y = x/2;
			int i =  y + 1;
			int e = list[y];
			int f = list[i];
			
			median = (e + f)/2;
		}
		
		if(list.length % 2 == 1)
		{
			int x = list.length - 1;
			int y = x/2;
			median = list[y];
		}
		 
		return median;
	}
	
public static String[] merge(String[] list1, String[] list2)
{
	
	String[] merged = new String[list1.length + list2.length];
	int index = 0;
	int i = 0;
	int j = 0;

	while(i < list1.length && j<list2.length)
	{
			if(list1[i].compareTo(list2[j]) <= 0)
			{
				merged[index] = list1[i];
				index++;
				i++;
			}
			else if(list1[i].compareTo(list2[j]) > 0)
			{
				merged[index] = list2[j];
				index++;
				j++;
			}

	}
	
	
	if(i < list1.length)
	{
		
		while(i < list1.length)
		{
			merged[index] = list1[i];
			index++;
			i++;
		}
	}
	
	if(j < list2.length)
	{
		while(j < list2.length)
		{
			merged[index] = list2[j];
			index++;
			j++;
		}
	}
	
	
			
			
	return merged;
}

public static String[] mergeSort(String[] list)
{
	int index = list.length/2;
	if(list.length == 1)
	{
		return list;
	}
	else
	{
		return merge(mergeSort(Arrays.copyOfRange(list, 0, index)), mergeSort(Arrays.copyOfRange(list, index, list.length)));
	}
}

public static Comparable[] mergeSort(Comparable[] list)
{
	int index = list.length/2;
	if(list.length == 1)
	{
		return list;
	}
	else
	{
		return merge(mergeSort(Arrays.copyOfRange(list, 0, index)), mergeSort(Arrays.copyOfRange(list, index, list.length)));
	}
}

public static Comparable[] merge(Comparable[] list1, Comparable[] list2)
{
	
	Comparable[] merged = new Comparable[list1.length + list2.length];
	int index = 0;
	int i = 0;
	int j = 0;

	while(i < list1.length && j<list2.length)
	{
			if(list1[i].compareTo(list2[j]) <= 0)
			{
				merged[index] = list1[i];
				index++;
				i++;
			}
			else if(list1[i].compareTo(list2[j]) > 0)
			{
				merged[index] = list2[j];
				index++;
				j++;
			}

	}
	
	
	if(i < list1.length)
	{
		
		while(i < list1.length)
		{
			merged[index] = list1[i];
			index++;
			i++;
		}
	}
	
	if(j < list2.length)
	{
		while(j < list2.length)
		{
			merged[index] = list2[j];
			index++;
			j++;
		}
	}
	
	
			
			
	return merged;
}

public static int binarySearch(String list[], int first, int last, String x)
	{
	    if (last>=first)
	    {
	        int mid = first + (last - first)/2;
	
	        if (list[mid] == x)
	        {
	        	return mid;
	        }
	
	        if (list[mid].compareTo(x) > 0)
	        {
	        	return binarySearch(list, first, mid-1, x);
	        }
	        
	
	        return binarySearch(list, mid+1, last, x);
	    }
	
	    return -1;
	}
}