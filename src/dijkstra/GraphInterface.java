package dijkstra;

import java.util.ArrayList;

/**
 * Interface des graphes
 * 
 * @author Tristan Perrot
 *
 */
public interface GraphInterface {

	/**
	 * Renvoie l'ensemble des sommets du graphe
	 * 
	 * @return La liste de tous les sommets
	 **/
	public ArrayList<VertexInterface> getAllVertices();

	/**
	 * Renvoie la liste des voisins d'un sommet dans le graphe
	 * 
	 * @param vertex Le sommet dont on cherche les voisins
	 * @return La liste des voisins
	 **/
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);

	/**
	 * Renvoie le poids dans le graphe de l'ar�te entre deux sommets
	 * 
	 * @param src Le sommet d'origine
	 * @param dst Le sommet d'arriv�e
	 * @return Le poids de l'ar�te src-dst
	 **/
	public Double getWeight(VertexInterface src, VertexInterface dst);

}
