package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.PiInterface;
import dijkstra.VertexInterface;

/**
 * Classe des labyrinthes
 * 
 * Un labyrinthe est reprï¿½sentï¿½ par la matrice de ses cases (maze), ses
 * dimensions (width,height) et une fonction pi.
 * 
 * @author Tristan Perrot
 */
public final class Maze implements GraphInterface {
	private MBox[][] maze;
	private int width;
	private int height;
	private PiInterface pi;

	public Maze(MBox[][] maze) {
		this.maze = maze;
		if (maze != null) {
			width = maze[0].length;
			height = maze.length;
		}
	}

	/**
	 * Renvoie la matrice des sommets
	 * 
	 * @return La matrice des sommets
	 */
	public final MBox[][] getMaze() {
		return maze;
	}

	/**
	 * Renvoie la largeur
	 * 
	 * @return Largeur du graphe
	 */
	public final int getWidth() {
		return width;
	}

	/**
	 * Renvoie la hauteur
	 * 
	 * @return Hauteur du graphe
	 */
	public final int getHeight() {
		return height;
	}

	/**
	 * Renvoie la fonction Pi
	 * 
	 * @return Fonction pi du graphe
	 */
	public final PiInterface getPi() {
		return this.pi;
	}

	// MBox getter
	public MBox getBox(int i, int j) {
		return maze[i][j];
	}

	/**
	 * Renvoie l'ensemble des sommets du graphe
	 * 
	 * @return La liste de tous les sommets
	 **/
	public final ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> vertices = new ArrayList<VertexInterface>();

