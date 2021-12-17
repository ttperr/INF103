package uiTest.model;

import java.awt.*;
import java.util.*;

public class DrawingAppModel {
	private final ArrayList<Segment> editedSegments = new ArrayList<Segment>(128);
	private Color currentColor = new Color(0, 0, 0);
	private Segment currentSegment = null;
	private Segment selectedSegment = null;
	private boolean modified = false;

	public Color getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(Color currentColor) {
		if (this.currentColor != currentColor) {
			this.currentColor = currentColor;
			setModified(true);
		}
	}

	public Segment getCurrentSegment() {
		return currentSegment;
	}

	public void setCurrentSegment(Segment currentSegment) {
		if (this.currentSegment != currentSegment) {
			this.currentSegment = currentSegment;
			modified = true;
		}
	}

	public Segment getSelectedSegment() {
		return selectedSegment;
	}

	public void setSelectedSegment(Segment selectedSegment) {
		if (this.selectedSegment != selectedSegment;) {
			this.selectedSegment = selectedSegment;
			modified = true;
		}
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

}