package dijkstra;

import java.util.Hashtable;

/** Classe des p�res des sommets
 * 
 * @author Tristan Perrot
 *
 */
public class Previous extends Hashtable<VertexInterface,VertexInterface> implements PreviousInterface {

	private static final long serialVersionUID = 1L;

	public Previous() {
		super();
	}
	
	/** D�finit le lien de succession entre deux sommets
	 * @param vertex Le sommet fils
	 * @param previous Le sommet p�re
	 **/
	public final void setPrevious(VertexInterface x, VertexInterface previous) {
		this.put(x, previous);		
	}
	
	/** Renvoie le p�re d'un vecteur.
	 * @param vertex Le sommet fils
	 * @return Le sommet p�re
	 **/
	public final VertexInterface getPrevious(VertexInterface x) {
		return this.get(x);
	}

	
}
