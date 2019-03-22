
public class RacingSports extends SportTypes{
private int currentTime;
private int completed;
private int opponentCompleted;

public RacingSports (String nameSport, String name, String otherName, int TimeGone, int position, int otherPosition)
{
	super (nameSport, name, otherName);
	currentTime = TimeGone;
	completed = position;
	opponentCompleted = otherPosition;
}
public int getCurrentTime()
{
	return currentTime;
}


public String getWinning()
{
	if (completed > opponentCompleted)
	{
		return super.getTeamName() + " is winning";
	}
	else if (completed < opponentCompleted)
	{
		return super.getOpponentName() + " is winning.";
	}
	else
		return "the teams are tied.";
}


public String Race()
{
	return "In " + super.getSportName() + ", " + super.getTeamName() + " is facing " + super.getOpponentName() +
			". \n" + "Currently, " + getWinning() + " The competitors are " + currentTime + " minutes into the race.";
}
}
