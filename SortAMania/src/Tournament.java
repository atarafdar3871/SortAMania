import java.util.ArrayList;
import java.util.Arrays;

public class Tournament {
	ArrayList<SortCompetition> teams;
	
	Tournament(ArrayList<SortCompetition> teams)
	{
		this.teams = teams;
	}
	

	
	public void run(int challenge)
	{
		SortUtilities utils = new SortUtilities();
		ArrayList<SortCompetition> local  = teams;
		int size = local.size();
		utils.rollcall(local);
		while (local.size() > 1)
		{
			SortCompetition Team1 = local.remove(0);
			SortCompetition Team2 = local.remove(0);



			
			SortCompetition winner = challenge(Team1, Team2, challenge);
			local.add(winner);
			System.out.println("Moving on: " + "Team " + winner.getNum());
			System.out.println();
			utils.pause(1000);
			if (size % 2 == 0 && local.size() == size/2)
			{
				size = local.size();;
				utils.rollcall(local);
			}
			else if (size %2 == 1 && local.size() == size/2+1)
			{
				size = local.size();
				utils.rollcall(local);
			}
			utils.pause(5000);
;
		}
		System.out.println("Your winner of challenge: " + challenge);
		System.out.println(local.get(0).greeting());
	}

	public SortCompetition challenge(SortCompetition team1, SortCompetition team2, int challenge)
	{
		switch (challenge)
		{
			case 1:
				return (challengeOne(team1, team2));
			case 2:
				return (challengeTwo(team1, team2));				
			case 3:
				return (challengeThree(team1, team2));
			case 4:
				return (challengeFour(team1, team2));
			case 5:
				return (challengeFive(team1, team2));
			default:
				break;
		}
		return team1;
	}

	
	public SortCompetition challengeOne(SortCompetition team1, SortCompetition team2)
	{
		int reps = 12;
		int index = 0;
		double average1 = Double.MAX_VALUE;
		double average2 = Double.MAX_VALUE;
		double[] times  = new double[reps];
		int median = 0;
		
		System.out.println(team1.greeting());
		System.out.println(team2.greeting());
		SortUtilities utils = new SortUtilities();
		
		//Test run for correctness


		System.out.println("\nChallenge 1 Team - " + team1.getNum());
		
		int[] arr = utils.randomIntsArr(10000);
		int[] copy = Arrays.copyOf(arr, arr.length);
		
		try {
			median = team1.challengeOne(arr);
			utils.checkTest1(arr, copy, median);
			System.out.println();
			
			times = new double[reps];
			for (int i = reps; i>0; i--)
			{
				arr = utils.randomIntsArr(10000);
				
				double start = (double)System.nanoTime();
				team1.challengeOne(arr);
				double time = (double)System.nanoTime() - start;
				time = time/1000000.0;
				times[i-1] = time;
				System.out.print(time+"  ");
			}
	
			average1 = utils.score(times);
		}
		
		catch(StackOverflowError e)
		{
			System.out.println("Team " + team1.getNum() + "threw an error, oh no!");
			average1 = Double.MAX_VALUE;
		}
		
		
		reps = 12;
		System.out.println("\nChallenge 1 Team - " + team2.getNum());
		arr = utils.randomIntsArr(10000);
		copy = Arrays.copyOf(arr, arr.length);
		try {
			
			median = team2.challengeOne(arr);
			utils.checkTest1(arr, copy, median);
			System.out.println();
			
			times = new double[reps];
			for (int i = reps; i>0; i--)
			{
				arr = utils.randomIntsArr(10000);
				
				double start = (double)System.nanoTime();
				team2.challengeOne(arr);
				double time = (double)System.nanoTime() - start;
				time = time/1000000.0;
				times[i-1] = time;
				System.out.print(time + "  ");
			}

			average2 = utils.score(times);
		}
		
		catch (StackOverflowError e)
		{
			System.out.println("Team " + team2.getNum() + "threw an error, oh no!");
			average2 = Double.MAX_VALUE;
		}
		
		team1.addTime(average1);
		team2.addTime(average2);
		if (average1 < average2)return team1;
		else return team2;
	}
	
