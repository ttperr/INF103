import maze.Maze;

public class MainTest {

	public static void main(String[] args) {
		Maze maze = new Maze();
		maze.initFromTextFile("data/labyrinthe.txt");
	}

}
