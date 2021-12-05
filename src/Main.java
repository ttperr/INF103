import java.io.FileNotFoundException;
import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import maze.DepartureArrivalException;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;

public class Main {

	public static void main(String[] args)
			throws MazeReadingException, DepartureArrivalException, FileNotFoundException {
		Maze maze = new Maze(null);
		maze.initFromTextFile("data/labyrinthe.txt");

		MBox[] startAndEnd = maze.findStartAndEnd();
		MBox start = startAndEnd[0];
		MBox end = startAndEnd[1];

		PreviousInterface previous = Dijkstra.dijkstra(maze, start);
		ArrayList<VertexInterface> path = previous.getShortestPathTo(end);
		maze.showPath(path, "data/solution.txt");
		
		System.out.println("");
		
		Maze maze2 = new Maze(null);
		maze2.initFromTextFile("data/labyrinthe2.txt");

		MBox[] startAndEnd2 = maze2.findStartAndEnd();
		MBox start2 = startAndEnd2[0];
		MBox end2 = startAndEnd2[1];

		PreviousInterface previous2 = Dijkstra.dijkstra(maze2, start2);
		ArrayList<VertexInterface> path2 = previous2.getShortestPathTo(end2);
		maze2.showPath(path2, "data/solution2.txt");
	}

}
