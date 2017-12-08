import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Team8SortCompetition extends SortCompetition {

	/**
	 * Implementation of counting sort
	 * 
	 * @param a
	 *            the array
	 * @returns the median
	 */
	@Override
	public int challengeOne(int[] a) {
		int[] temp = new int[10000];
		int[] count = new int[10002]; // 0-10000, bucket with key as integer and value as count
		for (int i = 0; i < 10000; i++) // find total count of each integer value
			count[a[i] + 1]++;
		for (int i = 0; i < 10001; i++) // replace count with starting position
			count[i + 1] += count[i];
		for (int i = 0; i < 10000; i++) // fill temp array
			temp[count[a[i]]++] = a[i];
		System.arraycopy(temp, 0, a, 0, 10000); // copy to initial array
		return (a[4999] + a[5000]) >> 1; // same as divide by two
	}

	/**
	 * Implementation of radix sort
	 * 
	 * @param a
	 *            the array
	 * @param query
	 *            the string to be searched
	 * @returns the index of the query after sort
	 */
	@Override
	public int challengeTwo(String[] a, String query) {
		int len = a.length;
		String[] temp = new String[len];
		// l = letter, start from last letter to first letter
		for (int l = 4; l >= 0; l--) {
			int[] count = new int[124]; // 0-124, bucket with key as ascii values and value as count
			for (int i = 0; i < len; i++) // find total count of each ascii value
				count[a[i].charAt(l) + 1]++;
			for (int i = 0; i < 123; i++) // replace count with starting position
				count[i + 1] += count[i];
			for (int i = 0; i < len; i++) // fill temp array
				temp[count[a[i].charAt(l)]++] = a[i];
			System.arraycopy(temp, 0, a, 0, 10000); // copy back
		}
		return binarySearch(a, query);
	}

	/**
	 * Implementation of counting sort
	 * 
	 * @param a
	 *            the array
	 * @returns the median
	 */
	@Override
	public int challengeThree(int[] a) {
		int[] temp = new int[10000];
		int[] count = new int[10002]; // 0-10000, bucket with key as integer and value as count
		for (int i = 0; i < 10000; i++) // find total count of each integer value
			count[a[i] + 1]++;
		for (int i = 0; i < 10001; i++) // replace count with starting position
			count[i + 1] += count[i];
		for (int i = 0; i < 10000; i++) // fill temp array
			temp[count[a[i]]++] = a[i];
		System.arraycopy(temp, 0, a, 0, 10000); // copy to initial array
		return (a[4999] + a[5000]) >> 1; // same as divide by two
	}

	/**
	 * Implementation of bucket sort where each bucket's key is it's median
	 * 
	 * @param a
	 *            the array
	 * @returns the median
	 */
	private int bucketSortMedians(int[][] arr, int[] medians) {
		ArrayList<int[]>[] bucket = new ArrayList[10000]; // each bucket is an arraylist containing a reference to the
															// respective arr
		for (int i = 0; i < bucket.length; i++)
			bucket[i] = new ArrayList<int[]>(); // initialize arraylists
		for (int i = 0; i < medians.length; i++) {
			bucket[medians[i]].add(arr[i]); // add to respective buckets based on median
		}
		int outPos = 0; // index for output
		for (int i = 0; i < bucket.length; i++) {
			ArrayList<int[]> currentBucket = bucket[i];
			int size = currentBucket.size();
			if (size != 0) {
				for (int j = 0; j < size; j++) {
					arr[outPos++] = currentBucket.get(j); // fill back original array
				}
			}
		}

		return (medians[499] + medians[500]) >> 1;
	}

	private void countingSort(int[] a) {
		int[] temp = new int[1000];
		int[] count = new int[10002]; // 0-10000, bucket with key as integer and value as count
		for (int i = 0; i < 1000; i++) // find total count of each integer value
			count[a[i] + 1]++;
		for (int i = 0; i < 10001; i++) // replace count with starting position
			count[i + 1] += count[i];
		for (int i = 0; i < 1000; i++) // fill temp array
			temp[count[a[i]]++] = a[i];
		System.arraycopy(temp, 0, a, 0, 1000); // copy to initial array
	}

	/**
	 * implementation of parallel counting sort
	 * 
	 * @param arr
	 *            the matrix
	 * @returns the median of medians
	 */
	@Override
	public int challengeFour(int[][] arr) {
		ExecutorService executor = Executors.newCachedThreadPool();
		CompletionService<Void> completionService = new ExecutorCompletionService<Void>(executor);
		for (final int[] row : arr) {
			// add each countingSort(row) as a task
			Callable<Void> c = new Callable<Void>() {
				@Override
				public Void call() {
					countingSort(row);
					return null;
				}
			};
			completionService.submit(c);
		}
		boolean errors = false;
		int received = 0;
		// wait until results are done
		while (received < 1000 && !errors) {
			Future<Void> resultFuture = null;
			try {
				resultFuture = completionService.take();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				resultFuture.get();
				received++;
			} catch (Exception e) {
				errors = true;
			}
		}

		// init medians array and fill
		int[] medians = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int[] row = arr[i];
			medians[i] = (row[499] + row[500]) >> 1;
		}

		// find median of medians
		return bucketSortMedians(arr, medians);
	}

	/**
	 * merge two sorted halves in an array
	 * 
	 * @param a
	 *            the array
	 * @param lo
	 *            the start index
	 * @param mid
	 *            the index where the halfs split
	 * @param hi
	 *            the end index
	 */
	private void merge(Comparable[] a, int lo, int mid, int hi) {
		Comparable[] temp = new Comparable[a.length];
		for (int k = lo; k <= hi; k++) {
			temp[k] = a[k]; // copy over
		}

		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = temp[j++];
			else if (j > hi)
				a[k] = temp[i++];
			else if (temp[j].compareTo(temp[i]) < 0)
				a[k] = temp[j++];
			else
				a[k] = temp[i++];
		}
	}

	/**
	 * swap two objects in an array
	 * 
	 * @param list
	 *            the list to be swapped
	 * @param i
	 *            the index to swap to j
	 * @param j
	 *            the index to swap to i
	 */
	private void swap(Object[] list, int i, int j) {
		Object temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	/**
	 * partition an array
	 * 
	 * @param arr
	 *            the array
	 * @param low
	 *            the start index
	 * @param high
	 *            the end index
	 * @return
	 */
	private int partition(Comparable[] arr, int lo, int hi) {
		Comparable pivot = arr[hi]; // pivot at end
		int i = lo - 1;

		for (int j = lo; j <= hi - 1; j++) {
			if (arr[j].compareTo(pivot) < 0) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, hi); // swap pivot to correct loc
		return i + 1;
	}

	/**
	 * implementation of quicksort
	 * 
	 * @param arr
	 *            the array
	 * @param i
	 *            the start index
	 * @param j
	 *            the end index
	 */
	private void quickSort(Comparable[] arr, int i, int j) {
		while (i < j) {
			int p = partition(arr, i, j); // partition and get pivot
			if (p - i < j - p) { // if left less than right
				quickSort(arr, i, p - 1); // quicksort the left
				i = p + 1; // iterative quicksort the right
			} else {
				quickSort(arr, p + 1, j); // quicksort the right
				j = p - 1; // iterative quicksort the left
			}
		}
	}

	/**
	 * implentation of binary search
	 * 
	 * @param arr
	 *            the array
	 * @param obj
	 *            the obj to search
	 * @return the index of obj
	 */
	private int binarySearch(Comparable[] arr, Comparable obj) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (arr[m].compareTo(obj) == 0) {
				return m;
			}
			if (arr[m].compareTo(obj) < 0) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}

	/**
	 * implementation of parallel quicksort
	 * 
	 * @param arr
	 *            the array
	 * @param query
	 *            the string to be searched
	 * @returns the index of the string
	 */
	@Override
	public int challengeFive(Comparable[] arr, Comparable query) {
		int mid = arr.length / 2; // split array
		ExecutorService executor = Executors.newFixedThreadPool(2); // two threads
		CompletionService<Void> completionService = new ExecutorCompletionService<Void>(executor);
		// first half
		Callable<Void> c = new Callable<Void>() {
			@Override
			public Void call() {
				quickSort(arr, 0, mid);
				return null;
			}
		};
		// second half
		Callable<Void> c1 = new Callable<Void>() {
			@Override
			public Void call() {
				quickSort(arr, mid + 1, arr.length - 1);
				return null;
			}
		};
		completionService.submit(c);
		completionService.submit(c1);

		int received = 0;
		boolean errors = false;

		// until all results are complete
		while (received < 2 && !errors) {
			Future<Void> resultFuture = null;
			try {
				resultFuture = completionService.take();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				resultFuture.get();
				received++;
			} catch (Exception e) {
				e.printStackTrace();
				errors = true;
			}
		}
		// merge back
		merge(arr, 0, mid, arr.length - 1);
		// find index of query
		return binarySearch(arr, query);
	}

	@Override
	public String greeting() {
		return "hi :-)";
	}

}
