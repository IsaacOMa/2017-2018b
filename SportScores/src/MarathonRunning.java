
public class MarathonRunning extends RacingSports{

	private int elevationChange;
	public MarathonRunning (String nameSport, String name, String otherName, int TimeGone,
			int position, int otherPosition, int changeElevation)
	{
		super (nameSport, name, otherName, TimeGone, position, otherPosition);
		elevationChange = changeElevation;
	}
	public String toString()
	{
		return super.Race() + "\nThe elevation change in this course is " + elevationChange + " meters.";
	}
}
