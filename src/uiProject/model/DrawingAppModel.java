package uiProject.model;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.event.*;

import algo.maze.*;

public class DrawingAppModel {
	private MBox[][] maze;
	private int width = 10;
	private int height = 10;
	private String currentBoxLabel = "E";
	private MBox currentBox = null;
	private MBox selectedBox = null;
	private boolean modified = false;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();

	public DrawingAppModel() {
		maze = new MBox[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				maze[i][j] = new EBox(i, j);
			}
		}
	}

	/**
	 * @return the maze
	 */
	public MBox[][] getMaze() {
		return maze;
	}

	/**
	 * @param maze the maze to set
	 */
	public void setMaze(MBox[][] maze) {
		if (this.maze != maze) {
			this.maze = maze;
			setModified(true);
			stateChanges();
		}
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		if (this.width != width) {
			this.width = width;
			setModified(true);
			stateChanges();
		}
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		if (this.height != height) {
			this.height = height;
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

	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}

	public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for (ChangeListener listener : listeners)
			listener.stateChanged(evt);
	}

	public void reset(int width, int height) {
		setWidth(width);
		setHeight(height);
		setCurrentBoxLabel("E");
		MBox[][] rMaze = new MBox[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rMaze[i][j] = new EBox(i, j);
			}
		}
		setMaze(rMaze);
	}
	
	public final void exportMazeToTextFile()) {
		try {
			PrintWriter textF = new PrintWriter(new FileOutputStream("data/export.txt"));
			for (MBox[] listMBox : maze) {
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
	
}
