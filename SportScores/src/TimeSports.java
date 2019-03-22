
public class TimeSports extends SportTypes {

	private int teamScore;
	private int timeLeft;
	private int opponentScore;
	public TimeSports (String nameSport, String name, String otherName, int score, int otherScore, int leftTime)
	  {
		super (nameSport, name, otherName);
	    teamScore = score;
	    timeLeft = leftTime;
	    opponentScore = otherScore;
	  }  
	  public int ChangeScore(int newScore)
	  {
	    teamScore = newScore;
	    return teamScore;
	  }
	  public int ChangeOpponentScore(int newOtherScore)
	  {
	    opponentScore = newOtherScore;
	    return opponentScore;
	  }
	  public int ChangeTime(int newTime)
	  {
	    timeLeft = newTime;
	    return timeLeft;  
	  }
	  public int getScore()
	  {
	    return teamScore;
	  }
	  public int getTime()
	  {
	    return timeLeft;
	  }
	  public int getOpponentScore()
	  {
	    return opponentScore;
	  }
	  public String Winner ()
	  {
	    if (teamScore > opponentScore)
	    {
	      return ("In " + super.getSportName() + ", with " + timeLeft + " seconds left on the clock, the score is " + teamScore + " - " + opponentScore + ". \n"
	      		+ "The " + super.getTeamName() + " are winning.");
	    }
	    else if (opponentScore > teamScore)
	    {
	      return ("In " + super.getSportName() + ", with " + timeLeft + " seconds left on the clock, the score is " + teamScore + " - " + opponentScore + ". \n"
	        		+ "The " + super.getOpponentName() + " are winning.");
	    }
	    else 
	      return "In " + super.getSportName() + ", with " + timeLeft + " seconds left on the clock, the score is " + teamScore + " - " + opponentScore + ". \n"
	        		+ "The teams are tied";
	              
	  }
}
