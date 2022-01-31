package algo.maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import algo.dijkstra.GraphInterface;
import algo.dijkstra.VertexInterface;

/**
 * Maze class
 * 
 * A maze is represented by his vertices matrix (maze) and his dimensions
 * (width,height)
 * 
 * @author Tristan Perrot
 * 
 */
public final class Maze implements GraphInterface {
	private MBox[][] maze;
	private int width;
	private int height;

	public Maze(MBox[][] maze) {
		this.maze = maze;
		if (maze != null) {
			setWidth(maze[0].length);
			setHeight(maze.length);
		}
	}

	/**
	 * Return the vertices matrix
	 * 
	 * @return The vertices matrix
	 */
	public final MBox[][] getMaze() {
		return maze;
	}

	/**
	 * Return the width
	 * 
	 * @return Maze width
	 */
	public final int getWidth() {
		return width;
	}

	public final void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Return the height
	 * 
	 * @return Maze height
	 */
	public final int getHeight() {
		return height;
	}

	public final void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Return the box of coordinates (i, j)
	 * 
	 * @param i Line number
	 * @param j Column number
	 * @return The (i, j) box
	 */
	public MBox getBox(int i, int j) {
		return maze[i][j];
	}

	/**
	 * Replace a box in maze by a new box given
	 * 
	 * @param box The new box
	 */
	public void setBox(MBox box) {
		maze[box.getRow()][box.getColumn()] = box;
	}

	/**
	 * Return the set of all graph vertices
	 * 
	 * @return The list of all the vertices
	 **/
	@Override
	public final ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> vertices = new ArrayList<VertexInterface>();

