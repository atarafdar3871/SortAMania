
public class Team9SortCompetition extends SortCompetition {

	@Override
	public int challengeOne(int[] arr)
	{
		int size = 10000;
		int[] count = new int[size];
		for (int i = 0; i < size; i++)
		{
			count[arr[i]]++;
		}
		for (int i = 1; i < size; i++)
		{
			count[i] = count[i] + count[i-1];
		}
		int[] sorted = new int[size];
		for (int i = 0; i < size; i++)
		{
			sorted[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < size; i++)
		{
			arr[i] = sorted[i];
		}
		return ((arr[size/2])+(arr[(size/2)-1]))/2;
	}

	@Override
	public int challengeTwo(String[] arr, String query) { //Change to burst
		quickSort(arr, 0, 10000);
		return binarySearch(arr, query);
	}

	@Override
	public int challengeThree(int[] arr)
	{
		int size = 10000;
		int[] count = new int[size];
		for (int i = 0; i < size; i++)
		{
			count[arr[i]]++;
		}
		for (int i = 1; i < size; i++)
		{
			count[i] = count[i] + count[i-1];
		}
		int[] sorted = new int[size];
		for (int i = 0; i < size; i++)
		{
			sorted[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < size; i++)
		{
			arr[i] = sorted[i];
		}
		return ((arr[size/2])+(arr[(size/2)-1]))/2;
	}

	@Override
	public int challengeFour(int[][] arr) {
		int[] medians = new int[1000];
		for (int i = 0; i < arr.length; i++)
		{
			medians[i] = challengeOne(arr[i]);
		}
		for (int i = 0; i < medians.length - 1; i++)  
		{  
			int index = i;  
			for (int j = i + 1; j < medians.length; j++){  
				if (medians[j] < medians[index]){  
					index = j;
				}  
			}  
			int temp = medians[index];
			medians[index] = medians[i];
	        medians[i] = temp;
	        
	        int[] temp2 = arr[index];
	        arr[index] = arr[i];
	        arr[i] = temp2;
	    }
		return ((medians[medians.length/2])+(medians[(medians.length/2)-1]))/2;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int challengeFive(Comparable[] arr, Comparable query) {
		quickSort(arr, 0, arr.length);
		return binarySearch(arr, query);
	}

	@Override
	public String greeting() {
		return "Team Numba 9 Here";
	}
	private static void quickSort(String[] list1, int front, int back)
	{
		if (front >= back)
		{
			return;
		}
		else
		{
			int PIVOTindex = partition(list1, front, back);
			quickSort(list1, front, PIVOTindex);
			quickSort(list1, PIVOTindex + 1, back);
		}
	}
	
	private static int partition(String[] list, int front, int back)
	{
		String pivot = list[front];
		int i = front;
		for (int j = front + 1; j < back; j++)
		{
			if (list[j].compareTo(pivot) <= 0)
			{
				i++;
				String temp = list[j];
				list[j] = list[i];
				list[i] = temp;
			}
		}
		String temp = list[front];
		list[front] = list[i];
		list[i] = temp;
		return i;
	}
	
	private static int binarySearch(String[] a, String key) {
		int min = 0;
	    int max = a.length -1;
	    int mid = 0;

	    while (min <= max) 
	    {
	    	mid = min + (max - min) / 2;
	    	if (a[mid].compareTo(key) == 0) 
	    	{
	    		return mid;
	    	} 
	    	else if (a[mid].compareTo(key) > 0) 
	    	{
	    		min = mid + 1;
	    	} 
	    	else 
	    	{
	    		max = mid - 1;
	    	}
	    }
	    return -1;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int binarySearch(Comparable[] a, Comparable key) {
		int min = 0;
		int max = a.length -1;
		int mid = 0;
		
		while (min <= max) {
			mid = min + (max - min) / 2;
			if (a[mid].compareTo(key) == 0) 
			{
	        return mid;
			} 
			else if (a[mid].compareTo(key) > 0) 
			{
				min = mid + 1;
			} 
			else 
	      	{
				max = mid - 1;
	      	}
	    }
	    return -1;
	}
	
	@SuppressWarnings("rawtypes")
	private static <T extends Comparable<T>> void quickSort(Comparable[] list1, int front, int back) { 
		if (front >= back)
		{
			return;
		}
		else
		{
			int PIVOTindex = partition(list1, front, back);
			quickSort(list1, front, PIVOTindex);
			quickSort(list1, PIVOTindex + 1, back);
		}
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T extends Comparable<T>> int partition(Comparable[] a, int front, int back) {
        int i = front + 1;
        int j = back;

        while(i <= j) {
        	if(a[j].compareTo(a[front]) > 0) { 
                j--;
            }
            else if(a[i].compareTo(a[front]) <= 0) { 
                i++; 
            }
            else if (j < i) {
                break;
            }
            else
            {
            	swap(a, i, j);
            }
        }
        swap(a, front, j);
        return j;
    }
	
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
