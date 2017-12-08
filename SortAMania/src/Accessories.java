
public class Accessories {
	public static int[] arrayBuilder(int x)
	{
		int [] arr = new int[x];
		for (int y = 0; y<x; y++)
		{
			arr[y] = (int)Math.random()*10;
		}
		return arr;
	}
	
	public static boolean isSorted(int[] arr)
	{
		for (int i = 1 ; i < arr.length ; i++)
		{
			if (arr[i] < arr[i-1]) //if current number is less than the previous number, it's not sorted
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isSorted(String[] arr)
	{
		for (int i = 1 ; i < arr.length ; i++)
		{
			if (arr[i].compareTo(arr[i-1]) < 0) //if current number is less than the previous number, it's not sorted
			{
				return false;
			}
		}
		return true;
	}
	
	public static int selectionSort(String[] arr, String str )
	{
		for (int i = 0 ; i < arr.length ; i++)
		{
			if (arr[i].equals(str))
			{
				return i;
			}
		}
		return -1;
	}
    public static int binaryStringSearch(String[] arr, String str) {
    	
    	int low = 0;
    	int high = arr.length;

    	while (low <= high) {
    		int mid = (low + high)/2;
			String midVal = arr[mid];

				if (midVal.compareTo(str) < 0)
				{
					low = mid + 1;
				}
				else if (midVal.compareTo(str) > 0)
				{
					high = mid - 1;
				}
				else
				{
					return mid; // key found
				}
    	}
    	return -1;  // key not found.
    }
    public static int binaryIntSearch(int[] arr, int num) {
    	
    	int low = 0;
    	int high = arr.length;

    	while (low <= high) {
    		int mid = (low + high)/2;
			int midVal = arr[mid];

				if (midVal < num)
				{
					low = mid + 1;
				}
				else if (midVal > num)
				{
					high = mid - 1;
				}
				else
				{
					return mid; // key found
				}
    	}
    	return -1;  // key not found.
    }
}
