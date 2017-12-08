import java.util.Arrays;

public class SortCompetitionRunner {
	
	public static void main(String[] args) {
		Team6SortCompetition bot = new Team6SortCompetition();
		
		System.out.println(bot.greeting());System.out.println();
		
		int[] list1 = {5,4,3,2,1,3,3,3,3,5,5,2,5,235,342,4,4,4,2,3,54,6,2,3,4,5,2,2,5,3,23,5,3,2};
		long startTime = System.nanoTime();
		System.out.println("Median: " + bot.challengeOne(list1));
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println(duration * 1e-6 + "ms");System.out.println();
		
		String[] list2 = {"apple", "kites", "darts", "doggy", "mouse", "eleph", "aleph"};
		long startTime2 = System.nanoTime();
		System.out.println("String Position: " + bot.challengeTwo(list2, "mouse"));
		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2);
		System.out.println(duration2 / 1e-6 + "ms");System.out.println();
		
		int[] list3 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,18,20,16,17};
		long startTime3 = System.nanoTime();
		System.out.println("Median: " + bot.challengeThree(list3));
		long endTime3 = System.nanoTime();
		long duration3 = (endTime3 - startTime3);
		System.out.println(duration3 / 1e-6 + "ms");System.out.println();
		
		int[][] list4 = new int[][]{
			  { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
			  { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 },
			  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			  { 100, 200, 300, 400, 500, 500, 600, 700, 800, 900 },
			  { 10, 20, 30, 40, 50, 60, 60, 60, 60, 90 }
			};
		System.out.println(bot.challengeFour(list4));
		
	}
}
