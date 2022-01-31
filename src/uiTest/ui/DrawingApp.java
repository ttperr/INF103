package uiTest.ui;

import javax.swing.*;
import javax.swing.event.*;
import uiTest.model.*;

public class DrawingApp extends JFrame implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private final DrawingMenuBar drawingMenuBar;
	private final WindowPanel windowPanel;

	public DrawingApp() {
		super("Drawing Application"); // Window title

		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));

		drawingAppModel.addObserver(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Explicit !
		pack(); // Components sizes and positions
		setVisible(true); // The great show

	}

	private DrawingAppModel drawingAppModel = new DrawingAppModel();

	public DrawingAppModel getDrawingAppModel() {
		return drawingAppModel;
	}

	public void setDrawingAppModel(DrawingAppModel drawingAppModel) {
		this.drawingAppModel = drawingAppModel;
	}

	@Override
	public void stateChanged(ChangeEvent evt) {
		windowPanel.notifyForUpdate();
	}

}
