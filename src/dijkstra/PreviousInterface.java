package dijkstra;

import java.util.ArrayList;

/**
 * Interface des pères des sommets
 * 
 * @author Tristan Perrot
 *
 */
public interface PreviousInterface {

	/**
	 * Définit le lien de succession entre deux sommets
	 * 
	 * @param vertex   Le sommet fils
	 * @param previous Le sommet père
	 **/
	public void setPrevious(VertexInterface x, VertexInterface previous);

	/**
	 * Renvoie le père d'un vecteur.
	 * 
	 * @param vertex Le sommet fils
	 * @return Le sommet père
	 **/
	public VertexInterface getPrevious(VertexInterface x);

	/** Renvoie la liste représentant le plus court jusqu'à un sommet donné
	 * @param vertex Le sommet d'arrivé
	 * @return La liste des sommets formant le chemin jusqu'à vertex
	 */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);

}
