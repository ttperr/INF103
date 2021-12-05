package dijkstra;

import java.util.ArrayList;

/**
 * Interface des p�res des sommets
 * 
 * @author Tristan Perrot
 *
 */
public interface PreviousInterface {

	/**
	 * D�finit le lien de succession entre deux sommets
	 * 
	 * @param vertex   Le sommet fils
	 * @param previous Le sommet p�re
	 **/
	public void setPrevious(VertexInterface x, VertexInterface previous);

	/**
	 * Renvoie le p�re d'un vecteur.
	 * 
	 * @param vertex Le sommet fils
	 * @return Le sommet p�re
	 **/
	public VertexInterface getPrevious(VertexInterface x);

	/** Renvoie la liste repr�sentant le plus court jusqu'� un sommet donn�
	 * @param vertex Le sommet d'arriv�
	 * @return La liste des sommets formant le chemin jusqu'� vertex
	 */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);

}
