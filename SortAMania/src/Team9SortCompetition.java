
public class Team9SortCompetition extends SortCompetition {

	@Override
	public int challengeOne(int[] arr)
	{
		int[] copy = arr;
		int[] count = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++)
		{
			count[copy[i]]++;
		}
		for (int i = 1; i < count.length; i++)
		{
			count[i] = count[i] + count[i-1];
		}
		int[] sorted = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			sorted[count[copy[i]] - 1] = copy[i];
			count[copy[i]]--;
		}
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = sorted[i];
		}
		return ((arr[arr.length/2])+(arr[(arr.length/2)-1]))/2;
	}

	@Override
	public int challengeTwo(String[] arr, String query) { //Change to burst
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int challengeThree(int[] arr)
	{
		int[] copy = arr;
		int[] count = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			count[copy[i]]++;
		}
		for (int i = 1; i < count.length; i++)
		{
			count[i] = count[i] + count[i-1];
		}
		int[] sorted = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			sorted[count[copy[i]] - 1] = copy[i];
			count[copy[i]]--;
		}
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = sorted[i];
		}
		return ((arr[arr.length/2])+(arr[(arr.length/2)-1]))/2;
	}

	@Override
	public int challengeFour(int[][] arr) {
		int[] medians = new int[1000];
		for (int i = 0; i < arr.length; i++)
		{
			medians[i] = challengeOne(arr[i]);
		}

		return sortAndSwap(medians, arr);
	}

	@Override
	public int challengeFive(Comparable[] arr, Comparable query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String greeting() {
		return "Team Numba 9 Here";
	}
	
	public static int sortAndSwap(int[] arr, int[][] multi)
	{
		int[] copy = arr;
		int[] count = new int[arr.length + 1];
		int[][] newMulti = new int[multi.length][multi[0].length];
		for (int i = 0; i < arr.length; i++)
		{
			count[copy[i]]++;
		}
		for (int i = 1; i < count.length; i++)
		{
			count[i] = count[i] + count[i-1];
		}
		int[] sorted = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			sorted[count[copy[i]] - 1] = copy[i];
			
			count[copy[i]]--;
		}
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = sorted[i];
			newMulti[i] = multi[sorted[i]];
		}
		for (int i = 0; i < arr.length; i++)
		{
			multi[i] = newMulti[i];
		}
		return ((arr[arr.length/2])+(arr[(arr.length/2)-1]))/2;
	}
}
