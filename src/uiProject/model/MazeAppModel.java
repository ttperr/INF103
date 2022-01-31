package uiProject.model;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import algo.dijkstra.Dijkstra;
import algo.dijkstra.PreviousInterface;
import algo.dijkstra.VertexInterface;
import algo.maze.DepartureArrivalException;
import algo.maze.EBox;
import algo.maze.MBox;
import algo.maze.Maze;
import algo.maze.MazeReadingException;
import algo.maze.NoPathException;
import algo.maze.PBox;

/**
 * The Model class for the UI
 * 
 * @author Tristan Perrot
 *
 */
public class MazeAppModel {
	private Maze maze;
	private String selectedBoxLabel = "Empty";
	private boolean modified = false;
	private boolean exported = false;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	
	/**
	 * Initialize a 10x10 maze
	 */
	public MazeAppModel() {
		int width = 10;
		int height = 10;
		MBox[][] boxes = new MBox[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				boxes[i][j] = new EBox(i, j);
			}
		}
		maze = new Maze(boxes);
	}

	/**
	 * @return The maze
	 */
	public Maze getMaze() {
		return maze;
	}

	/**
	 * @param maze The maze to set
	 */
	public void setMaze(MBox[][] maze) {
		if (this.getMaze().getMaze() != maze) {
			this.maze = new Maze(maze);
			setModified(true);
			stateChanges();
		}
	}

	/**
	 * @return The selectedBoxLabel
	 */
	public String getSelectedBoxLabel() {
		return selectedBoxLabel;
	}

	/**
	 * @param selectedBoxLabel The currentBoxLabel to set
	 */
	public void setSelectedBoxLabel(String selectedBoxLabel) {
		if (!(this.selectedBoxLabel.equals(selectedBoxLabel))) {
			this.selectedBoxLabel = selectedBoxLabel;
			setModified(true);
			stateChanges();
		}
	}

	public void setBox(MBox box) {
		if (!(maze.getBox(box.getRow(), box.getColumn()).getLabel().equals(box.getLabel()))) {
			maze.setBox(box);
			setModified(true);
			stateChanges();
		}
	}

	/**
	 * @return if it's modified or not
	 */
	public boolean isModified() {
		return modified;
	}

	/**
	 * @param modified the new modified value
	 */
	public void setModified(boolean modified) {
		this.modified = modified;
	}

	/**
	 * @return the exported
	 */
	public boolean isExported() {
		return exported;
	}

	/**
	 * @param exported the exported to set
	 */
	public void setExported(boolean exported) {
		this.exported = exported;
	}

	/**
	 * Reset the maze to an empty maze
	 * 
	 * @param width  The new width
	 * @param height The new height
	 */
	public void reset(int width, int height) {
		setSelectedBoxLabel("Empty");
		MBox[][] rMaze = new MBox[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rMaze[i][j] = new EBox(i, j);
			}
		}
		setMaze(rMaze);
	}

	public final void initMazeFromTextFile(String fileName) throws MazeReadingException {
		maze.initFromTextFile(fileName);
		setModified(true);
		stateChanges();
	}

	/**
	 * Save the maze to a text file
	 * 
	 * @param fileName the file name of the exported file
	 */
	public final void exportMazeToTextFile(String fileName) {
		try {
			PrintWriter textF = new PrintWriter(new FileOutputStream(fileName));
			for (MBox[] listMBox : maze.getMaze()) {
				for (MBox box : listMBox) {
					textF.print(box.getLabel());
				}
				textF.print("\n");
			}
			textF.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Solve the actual maze
	 * 
	 * @throws DepartureArrivalException Throwed exception if there is not only one
	 *                                   arrival and one departure
	 */
	public final void solve() throws DepartureArrivalException, NoPathException {
		MBox[] startAndEnd = maze.findStartAndEnd();
		MBox start = startAndEnd[0];
		MBox end = startAndEnd[1];

		PreviousInterface previous = Dijkstra.dijkstra(maze, start);
		ArrayList<VertexInterface> path = previous.getShortestPathTo(end);

		if (!(path.get(path.size() - 1).isEqualTo(start))) {
			throw new NoPathException("your creation");
		} else {
			for (int i = 0; i < maze.getHeight(); i++) {
				for (int j = 0; j < maze.getWidth(); j++) {
					MBox box = maze.getBox(i, j);
					if (box.getLabel().equals(".")) {
						maze.setBox(new EBox(i, j));
						setModified(true);
						stateChanges();
					}
					if (path.contains(box) && !(box.isEqualTo(end)) && !(box.isEqualTo(start))) {
						maze.setBox(new PBox(i, j));
						setModified(true);
						stateChanges();
					}
				}
			}
		}
	}
	
	/**
	 * Add a listener for the UI
	 * 
	 * @param listener the listener to add
	 */
	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Execute the changes
	 */
	public void stateChanges() {
		setExported(false);
		ChangeEvent evt = new ChangeEvent(this);
		for (ChangeListener listener : listeners) {
			listener.stateChanged(evt);
		}
	}

}