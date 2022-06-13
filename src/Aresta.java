/**
 * 
 * @author Guilherme Domingos Faria Silva
 * Esta classe representa uma aresta pertencente ao grafo, que liga dois vertices, tem um peso e tem um nome para facilitar testes caso necessario.
 */
public class Aresta {
	@SuppressWarnings("unused")
	private String id;
	private int peso;
	private Vertice origem;
	private Vertice destino;
	
	public Aresta(String id, Vertice origem, Vertice destino, int peso) {
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}
	
	public int getPeso() {
		return peso;
	}
	
	public Vertice getOrigem() {
		return origem;
	}
	
	public Vertice getDestino() {
		return destino;
	}
}
