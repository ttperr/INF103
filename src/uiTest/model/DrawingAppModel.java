package uiTest.model;

import java.awt.*;
import java.util.*;

import javax.swing.event.*;;

public class DrawingAppModel {
	private final ArrayList<Segment> editedSegments = new ArrayList<Segment>(128);
	private Color currentColor = Color.BLACK;
	private Segment currentSegment = null;
	private Segment selectedSegment = null;
	private boolean modified = false;

	public Color getCurrentColor() {
		return currentColor;
	}

	public final void setCurrentColor(Color currentColor) {
		if (this.currentColor != currentColor) {
			this.currentColor = currentColor;
			setModified(true);
			stateChanges();
		}
	}

	public Segment getCurrentSegment() {
		return currentSegment;
	}

	public void setCurrentSegment(Segment currentSegment) {
		if (this.currentSegment != currentSegment) {
			this.currentSegment = currentSegment;
			setModified(true);
			stateChanges();
		}
	}

	public Segment getSelectedSegment() {
		return selectedSegment;
	}

	public final void setSelectedSegment(Segment selectedSegment) {
		if (this.selectedSegment != selectedSegment;) {
			this.selectedSegment = selectedSegment;
			setModified(true);
			stateChanges();
		}
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public final void paintSegments(Graphics g) {
		for (Segment s : editedSegments)
			s.paint(g, false, false);

		if (selectedSegment != null)
			selectedSegment.paint(g, true, false);

		if (currentSegment != null)
			currentSegment.paint(g, false, true);
	}

	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();

	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}

	public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for (ChangeListener listener : listeners)
			listener.stateChanged(evt);
	}

}