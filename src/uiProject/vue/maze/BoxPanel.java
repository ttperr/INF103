package uiProject.vue.maze;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import algo.maze.MBox;
import uiProject.vue.MazeApp;

/**
 * Box panel class
 * 
 * @author Tristan Perrot
 *
 */
public class BoxPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final MBox box;
	private BoxPanelMouseListener mazePanelMouseListener;

	private static Image arrival;
	private static Image wall;
	private static Image departure;
	private static Image empty;
	private static Image path;

	static {
		try {
			arrival = ImageIO.read(new File("data/arrival.jpg"));
			wall = ImageIO.read(new File("data/wall.jpg"));
			empty = ImageIO.read(new File("data/empty.jpg"));
			departure = ImageIO.read(new File("data/departure.png"));
			path = ImageIO.read(new File("data/path.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create and add the mouse listener for the box
	 * 
	 * @param mazeApp The frame
	 * @param box The box clicked on
	 */
	public BoxPanel(MazeApp mazeApp, MBox box) {
		this.box = box;
		mazePanelMouseListener = new BoxPanelMouseListener(mazeApp);
		addMouseListener(mazePanelMouseListener);
	}

	/**
	 * @return the box
	 */
	public MBox getBox() {
		return box;
	}

	/**
	 * Modify the current picture of the box clicked
	 */
	@Override
	public void paintComponent(Graphics g) {
		
		// Paint the background
		super.paintComponent(g);

		if (box.getLabel().equals("A")) {
			g.drawImage(arrival, 0, 0, getWidth(), getHeight(), this);
		} else if (box.getLabel().equals( "D")) {
			g.drawImage(departure, 0, 0, getWidth(), getHeight(), this);
		} else if (box.getLabel().equals("E")) {
			g.drawImage(empty, 0, 0, getWidth(), getHeight(), this);
		} else if (box.getLabel().equals("W")) {
			g.drawImage(wall, 0, 0, getWidth(), getHeight(), this);
		} else {
			g.drawImage(path, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Action to do if there is an update of the box
	 */
	public void notifyForUpdate() {
		repaint();
	}
}
