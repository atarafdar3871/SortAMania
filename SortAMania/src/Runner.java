
import Team12_SortCompetition;

public class Runner {
	
	public static void main(String[] args)
	{
		Team12_SortCompetition example = new Team12_SortCompetition();
		
		//CHALLENGE ONE 
			int[] list1 = {1,5,3,2,7,9,3}; //1,2,3,3,5,7,9
			//int[] list2 = {7,7,1,3,2,8};
			
			//printArr(mergeSort(merge(list1,list2)));
			example.printArr(example.mergeSort(list1));
			System.out.print(example.challengeOne(list1));
		
		//CHALLENGE TWO
			String[] list = {"quiet", "heart", "loved", "hated", "sport"};
			
			System.out.println(example.challengeTwo(list, "hated"));
			example.printArr(example.mergeSort(list));
			
		//CHALLENGE THREE
			int[] list3 = {1,5,3,2,7,9,3};
			//int[] list2 = {7,7,1,3,2,8};
			
			//printArr(mergeSort(merge(list1,list2)));
			example.printArr(example.mergeSort(list3));
			System.out.print(example.challengeThree(list3));
			
		//CHALLENGE FOUR
			 int[][] list4 = {{1,3,5},{6,8,3},{100,50,20}};				
				
			 System.out.print(example.challengeFour(list4));
			 
		//CHALLENGE FIVE
	
	}
	
}
