import java.util.Arrays;
import java.util.Random;

/*
*	Authors: Amir Hasan & Justin Fagan
*	Last Updated: 12-7-2017
*	Description: Sort competition class for team 13.
*/
public class Team13SortCompetition extends SortCompetition
{
	public static void main(String[] args)
	{
		/*Team13SortCompetition test= new Team13SortCompetition();
		long startTime;
		long endTime;
		long totalTime;
		long avgTime;
		long sumTime=0;
		int count=0;
		while(count<10)
		{
			int[] sortish= generateRandomIntArray(10000);
			startTime=System.nanoTime();
			test.challengeOne(sortish);
			endTime=System.nanoTime();
			totalTime=endTime-startTime;
			System.out.println(totalTime);
			sumTime+=totalTime;
			count++;
		}
		avgTime=sumTime/10;
		System.out.println(avgTime);*/
	}
	public int challengeOne(int[] arr)
	{
		radixSort(arr);
		return getMedian(arr);
	}
	//insertion sort
	public int challengeTwo(String[] list1,String find)
	{
		int tracker;
		int pos=-1;
		for(int x=1;x<list1.length;x++)
		{
			tracker=x;
			while(tracker>0&&list1[tracker].compareTo(list1[tracker-1])<0)
			{
				swap(list1,tracker,tracker-1);
				tracker--;
			}
		}
		for(int y=0;y<list1.length;y++)
		{
			if(list1[y].equals(find))
			{
				pos=y;
				return pos;
			}
		}
		return pos;
	}
	//insertion sort
	public int challengeThree(int[] list)
	{
		int tracker;
		for(int x=1;x<list.length;x++)
		{
			tracker=x;
			while(tracker>0&&list[tracker]<list[tracker-1])
			{
				swap(list,tracker,tracker-1);
				tracker--;
			}
		}
		return getMedian(list);
	}
	//insertion sort on each nested array and records the median, then takes the median of those medians after sorting them
	public int challengeFour(int[][] list)
	{
		int[] meds=new int[list.length];
		for(int x=0;x<list.length;x++)
		{
			meds[x]=challengeThree(list[x]);
		}
		return challengeThree(meds);
	}
	public int challengeFive(Comparable[] list,Comparable obj)
	{
		mergeSort(list);
		for(int x=0;x<list.length;x++)
		{
			if(list[x].compareTo(obj)==0)
			{
				return x;
			}
		}
		return -1;
	}
	public static String[] merge(String[] list1,String[] list2)
	{
		int size= list1.length+list2.length;
		String[] result=new String[size];
		int i=0; //current position in result
		int j=0; //current position in list1
		int k=0; //current position in list2
		while(i<size)
		{
			if(j<list1.length&&k<list2.length)
			{
				if(list1[j].compareTo(list2[k])<0)
				{
					result[i]=list1[j];
					j++;
				}
				else
				{
					result[i]=list2[k];
					k++;
				}
			}
			else if(j==list1.length)
			{
				result[i]=list2[k];
				k++;
			}
			else
			{
				result[i]=list1[j];
				j++;
			}
			i++;
		}
		return result;
	}
	//challengeFive
	public static Comparable[] merge(Comparable[] list1,Comparable[] list2)
	{
		int size= list1.length+list2.length;
		Comparable[] result=new Comparable[size];
		int i=0; //current position in result
		int j=0; //current position in list1
		int k=0; //current position in list2
		while(i<size)
		{
			if(j<list1.length&&k<list2.length)
			{
				if(list1[j].compareTo(list2[k])<0)
				{
					result[i]=list1[j];
					j++;
				}
				else
				{
					result[i]=list2[k];
					k++;
				}
			}
			else if(j==list1.length)
			{
				result[i]=list2[k];
				k++;
			}
			else
			{
				result[i]=list1[j];
				j++;
			}
			i++;
		}
		return result;
	}
	//mergeSort
	public static Comparable[] mergeSort(Comparable[] list)
	{
		if(list.length>1)
		{
			Comparable[] list1=new Comparable[list.length/2];
			Comparable[] list2=new Comparable[list.length-list1.length];
			int z=0;
			for(int x=0;x<list1.length;x++)
			{
				list1[x]=list[x];
				z=x+1;
			}
			for(int y=0;y<list2.length;y++)
			{
				list2[y]=list[z];
				z++;
			}
			Comparable[] sort1=mergeSort(list1);
			Comparable[] sort2=mergeSort(list2);
			Comparable[] newList=merge(sort1,sort2);
			return newList;
		}
		return list;
	}
	//swaps 2 strings in an array
	public static void swap(String arr[],int i, int j)
	{
		String x=arr[i];
		arr[i]=arr[j];
		arr[j]=x;
	}
	//given a sorted array, retrieves the median
	public static int getMedian(int[] list)
	{
		if(list.length%2==1)
		{
			return list[list.length/2];
		}
		else
		{
			return (list[list.length/2]+list[(list.length/2)-1])/2;
		}
	}
	//swaps two objects in an array
	public static void swap(Object arr[],int i, int j)
	{
		Object x=arr[i];
		arr[i]=arr[j];
		arr[j]=x;
	}
	//swaps two ints in an array
	public static void swap(int arr[],int i, int j)
	{
		int x=arr[i];
		arr[i]=arr[j];
		arr[j]=x;
	}
	public String greeting()
	{
		return "Hello, this is team 13's sort class.";
	}
	public static int findMax(int arr[])
    {
        int max=arr[0];
        for (int i=1;i<arr.length;i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }
	//count sort for radix
	public static void countSortRadix(int[] arr, int max, int pow)
	{
		int[] count = new int[max+1];
		int sums=0;
		int[] output=new int[arr.length];
		Arrays.fill(count,0);
		for(int x=0;x<arr.length;x++)
		{
			count[(arr[x]/pow)%10]+=1;
		}
		sums=count[0];
		for(int y=1;y<count.length;y++)
		{
			sums+=count[y];
			count[y]=sums;
		}
		for(int z=arr.length-1;z>-1;z--)
		{
			int num=(arr[z]/pow)%10;
			count[num]=count[num]-1;
			output[count[num]]=arr[z];
		}
		for(int q=0;q<arr.length;q++)
		{
			arr[q]=output[q];
		}
	}
	//radix sort
	public static void radixSort(int arr[])
    {
        int max = findMax(arr);
        for (int pow=1;max/pow>0;pow*=10)
        {
            countSortRadix(arr, max, pow);
        }
    }
    private static int getRandomInteger(int low, int high)
	{
		if(low>high)
		{
			int swap=low;
			low=high;
			high=swap;
		}
		return (int)(Math.random()*(high-(low-1))+low);
	}
    private static String generateRandomString() {
    	String aToZ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand=new Random();
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < 17; i++) {
           int randIndex=rand.nextInt(aToZ.length()); 
           res.append(aToZ.charAt(randIndex));            
        }
        return res.toString();
    }
    private static int[] generateRandomIntArray(int size)
	{
		int[] randomArray= new int[size];
		for(int i=0;i<randomArray.length;i++)
		{
			randomArray[i]=getRandomInteger(0,size);
		}
		return randomArray;
	}
	private static String[] generateStringArray(int size) {
        String[]randomArray=new String[size];
        for(int i=0;i<randomArray.length;i++)
        {
        	randomArray[i]=generateRandomString();
        }
        return randomArray;
    }
	private static void printArr(int[] list)
	{
		for(int h:list)
		{
			System.out.print("["+h+"] ");
		}
		System.out.println();
	}
}