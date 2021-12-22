package uiProject.model;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.event.*;

import algo.dijkstra.*;
import algo.maze.*;

import uiProject.vue.*;

public class DrawingAppModel {
	private Maze maze;
	private String currentBoxLabel = "E";
	private MBox currentBox = null;
	private MBox selectedBox = null;
	private boolean modified = false;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();

	public DrawingAppModel() {
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
	 * @return the maze
	 */
	public Maze getMaze() {
		return maze;
	}

	/**
	 * @param maze the maze to set
	 */
	public void setMaze(MBox[][] maze) {
		if (this.getMaze().getMaze() != maze) {
			this.maze = new Maze(maze);
			setModified(true);
			stateChanges();
		}
	}

	/**
	 * @return the currentBoxLabel
	 */
	public String getCurrentBoxLabel() {
		return currentBoxLabel;
	}

	/**
	 * @param currentBoxLabel the currentBoxLabel to set
	 */
	public void setCurrentBoxLabel(String currentBoxLabel) {
		if (this.currentBoxLabel != currentBoxLabel) {
			this.currentBoxLabel = currentBoxLabel;
			setModified(true);
			stateChanges();
		}
	}

	/**
	 * @return the currentBox
	 */
	public MBox getCurrentBox() {
		return currentBox;
	}

	/**
	 * @param currentBox the currentBox to set
	 */
	public void setCurrentBox(MBox currentBox) {
		if (this.currentBox != currentBox) {
			this.currentBox = currentBox;
			setModified(true);
			stateChanges();
		}
	}

	/**
	 * @return the selectedBox
	 */
	public MBox getSelectedBox() {
		return selectedBox;
	}

	/**
	 * @param selectedBox the selectedSegment to set
	 */
	public void setSelectedBox(MBox selectedBox) {
		if (this.selectedBox != selectedBox) {
			this.selectedBox = selectedBox;
			setModified(true);
			stateChanges();
		}
	}

	/**
	 * @return the modified
	 */
	public boolean isModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(boolean modified) {
		this.modified = modified;
	}

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
