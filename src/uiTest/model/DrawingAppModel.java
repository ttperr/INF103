package uiTest.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DrawingAppModel {
	private final ArrayList<Segment> editedSegments = new ArrayList<>(128);
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
		if (this.selectedSegment != selectedSegment) {
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

	private ArrayList<ChangeListener> listeners = new ArrayList<>();

	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}

	public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for (ChangeListener listener : listeners)
			listener.stateChanged(evt);
	}

	public final void removeSelectedSegment() {
		if (this.selectedSegment != null) {
			editedSegments.remove(this.selectedSegment);
			this.selectedSegment = null;
			stateChanges();
		}
	}

	public final void initCurrentSegment(int x, int y) {
		setCurrentSegment(new Segment(x, y, x, y, currentColor));
	}

	public final void modifyCurrentSegment(int x2, int y2) {
		if (currentSegment != null) {
			float x1 = (float) currentSegment.getX1();
			float y1 = (float) currentSegment.getY1();
			setCurrentSegment(new Segment(x1, y1, x2, y2, currentColor));
		}
	}

	public final void registerCurrentSegment(int x2, int y2) {
		if (currentSegment != null) {
			float x1 = (float) currentSegment.getX1();
			float y1 = (float) currentSegment.getY1();
			if (Math.abs(x1 - x2) >= 1.0f || Math.abs(y1 - y2) >= 1.0f) {
				currentSegment = null;
				editedSegments.add(new Segment(x1, y1, x2, y2, currentColor));
				stateChanges();
			}
		}
	}

	public final void cancelCurrentSegment() {
		setCurrentSegment(null);
	}

	public final void setSelection(int x, int y) {
		double xd = x;
		double yd = y;

		for (Segment s : editedSegments) {
			if (s.ptLineDist(xd, yd) < 1.0) {
				setSelectedSegment(s);
				return;
			}
		}

		setSelectedSegment(null);
	}

	public void saveToFile() {
		// TODO Auto-generated method stub

	}

}