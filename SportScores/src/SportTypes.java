public class SportTypes
{
  private String teamName;
  private String opponentName;
  private String sportName;
  
  public SportTypes (String nameSport, String name, String otherName)
  {
    teamName = name;
    opponentName = otherName;
    sportName = nameSport;
  }     
  public String getSportName()
  {
	  return sportName;
  }
 
  
  public String getTeamName()
  {
	  return teamName;
  }
 
  
  public String getOpponentName()
  {
	  return opponentName;
  }
}

