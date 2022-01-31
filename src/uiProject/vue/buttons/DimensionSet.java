package uiProject.vue.buttons;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

/**
 * The dimension set class
 * 
 * @author Tristan Perrot
 *
 */
public class DimensionSet extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;

	private final JLabel widthLabel;
	private final JLabel heightLabel;

	private JFormattedTextField widthField;
	private JFormattedTextField heightField;

	private NumberFormat widthFormat;
	private NumberFormat heightFormat;

	private final MazeApp mazeApp;

	/**
	 * Create and add the dimension button in the mazeApp
	 * 
	 * @param mazeApp The frame
	 */
	public DimensionSet(MazeApp mazeApp) {
		this.mazeApp = mazeApp;
		this.width = mazeApp.getMazeAppModel().getMaze().getWidth();
		this.height = mazeApp.getMazeAppModel().getMaze().getHeight();

		setLayout(new BorderLayout());

		// Create the width field
		widthLabel = new JLabel("Width : ");
		widthField = new JFormattedTextField(widthFormat);
		widthField.setValue(width);
		widthLabel.setLabelFor(widthField);
		widthField.addPropertyChangeListener("value", this);

		// Create the height field
		heightLabel = new JLabel("Height : ");
		heightField = new JFormattedTextField(heightFormat);
		heightField.setValue(height);
		heightLabel.setLabelFor(heightField);
		heightField.addPropertyChangeListener("value", this);

		// Add the label
		JPanel labelPane = new JPanel(new GridLayout(0, 1));
		labelPane.add(widthLabel);
		labelPane.add(heightLabel);

		// Add the field
		JPanel fieldPane = new JPanel(new GridLayout(0, 1));
		fieldPane.add(widthField);
		fieldPane.add(heightField);

		add(labelPane, BorderLayout.WEST);
		add(fieldPane, BorderLayout.CENTER);
	}

	/**
	 * Modify the maze when there is new values
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		int nwidth = (int) ((Number) widthField.getValue()).doubleValue();
		int nheight = (int) ((Number) heightField.getValue()).doubleValue();
		mazeAppModel.reset(nwidth, nheight);
	}
}
