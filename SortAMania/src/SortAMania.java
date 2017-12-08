import java.util.ArrayList;
import java.util.Arrays;

public class SortAMania {
	
	public static void main (String [] args)
	{
		SortUtilities utils = new SortUtilities();
		ArrayList<SortCompetition> bracket = new ArrayList<SortCompetition>();

		Team1SortCompetition team1 = new Team1SortCompetition();
		team1.setNumber(1);
		bracket.add(team1);
		
		Team2SortCompetition team2 = new Team2SortCompetition();
		bracket.add(team2);
		team2.setNumber(2);
		
		Team3SortCompetition team3 = new Team3SortCompetition();
		team3.setNumber(3);
		bracket.add(team3);
		
		Team4SortCompetition team4 = new Team4SortCompetition();
		team4.setNumber(4);
		bracket.add(team4);
		
		Team5SortCompetition team5 = new Team5SortCompetition();
		team5.setNumber(5);
		bracket.add(team5);
		
		Team6SortCompetition team6 = new Team6SortCompetition();
		team6.setNumber(6);
		bracket.add(team6);
		
		Team7SortCompetition team7 = new Team7SortCompetition();
		bracket.add(team7);
		team7.setNumber(7);
		
		Team8SortCompetition team8 = new Team8SortCompetition();
		team8.setNumber(8);
		bracket.add(team8);
		
		Team9SortCompetition team9 = new Team9SortCompetition();
		bracket.add(team9);
		team9.setNumber(9);
		
		Team10SortCompetition team10 = new Team10SortCompetition();
		team10.setNumber(10);
		bracket.add(team10);
		
		Team11SortCompetition team11 = new Team11SortCompetition();
		team11.setNumber(11);
		bracket.add(team11);
		
		Team12_SortCompetition team12 = new Team12_SortCompetition();
		bracket.add(team12);
		team12.setNumber(12);
		
		Team13SortCompetition team13 = new Team13SortCompetition();
		bracket.add(team13);
		team13.setNumber(13);
		
		Team14SortCompetition team14 = new Team14SortCompetition();
		bracket.add(team14);
		team14.setNumber(14);
		
		Team15SortCompetition team15 = new Team15SortCompetition();
		bracket.add(team15);
		team15.setNumber(15);
		
		Team16SortCompetition team16 = new Team16SortCompetition();
		bracket.add(team16);
		team16.setNumber(16);

		utils.scramble(bracket);
		
		Tournament CSA = new Tournament(bracket);
		
		//CSA.run(1);
		//CSA.run(2);
		//CSA.run(3);
		CSA.run(4);
		//CSA.run(5);
		
	}

}
