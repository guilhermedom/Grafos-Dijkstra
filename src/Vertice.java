/**
 * 
 * @author Guilherme Domingos Faria Silva
 * Esta classe representa um v�rtice. Ela cont�m o nome do v�rtice e tamb�m sobrecarrega o m�todo equals, para compara��es entre v�rtices.
 */
public class Vertice {
	private String id;
	
	public Vertice(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
	        if (obj == null)
	            return false;
	        Vertice v = (Vertice) obj;
	        if (!id.equals(v.id))
	            return false;
	        return true;
	    }
	
	@Override 
	public String toString() {
		return id;
	}
}
