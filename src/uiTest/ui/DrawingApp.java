package uiTest.ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import uiTest.model.DrawingAppModel;

public class DrawingApp extends JFrame implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private final DrawingMenuBar drawingMenuBar;
	private final WindowPanel windowPanel;

	public DrawingApp() {
		super("Drawing Application"); // Window title

		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));

		drawingAppModel.addObserver(this);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Explicit !
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
