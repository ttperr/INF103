package dijkstra;

import java.util.Hashtable;

/** Classe des pères des sommets
 * 
 * @author Tristan Perrot
 *
 */
public class Previous extends Hashtable<VertexInterface,VertexInterface> implements PreviousInterface {

	private static final long serialVersionUID = 1L;

	public Previous() {
		super();
	}
	
	/** Définit le lien de succession entre deux sommets
	 * @param vertex Le sommet fils
	 * @param previous Le sommet père
	 **/
	public final void setPrevious(VertexInterface x, VertexInterface previous) {
		this.put(x, previous);		
	}
	
	/** Renvoie le père d'un vecteur.
	 * @param vertex Le sommet fils
	 * @return Le sommet père
	 **/
	public final VertexInterface getPrevious(VertexInterface x) {
		return this.get(x);
	}

	
}
