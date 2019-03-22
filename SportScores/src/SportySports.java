public class SportySports
{
  public static void main (String args[])
  {
    Soccer soccerGame1 = new Soccer("Soccer", "Wannabes", "Strikers", 2, 3, 123, "James Bond");
    Football footBall1 = new Football("Football", "Soups", "Malts", 32, 28, 23, 47);
    BasketBall basketBall1 = new BasketBall ("Basket Ball", "Wolves", "Bears", 76, 65, 49, 8);
    MarathonRunning running1 = new MarathonRunning ("Marathon Running", "USA", "Britain", 109, 1, 2, 2163);
    System.out.println(soccerGame1);
    System.out.println();
    System.out.println(footBall1);
    System.out.println();
    System.out.println(basketBall1);
    System.out.println();
    System.out.println(running1);
  }
}
