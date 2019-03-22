public class Soccer extends TimeSports
{
  private String starPlayer;
  public Soccer (String sportName, String teamName, String opponentTeam, int teamScore, int opponentScore, int timeLeft, String bestPlayer)
  {
    super(sportName, teamName, opponentTeam, teamScore, opponentScore, timeLeft);
    starPlayer = bestPlayer;
  }
  public String Player()
  {
    return "The star player in this match, " + starPlayer + ", has earned his spot on the team!";
  }
  public String toString ()
  {
    return (super.Winner() + "\n" + Player());
  }
}
    
