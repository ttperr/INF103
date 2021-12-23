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

public class DimensionSet extends JPanel implements PropertyChangeListener {
	private int width;
	private int height;

	private final JLabel widthLabel;
	private final JLabel heightLabel;

	private JFormattedTextField widthField;
	private JFormattedTextField heightField;

	private NumberFormat widthFormat;
	private NumberFormat heightFormat;

	private final MazeApp mazeApp;

	public DimensionSet(MazeApp mazeApp) {
		this.mazeApp = mazeApp;
		this.width = mazeApp.getMazeAppModel().getMaze().getWidth();
		this.height = mazeApp.getMazeAppModel().getMaze().getHeight();

		setLayout(new BorderLayout());

		widthLabel = new JLabel("Width : ");
		widthField = new JFormattedTextField(widthFormat);
		widthField.setValue(width);
		widthField.setColumns(10);
		widthLabel.setLabelFor(widthField);
		widthField.addPropertyChangeListener("value", this);

		heightLabel = new JLabel("Width : ");
		heightField = new JFormattedTextField(heightFormat);
		heightField.setValue(height);
		heightField.setColumns(10);
		heightLabel.setLabelFor(heightField);
		heightField.addPropertyChangeListener("value", this);

		JPanel labelPane = new JPanel(new GridLayout(0, 1));
		labelPane.add(widthLabel);
		labelPane.add(heightLabel);

		JPanel fieldPane = new JPanel(new GridLayout(0, 1));
		fieldPane.add(widthField);
		fieldPane.add(heightField);

		add(labelPane, BorderLayout.CENTER);
		add(fieldPane, BorderLayout.LINE_END);
	}

	public void propertyChange(PropertyChangeEvent evt) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		int nwidth = (int) ((Number) widthField.getValue()).doubleValue();
		int nheight = (int) ((Number) heightField.getValue()).doubleValue();
		mazeAppModel.reset(nwidth, nheight);
	}
}
