package uiTest.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawingPanelMouseListener extends MouseAdapter implements MouseListener, MouseMotionListener {
	DrawingApp drawingApp;

	public DrawingPanelMouseListener(DrawingApp drawingApp) {
		super();
		this.drawingApp = drawingApp;
	}

	@Override
	public final void mousePressed(MouseEvent e) {
		drawingApp.getDrawingAppModel().initCurrentSegment(e.getX(), e.getY());
	}

	@Override
	public final void mouseDragged(MouseEvent e) {
		drawingApp.getDrawingAppModel().modifyCurrentSegment(e.getX(), e.getY());
	}

	@Override
	public final void mouseReleased(MouseEvent e) {
		drawingApp.getDrawingAppModel().registerCurrentSegment(e.getX(), e.getY());
	}

	@Override
	public final void mouseClicked(MouseEvent e) {
		drawingApp.getDrawingAppModel().setSelection(e.getX(), e.getY());
	}

}
