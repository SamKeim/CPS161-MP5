package fantasy_football;

import java.util.Scanner;

public class FantasyFootball {
	private int numberOfTeams; // Same as teamAverage.length.
	private int numberOfWeeks; // Same as weekAverage.length.
	private int[][] scores; // numberOfTeams rows and numberOfWeeks columns.
	private double[] weekAverage; // contains an entry for each week
	private double[] teamAverage; // contains an entry for each team
	private String[] teamName; // contains an entry for each team

	public void enterInData() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter number of teams: ");
		numberOfTeams = keyboard.nextInt();
		System.out.print("Enter number of weeks: ");
		numberOfWeeks = keyboard.nextInt();
		
		teamName = new String[numberOfTeams];
		scores = new int[numberOfTeams][numberOfWeeks];
		keyboard.nextLine();
		for (int team = 0; team < numberOfTeams; team++) {
			System.out.print("Enter team name: ");
			teamName[team] = keyboard.nextLine();
			
			for (int week = 0; week < numberOfWeeks; week++) {
				System.out.printf("Enter score for team %s on Week %d:\t", teamName[team], week + 1);
				scores[team][week] = keyboard.nextInt();
				keyboard.nextLine();
			}
		}
		keyboard.close();

	}

	public void fillTeamAverage() {
		teamAverage = new double[numberOfTeams];
		int sum;
		for(int team = 0; team < numberOfTeams; team++) {
			sum = 0;
			for(int week = 0; week < numberOfWeeks; week++) {
				sum += scores[team][week];
			}
			teamAverage[team] = (double)sum / numberOfWeeks;
		}
	}

	public void fillWeekAverage() {
		weekAverage = new double[numberOfWeeks];
		int sum;
		for(int week = 0; week < numberOfWeeks; week++) {
			sum = 0;
			for(int team = 0; team < numberOfTeams; team ++) {
				sum += scores[team][week];
			}
			weekAverage[week] = (double)sum / numberOfTeams;
		}
	}

	public void display() {
		String[] lines = new String[numberOfTeams + 2]; // + 1 for header, + 1 for weekly average

		// Generate Header
		lines[0] = String.format("%-20s", "Team Name");
		for(int i = 0; i < numberOfWeeks; i++) {
			lines[0] += String.format("%10s", "Week " + (i + 1));
		}
		
		// Generate Team Lines
		for(int i = 1; i <= numberOfTeams; i++) {
			lines[i] = String.format("%-20s", teamName[i - 1]);
			for(int w = 0; w < numberOfWeeks; w++) {
				lines[i] += String.format("%10d", scores[i - 1][w]);
			}
			lines[i] += String.format("%10s%.1f", "ave = ", teamAverage[i - 1]);
		}
		
		// Generate Last Line
		int last = lines.length - 1;
		lines[last] = String.format("%-20s", "Weekly Ave:");
		for(int i = 0; i < numberOfWeeks; i++) {
			lines[last] += String.format("%10.1f", weekAverage[i]);
		}
		
		for(String line: lines) {
			System.out.println(line);
		}
	}

	public static void main(String[] args) {
		FantasyFootball f = new FantasyFootball();
		f.enterInData();
		f.fillTeamAverage();
		f.fillWeekAverage();
		f.display();
	}

	public int getNumberOfTeams() {
		return numberOfTeams;
	}

	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}

	public int getNumberOfWeeks() {
		return numberOfWeeks;
	}

	public void setNumberOfWeeks(int numberOfWeeks) {
		this.numberOfWeeks = numberOfWeeks;
	}

	public int[][] getScores() {
		return scores;
	}

	public void setScores(int[][] scores) {
		this.scores = scores;
	}

	public double[] getWeekAverage() {
		return weekAverage;
	}

	public void setWeekAverage(double[] weekAverage) {
		this.weekAverage = weekAverage;
	}

	public double[] getTeamAverage() {
		return teamAverage;
	}

	public void setTeamAverage(double[] teamAverage) {
		this.teamAverage = teamAverage;
	}

	public String[] getTeamName() {
		return teamName;
	}

	public void setTeamName(String[] teamName) {
		this.teamName = teamName;
	}
	
	
}