		for (MBox[] listMBox : maze) {
			for (MBox box : listMBox) {
				vertices.add(box);
			}
		}
		return vertices;
	}

	/**
	 * Add a nextVertex vertex to the successors list if it's reachable from the
	 * vertex vertex
	 * 
	 * @param vertex     The origin vertex
	 * @param nextVertex The arrival vertex
	 * @param successors The neighbors temporary list of the vertex
	 * @return The neighbors list
	 **/
	private final void addSuccessors(ArrayList<VertexInterface> successors, VertexInterface vertex,
			VertexInterface nextVertex) {
		Double posInf = Double.POSITIVE_INFINITY;
		Double weight = getWeight(vertex, nextVertex);
		if (weight < posInf) {
			successors.add(nextVertex);
		}
	}

	/**
	 * Return the neighbor list of a vertex in the graph
	 * 
	 * @param vertex The vertex whose neighbors we are looking for
	 * @return The neighbors list
	 **/
	@Override
	public final ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();

		MBox box = (MBox) vertex;
		int row = box.getRow();
		int column = box.getColumn();

		if (column - 1 >= 0) {
			MBox nextVertexLeft = maze[row][column - 1];
			addSuccessors(successors, box, nextVertexLeft);
		}

		if (column + 1 < width) {
			MBox nextVertexRight = maze[row][column + 1];
			addSuccessors(successors, box, nextVertexRight);
		}

		if (row - 1 >= 0) {
			MBox nextVertexUp = maze[row - 1][column];
			addSuccessors(successors, box, nextVertexUp);
		}

		if (row + 1 < height) {
			MBox nextVertexDown = maze[row + 1][column];
			addSuccessors(successors, box, nextVertexDown);
		}
		return successors;
	}

	/**
	 * Return the weight in the graph of an edge between two vertices
	 * 
	 * @param src The origin vertex
	 * @param dst The arrival vertex
	 * @returnThe weight of the edge src-dst
	 **/
	@Override
	public final Double getWeight(VertexInterface src, VertexInterface dst) {
		MBox srcBox = (MBox) src;
		MBox dstBox = (MBox) dst;

		int dstRowLength = Math.abs(srcBox.getRow() - dstBox.getRow());
		int dstColumnLength = Math.abs(srcBox.getColumn() - srcBox.getColumn());

		return (srcBox.getLabel().equals("W") || dstBox.getLabel().equals("W") || dstRowLength > 1
				|| dstColumnLength > 1
				|| (dstBox.getColumn() == srcBox.getColumn() && dstBox.getRow() == srcBox.getRow()))
						? Double.POSITIVE_INFINITY
						: 1;
	}

	/**
	 * Initialize a Maze from a text file
	 * 
	 * @param fileName File address
	 * @throws MazeReadingException Exception link to the file reading
	 */
	public final void initFromTextFile(String fileName) throws MazeReadingException {
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			int lineLength = line.length();
			int row = 0;
			ArrayList<MBox[]> arrayMaze = new ArrayList<MBox[]>();
			do {
				MBox[] boxesLine = new MBox[lineLength];
				for (int column = 0; column < lineLength; column++) {
					if (line.length() == lineLength) {
						char charAt = line.charAt(column);
						if (charAt == 'E') {
							boxesLine[column] = new EBox(row, column);
						} else if (charAt == 'W') {
							boxesLine[column] = new WBox(row, column);
						} else if (charAt == 'A') {
							boxesLine[column] = new ABox(row, column);
						} else if (charAt == 'D') {
							boxesLine[column] = new DBox(row, column);
						} else {
							throw new MazeReadingException(fileName, row, column, "Unknown character readed");
						}
					} else {
						throw new MazeReadingException(fileName, row, column, "Maze is not rectangular");
					}
				}
				arrayMaze.add(boxesLine);
				row++;

			} while ((line = br.readLine()) != null);

			br.close();
			setHeight(row);
			setWidth(lineLength);
			maze = new MBox[height][width];

			for (int i = 0; i < height; i++) {
				maze[i] = arrayMaze.get(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Return the [departure box, arrival box] list of the maze
	 * 
	 * @return The departure and arrival box list
	 * @throws DepartureArrivalException
	 */
	public final MBox[] findStartAndEnd() throws DepartureArrivalException {
		MBox[] startAndEnd = new MBox[2];
		for (MBox[] listMBox : maze) {
			for (MBox box : listMBox) {
				if (box.getLabel().equals("D")) {
					if (startAndEnd[0] == null) {
						startAndEnd[0] = box;
					} else
						throw new DepartureArrivalException(box.getRow() + 1, box.getColumn() + 1,
								"More than one start box");
				} else if (box.getLabel().equals("A")) {
					if (startAndEnd[1] == null) {
						startAndEnd[1] = box;
					} else
						throw new DepartureArrivalException(box.getRow() + 1, box.getColumn() + 1,
								"More than one end box");
				}
			}
		}
		if (startAndEnd[0] == null) {
			throw new DepartureArrivalException(-1, -1, "No start box");
		} else if (startAndEnd[0] == null) {
			throw new DepartureArrivalException(-1, -1, "No end box");
		}
		return startAndEnd;
	}

	/**
	 * Show on the console the path and save the answer in a text file
	 * 
	 * @param path     Departure to arrival path
	 * @param fileName File name where the solution has to be saved
	 * @throws DepartureArrivalException Throwed exception if there is not only one
	 *                                   arrival and one departure
	 * @throws FileNotFoundException     Throwed exception when the file si not
	 *                                   found
	 * @throws NoPathException           Throwed exception when the maze has no
	 *                                   solution
	 */
	public final void showPath(ArrayList<VertexInterface> path, String fileName)
			throws DepartureArrivalException, FileNotFoundException, NoPathException {
		try {
			MBox[] startAndEnd = findStartAndEnd();
			MBox start = startAndEnd[0];
			MBox end = startAndEnd[1];
			if (!(path.get(path.size() - 1).isEqualTo(start))) {
				throw new NoPathException(fileName);
			} else {
				PrintWriter textF = new PrintWriter(new FileOutputStream(fileName));
				for (MBox[] listMBox : maze) {
					for (MBox box : listMBox) {
						if (path.contains(box) && !(box.isEqualTo(end)) && !(box.isEqualTo(start))) {
							System.out.print(".");
							textF.print(".");
						} else {
							System.out.print(box.getLabel());
							textF.print(box.getLabel());
						}
					}
					System.out.print("\n");
					textF.print("\n");
				}
				textF.close();
			}
		} catch (NoPathException | DepartureArrivalException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
