package uiProject.model;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.event.*;

import algo.dijkstra.*;
import algo.maze.*;

import uiProject.vue.*;
import uiProject.vue.maze.NoPathException;

public class MazeAppModel {
	private Maze maze;
	private String selectedBoxLabel = "Empty";
	private boolean modified = false;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();

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
		if (this.selectedBoxLabel != selectedBoxLabel) {
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
	 * Reset the maze to an empty maze
	 * 
	 * @param width  The new width
	 * @param height The new height
	 */
	public void reset(int width, int height) {
		setCurrentBoxLabel("E");
		MBox[][] rMaze = new MBox[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rMaze[i][j] = new EBox(i, j);
			}
		}
		setMaze(rMaze);
	}

	/**
	 * Save the maze to a text file
	 */
	public final void exportMazeToTextFile() {
		try {
			PrintWriter textF = new PrintWriter(new FileOutputStream("data/export.txt"));
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
	public final void solve() throws DepartureArrivalException {
		MBox[] startAndEnd = maze.findStartAndEnd();
		MBox start = startAndEnd[0];
		MBox end = startAndEnd[1];

		PreviousInterface previous = Dijkstra.dijkstra(maze, start);
		ArrayList<VertexInterface> path = previous.getShortestPathTo(end);

		if (!(path.get(path.size() - 1).isEqualTo(start))) {
			NoPathException.throwNoPathPopUp();
		} else {
			for (int i = 0; i < maze.getHeight(); i++) {
				for (int j = 0; j < maze.getWidth(); j++) {
					MBox box = maze.getBox(i, j);
					if (path.contains(box) && !(box.isEqualTo(end)) && !(box.isEqualTo(start))) {
						maze.setBox(new PBox(i, j));
						setModified(true);
						stateChanges();
					}
				}
			}
		}
	}

	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}

	public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for (ChangeListener listener : listeners) {
			listener.stateChanged(evt);
		}
	}
}