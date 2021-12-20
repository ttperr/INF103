package uiProject.model;

import java.awt.*;
import java.util.*;
import javax.swing.event.*;

public class DrawingAppModel {
	private Box[][] maze;
	private int width = 10;
	private int height = 10;
	private String currentBoxLabel = "E";
	private Box currentBox = null;
	private Box selectedSegment = null;
	private boolean modified = false;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();

	public DrawingAppModel() {
		maze = new Box[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				maze[i][j] = new Box(i, j, "E");
			}
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
	public Box getCurrentBox() {
		return currentBox;
	}

	/**
	 * @param currentBox the currentBox to set
	 */
	public void setCurrentBox(Box currentBox) {
		if (this.currentBox != currentBox) {
			this.currentBox = currentBox;
			setModified(true);
			stateChanges();
		}
	}

	/**
	 * @return the selectedSegment
	 */
	public Box getSelectedSegment() {
		return selectedSegment;
	}

	/**
	 * @param selectedSegment the selectedSegment to set
	 */
	public void setSelectedSegment(Box selectedSegment) {
		if (this.selectedSegment != selectedSegment) {
			this.selectedSegment = selectedSegment;
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

}
