package uiProject.vue.selectBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

public final class TypeBoxButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;

	public TypeBoxButton(MazeApp mazeApp, String label) {
		super(label);
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	public final void actionPerformed(ActionEvent evt) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		String label = this.getText();
		mazeAppModel.setSelectedBoxLabel(label);
	}
}
