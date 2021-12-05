package dijkstra;

/** Interface des pères des sommets
 * 
 * @author Tristan Perrot
 *
 */
public interface PreviousInterface {
	
	/** Définit le lien de succession entre deux sommets
	 * @param vertex Le sommet fils
	 * @param previous Le sommet père
	 **/
	public void setPrevious(VertexInterface x, VertexInterface previous) ;
	
	/** Renvoie le père d'un vecteur.
	 * @param vertex Le sommet fils
	 * @return Le sommet père
	 **/
	public VertexInterface getPrevious(VertexInterface x) ;
	
}