	public SortCompetition challengeTwo(SortCompetition team1, SortCompetition team2)
	{
		int reps = 12;
		int size = 10000;
		int sLength = 5;
		int index = 0;
		double average1 = Double.MAX_VALUE;
		double average2 = Double.MAX_VALUE;
		double[] times  = new double[reps];
		
		SortUtilities utils = new SortUtilities();
		String[] sArr = utils.randomStringArr(size, sLength);
		String Key = sArr[(int)Math.random()*sArr.length];
		String[] copy = Arrays.copyOf(sArr,sArr.length);

		try {
			System.out.println("\nChallenge 2 Team - " + team1.getNum());
			index = team1.challengeTwo(sArr, Key);
			utils.checkTest2(sArr, copy, index, Key);
			System.out.println();
			
			times = new double[reps];
			for (int i = reps; i>0; i--)
			{
				sArr = utils.randomStringArr(size, sLength);
				Key = sArr[(int)Math.random()*size];
				
				double start = (double)System.nanoTime();
				team1.challengeTwo(sArr, Key);
				double time = (double)System.nanoTime() - start;
				time = time/1000000.0;
				times[i-1] = time;
				System.out.print(time+"  ");
			}
			average1 = utils.score(times);
		
		}
		catch(StackOverflowError e)
		{

			System.out.println("Team " + team1.getNum() + "threw an error, oh no!");
			average1 = Double.MAX_VALUE;
		}
		
		reps = 12;
	
		
		sArr = utils.randomStringArr(size, sLength);
		Key = sArr[(int)Math.random()*size];
		copy = Arrays.copyOf(sArr,sArr.length);
	
		try {
			System.out.println("\nChallenge 2 Team - " + team2.getNum());
			index = team2.challengeTwo(sArr, Key);
			utils.checkTest2(sArr, copy, index, Key);
			System.out.println();
			
			
		
			times = new double[reps];
			for (int i = reps; i>0; i--)
			{
				sArr = utils.randomStringArr(size, sLength);
				Key = sArr[(int)Math.random()*size];
				
				double start = (double)System.nanoTime();
				team2.challengeTwo(sArr, Key);
				double time = (double)System.nanoTime() - start;
				time = time/1000000.0;
				times[i-1] = time;
				System.out.print(time+"  ");
			}
			average2 = utils.score(times);
		}
		catch(StackOverflowError e)
		{
			System.out.println("Team " + team2.getNum() + "threw an error, oh no!");
			average2 = Double.MAX_VALUE;
		}
		
		team1.addTime(average1);
		team2.addTime(average2);
		
		if (average1 < average2)return team1;
		else return team2;
		
	}
	
	public SortCompetition challengeThree(SortCompetition team1, SortCompetition team2)
	{
		int reps = 12;

		System.out.println(team1.greeting());
		System.out.println(team2.greeting());
		SortUtilities utils = new SortUtilities();
		
		//Test run for correctness


		System.out.println("\nChallenge 1 Team - " + team1.getNum());
		
		int[] arr = utils.randomIntsArr(10000);
		int[] copy = Arrays.copyOf(arr, arr.length);
		int median = team1.challengeThree(arr);
		utils.checkTest1(arr, copy, median);
		System.out.println();
		
		double[] times = new double[reps];
		for (int i = reps; i>0; i--)
		{
			arr = utils.randomIntsArr(10000);
			utils.unSort(arr);
			
			double start = (double)System.nanoTime();
			team1.challengeThree(arr);
			double time = (double)System.nanoTime() - start;
			time = time/1000000.0;
			times[i-1] = time;
			System.out.print(time+"  ");
		}

		double average1 = utils.score(times);
		
		
		reps = 12;
		System.out.println("\nChallenge 1 Team - " + team2.getNum());
		arr = utils.randomIntsArr(10000);
		copy = Arrays.copyOf(arr, arr.length);
		median = team2.challengeThree(arr);
		utils.checkTest1(arr, copy, median);
		System.out.println();
		
		times = new double[reps];
		for (int i = reps; i>0; i--)
		{
			arr = utils.randomIntsArr(10000);
			utils.unSort(arr);
			double start = (double)System.nanoTime();
			team2.challengeThree(arr);
			double time = (double)System.nanoTime() - start;
			time = time/1000000.0;
			times[i-1] = time;
			System.out.print(time + "  ");
		}

		double average2 = utils.score(times);
		
		team1.addTime(average1);
		team2.addTime(average2);
		
		if (average1 < average2)return team1;
		else return team2;
	}
	