		for (MBox[] listMBox : maze) {
			for (MBox box : listMBox) {
				vertices.add(box);
			}
		}
		return vertices;
	}

	/**
	 * Ajoute ï¿½ la liste successors un sommet nextVertex s'il est accessible
	 * depuis le sommet vertex
	 * 
	 * @param vertex     Le sommet de dï¿½part
	 * @param nextVertex Le sommet d'arrivï¿½e
	 * @param successors La liste temporaire des voisins de vertex
	 * @return La liste des voisins
	 **/
	private final void addSuccessors(ArrayList<VertexInterface> successors, VertexInterface vertex,
			VertexInterface nextVertex) {
		Double posInf = Double.POSITIVE_INFINITY;
		Double weight = getWeight(vertex, nextVertex);
		if (weight < posInf) {
			successors.add(nextVertex);
		}
	}

	/**
	 * Renvoie la liste des voisins d'un sommet dans le graphe
	 * 
	 * @param vertex Le sommet dont on cherche les voisins
	 * @return La liste des voisins
	 **/
	public final ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();

		MBox box = (MBox) vertex;
		int row = box.getRow();
		int column = box.getColumn();

		if (column - 1 >= 0) {
			MBox nextVertexLeft = maze[row][column - 1];
			addSuccessors(successors, box, nextVertexLeft);
		}

		if (column + 1 < width) {
			MBox nextVertexRight = maze[row][column + 1];
			addSuccessors(successors, box, nextVertexRight);
		}

		if (row - 1 >= 0) {
			MBox nextVertexUp = maze[row - 1][column];
			addSuccessors(successors, box, nextVertexUp);
		}

		if (row + 1 < height) {
			MBox nextVertexDown = maze[row + 1][column];
			addSuccessors(successors, box, nextVertexDown);
		}
		return successors;
	}

	/**
	 * Renvoie le poids dans le graphe de l'arï¿½te entre deux sommets
	 * 
	 * @param src Le sommet d'origine
	 * @param dst Le sommet d'arrivï¿½e
	 * @return Le poids de l'arï¿½te src-dst
	 **/
	public final Double getWeight(VertexInterface src, VertexInterface dst) {
		MBox srcBox = (MBox) src;
		MBox dstBox = (MBox) dst;

		int dstRowLength = Math.abs(srcBox.getRow() - dstBox.getRow());
		int dstColumnLength = Math.abs(srcBox.getColumn() - srcBox.getColumn());

		return (srcBox.getLabel().equals("W") || dstBox.getLabel().equals("W") || dstRowLength > 1
				|| dstColumnLength > 1
				|| (dstBox.getColumn() == srcBox.getColumn() && dstBox.getRow() == srcBox.getRow()))
						? Double.POSITIVE_INFINITY
						: 1;
	}

	/**
	 * Initialise le labyrinthe ï¿½ partir d'un fichier texte
	 * 
	 * @param fileName Adresse du fichier
	 * @throws MazeReadingException Erreur liï¿½e ï¿½ la lecture du fichier
	 */
	public final void initFromTextFile(String fileName) throws MazeReadingException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			int lineLength = line.length();
			int row = 0;
			ArrayList<MBox[]> arrayMaze = new ArrayList<MBox[]>();
			do {
				MBox[] boxesLine = new MBox[lineLength];
				for (int column = 0; column < lineLength; column++) {
					if (line.length() == lineLength) {
						switch (line.charAt(column)) {
						case 'E':
							boxesLine[column] = new EBox(row, column);
							break;

						case 'W':
							boxesLine[column] = new WBox(row, column);
							break;

						case 'A':
							boxesLine[column] = new ABox(row, column);
							break;

						case 'D':
							boxesLine[column] = new DBox(row, column);
							break;

						default:
							throw new MazeReadingException(fileName, row, column, "Unknown character readed");
						}
					} else {
						throw new MazeReadingException(fileName, row, column, "Maze is not rectangular");
					}
				}
				arrayMaze.add(boxesLine);
				row++;

			} while ((line = br.readLine()) != null);

			br.close();
			height = row;
			width = lineLength;
			maze = new MBox[height][width];

			for (int i = 0; i < height; i++) {
				maze[i] = arrayMaze.get(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Renvoie la liste [case départ, case d'arrivée] du labyrinthe
	 * 
	 * @return la liste faite de la case départ et de la case d'arrivée
	 * @throws DepartureArrivalException
	 */
	public final MBox[] findStartAndEnd() throws DepartureArrivalException {
		MBox[] startAndEnd = new MBox[2];
		for (MBox[] listMBox : maze) {
			for (MBox box : listMBox) {
				if (box.getLabel().equals("D")) {
					if (startAndEnd[0] == null) {
						startAndEnd[0] = box;
					} else
						throw new DepartureArrivalException(box.getRow(), box.getRow(), "More than one start box");
				} else if (box.getLabel().equals("A")) {
					if (startAndEnd[1] == null) {
						startAndEnd[1] = box;
					} else
						throw new DepartureArrivalException(box.getRow(), box.getRow(), "More than one end box");
				}
			}
		}
		if (startAndEnd[0] == null) {
			throw new DepartureArrivalException(-1, -1, "No start box");
		} else if (startAndEnd[0] == null) {
			throw new DepartureArrivalException(-1, -1, "No end box");
		}
		return startAndEnd;
	}

	/**
	 * Sauvegarde le labyrinthe dans un fichier texte aprï¿½s l'avoir rï¿½solu
	 * 
	 * @param fileName Adresse du fichier
	 */
	public final void saveToTextFile(String fileName) {
		try {
			PrintWriter textF = new PrintWriter(fileName);
			for (MBox[] listMBox : maze) {
				for (MBox box : listMBox) {
					textF.print(box.getLabel());
				}
				textF.print("\n");
			}
			textF.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Affiche le chemin sur la console et renvoie le résultat dans un fichier
	 * 
	 * @param path     Chemin du départ à l'arrivée
	 * @param fileName Nom du fichier dans lequel la solution doit être sauvegardée
	 * @throws DepartureArrivalException Erreur levé lorsqu'il n'y a pas qu'une
	 *                                   entrée et qu'une sortie
	 * @throws FileNotFoundException     Erreur levé lorsque le fichier n'est pas
	 *                                   trouvé
	 */
	public final void showPath(ArrayList<VertexInterface> path, String fileName)
			throws DepartureArrivalException, FileNotFoundException {
		MBox[] startAndEnd = findStartAndEnd();
		MBox start = startAndEnd[0];
		MBox end = startAndEnd[1];
		if (!(path.get(path.size() - 1).isEqualTo(start))) {
			System.out.println("Erreur : le labyrinthe n'a pas de solution !");
		} else {
			PrintWriter textF = new PrintWriter(new FileOutputStream(fileName));
			for (MBox[] listMBox : maze) {
				for (MBox box : listMBox) {
					if (path.contains(box) && !(box.isEqualTo(end)) && !(box.isEqualTo(start))) {
						System.out.print(".");
						textF.print(".");
					} else {
						System.out.print(box.getLabel());
						textF.print(box.getLabel());
					}
				}
				System.out.print("\n");
				textF.print("\n");
			}
			textF.close();
		}
	}

}
