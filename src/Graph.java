
import java.util.ArrayList;

/**
 * 
 * @author Guilherme Domingos Faria Silva
 *
 * Esta classe representa o grafo atraves de dois ArrayLists contendo os vertices e as arestas.
 */

public class Graph {
	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;
	
	public Graph(ArrayList<Vertice> vertices, ArrayList<Aresta> arestas) {
		this.vertices = vertices;
		this.arestas = arestas;
	}
	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	
	public ArrayList<Aresta> getArestas() {
		return arestas;
	}
	
	/**
	 * Procura um vertice informado pelo usuario na lista de vertices existentes, usando o parametro nome do vertice.
	 * @param nome: nome do vertice a ser buscado.
	 * @param vs: lista de vertices existentes no grafo.
	 * @return : vertice buscado, caso o encontre. null caso o nome nao indique vertice que exista no grafo.
	 */
	public static Vertice procuraVertice(String nome, ArrayList<Vertice> vs) {
		for (Vertice ver : vs) {
			if (ver.toString().equals(nome))
				return ver;
		}
		return null;
	}
}
