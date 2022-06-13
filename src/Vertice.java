/**
 * 
 * @author Guilherme Domingos Faria Silva
 * Esta classe representa um vértice. Ela contém o nome do vértice e também sobrecarrega o método equals, para comparações entre vértices.
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
