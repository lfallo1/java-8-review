package com.lancefallon.hashequals;

public class ReportCard {

	private int mathScore;
	private int historyScore;
	private int scienceScore;

	public ReportCard(int mathScore, int historyScore, int scienceScore) {
		this.mathScore = mathScore;
		this.historyScore = historyScore;
		this.scienceScore = scienceScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public int getHistoryScore() {
		return historyScore;
	}

	public int getScienceScore() {
		return scienceScore;
	}
	
	public String getGrade(int score){
		String grade = "";
		if(score > 90){
			grade = "A";
		} else if(score > 80){
			grade = "B";
		} else if(score > 70){
			grade = "C";
		} else if(score > 60){
			grade = "D";
		} else{
			grade = "F";
		}
		return score + "(" + grade + ")";
	}

	@Override
	public String toString() {
		return "ReportCard [mathScore=" + getGrade(mathScore) +", historyScore=" + getGrade(historyScore) + ", scienceScore="
				+ getGrade(scienceScore) + "]";
	}
	
}
