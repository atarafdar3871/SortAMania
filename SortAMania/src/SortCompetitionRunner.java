
public class SortCompetitionRunner {
	
	public static void main(String[] args) {
		Team6SortCompetition bot = new Team6SortCompetition();
		
		int[] list1 = {5,4,3,2,1,3,3,3,3,5,5,2,5,235,342,4,4,4,2,3,54,6,2,3,4,5,2,2,5,3,23,5,3,2};
		System.out.println(bot.challengeOne(list1));
		long startTime = System.nanoTime();
		System.out.println(bot.challengeThree(list1));
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println(duration);
		
		String[] list2 = {"apple", "kites", "darts", "doggy", "mouse", "eleph", "aleph"};
		long startTime2 = System.nanoTime();
		System.out.println(bot.challengeTwo(list2, "mouse"));
		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2);
		System.out.println(duration2);
	}
}
