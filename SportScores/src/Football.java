
public class Football extends TimeSports{
private int mostYardGained;
public Football (String nameSport, String name, String otherName,int score, int otherScore,
		int leftTime, int biggestPlay)
{
	super (nameSport, name, otherName, score, otherScore, leftTime);
	mostYardGained = biggestPlay;
}
public String bestPlay()
{
	return "In a single play, the most yards gained was " + mostYardGained + ".";
}
public String toString()
{
	return super.Winner() + " \n" + bestPlay();
}
}
