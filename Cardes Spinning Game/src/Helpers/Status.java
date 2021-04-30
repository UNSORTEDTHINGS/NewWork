package Helpers;

public enum Status {
	
	NONE("SORRY BETTER LUCK NEXT TIME "),
	TWO_CARDS("GREAT YOU GOT TWO CARDS MATCHED"),
	ALL_CARDS("AMAZING YOU ARE LUCKY ,CONGRATES"),
	JOKER("EXCELLENT YOU GOT THE JOKER CARD"),
	KING("YOU HAVE THE KINGS LUCK !! GOOD JOB");
	
	String comment;

	private Status(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	
	

}
