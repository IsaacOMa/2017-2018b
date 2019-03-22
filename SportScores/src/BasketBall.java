public class BasketBall extends TimeSports
{
  private int mostFouls;
  public BasketBall (String sportName, String teamName, String opponentTeam,
		  int teamScore, int opponentScore, int timeLeft, int foulsMost)
  {
    super(sportName, teamName, opponentTeam, teamScore, opponentScore, timeLeft);
    mostFouls = foulsMost;
  }
  public String fouls()
  {
    return "Currently the most fouls a single player has in this game is " + mostFouls + "!";
  }
  public String toString ()
  {
    return (super.Winner() + "\n" + fouls());
  }
}
    