	public SortCompetition challengeFour(SortCompetition team1, SortCompetition team2)
	{
		int reps = 12;
		int index = 0;
		double average1 = Double.MAX_VALUE;
		double average2 = Double.MAX_VALUE;
		double[] times  = new double[reps];
		int median = 0;
		
		System.out.println("\n" + team1.greeting());
		System.out.println("\n" + team2.greeting());
		SortUtilities utils = new SortUtilities();
		
		
		int[][] bigArr = utils.randomIntsArr1(1000);
		

		int[][] copy4 = bigArr;

		System.out.println("\nChallenge 4 Team - " + team1.getNum());
		try {
			median = (int)team1.challengeFour(bigArr);
			
			utils.checkTest4(bigArr, copy4, median);
			System.out.println();
			
			for (int i = reps; i>0; i--)
			{
				bigArr = utils.randomIntsArr1(1000);
				
				double start = (double)System.nanoTime();
				team1.challengeFour(bigArr);
				double time = (double)System.nanoTime() - start;
				time = time/1000000.0;
				times[i-1] = time;
				System.out.print(time+"  ");
			}
	
			average1 = utils.score(times);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Team " + team1.getNum() + "threw an error, oh no!");
			average1 = Double.MAX_VALUE;
		}
		reps = 12;

		
		bigArr = utils.randomIntsArr1(100);
		copy4 = bigArr;

		System.out.println("\nChallenge 4 Team - " + team2.getNum());
		try {
			median = (int)team2.challengeFour(bigArr);
			
			utils.checkTest4(bigArr, copy4, median);
			System.out.println();
			
			for (int i = reps; i>0; i--)
			{
				bigArr = utils.randomIntsArr1(1000);
				
				double start = (double)System.nanoTime();
				team2.challengeFour(bigArr);
				double time = (double)System.nanoTime() - start;
				time = time/1000000.0;
				times[i-1] = time;
				System.out.print(time+"  ");
			}
	
			average2 = utils.score(times);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Team " + team2.getNum() + "threw an error, oh no!");
			average2 = Double.MAX_VALUE;
		}
		
		
		team1.addTime(average1);
		team2.addTime(average2);
		
		if (average1 < average2)return team1;
		else return team2;
	}
	public SortCompetition challengeFive(SortCompetition team1, SortCompetition team2)
	{

		System.out.println(team1.greeting());
		System.out.println(team2.greeting());
		SortUtilities utils = new SortUtilities();


		System.out.println("\nChallenge 2 Team - " + team1.getNum());
		
		Generic[] arr = utils.randomGeneric(10000);
		int reps = 12;
		int size = 10000;
		int index = 0;
		
		double average1 = Double.MAX_VALUE;
		double average2 = Double.MAX_VALUE;
		double[] times  = new double[reps];
		
		Generic Key = arr[(int)Math.random()*arr.length];
		Generic[] copy = Arrays.copyOf(arr,arr.length);

		try {
			System.out.println("\nChallenge 5 Team - " + team1.getNum());
			index = team1.challengeFive(arr, Key);
			utils.checkTest5(arr, copy, index, Key);
			System.out.println();
			
			times = new double[reps];
			for (int i = reps; i>0; i--)
			{
				arr = utils.randomGeneric(10000);
				Key = arr[(int)(Math.random()*arr.length)];
				
				double start = (double)System.nanoTime();
				team1.challengeFive(arr, Key);
				double time = (double)System.nanoTime() - start;
				time = time/1000000.0;
				times[i-1] = time;
				System.out.print(time+"  ");
			}
			average1 = utils.score(times);
		
		}
		catch(StackOverflowError e)
		{

			System.out.println("Team " + team1.getNum() + "threw an error, oh no!");
			average1 = Double.MAX_VALUE;
		}
		
		reps = 12;
	
		
		arr = utils.randomGeneric(10000);
		Key = arr[(int)Math.random()*arr.length];
		copy = Arrays.copyOf(arr,arr.length);
	
		try {
			System.out.println("\nChallenge 5 Team - " + team2.getNum());
			index = team2.challengeFive(arr, Key);
			utils.checkTest5(arr, copy, index, Key);
			System.out.println();
			
			times = new double[reps];
			for (int i = reps; i>0; i--)
			{
				arr = utils.randomGeneric(10000);
				Key = arr[(int)(Math.random()*arr.length)];
				
				double start = (double)System.nanoTime();
				team2.challengeFive(arr, Key);
				double time = (double)System.nanoTime() - start;
				time = time/1000000.0;
				times[i-1] = time;
				System.out.print(time+"  ");
			}
			average1 = utils.score(times);
		}
		catch(StackOverflowError e)
		{
			System.out.println("Team " + team2.getNum() + "threw an error, oh no!");
			average2 = Double.MAX_VALUE;
		}
		
		
		team1.addTime(average1);
		team2.addTime(average2);
		
		if (average1 < average2)return team1;
		else return team2;
		
	}
	
	
}
