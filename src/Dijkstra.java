import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Guilherme Domingos Faria Silva
 * Classe que contém o algoritmo de Dijkstra e retorna o menor caminho entre dois vertices.
 * A classe contém dois arraylists para receber as arestas e os vertices do grafo, dois conjuntos de vertices visitados e nao visitados,
 * para evitar ciclos e saber qual o proximo passo, e dois maps para mapear a distancia de um vertice qualquer e a origem e para
 * mapear cada vertice ao seu antecessor.
 */
public class Dijkstra {
	@SuppressWarnings("unused")
	private ArrayList<Vertice> vs;
	private ArrayList<Aresta> as;
	private Set<Vertice> visitados = new HashSet<Vertice>();;
	private Set<Vertice> naovisitados = new HashSet<Vertice>();
	private Map<Vertice, Integer> distancia = new HashMap<Vertice, Integer>();
	private Map<Vertice, Vertice> antecessores = new HashMap<Vertice, Vertice>();
	
	public Dijkstra(Graph grafo) {
		this.vs = new ArrayList<Vertice>(grafo.getVertices());
		this.as = new ArrayList<Aresta>(grafo.getArestas());
	}
	
	/**
	 * Executa a busca em largura pelo grafo, atribuindo os caminhos minimos entre a origem e todos os vertices do grafo.
	 * @param origem: vertice origem da busca.
	 */
	public void busca(Vertice origem) {
		naovisitados.add(origem);
		distancia.put(origem, 0);
		while(naovisitados.size() > 0) {
			Vertice v = getProximo(naovisitados);
			visitados.add(v);
			naovisitados.remove(v);
			caminhoMinimo(v);
		}
	}
	
	/**
	 * Recupera o proximo adjacente do vertice atual a se analisar.
	 * @param vertices: conjunto de vertices no qual o proximo vertice a ser analisado está.
	 * @return proximo vertice a ser analisado.
	 */
	public Vertice getProximo(Set<Vertice> vertices) {
		Vertice resposta = null;
		for (Vertice v : vertices) {
			if (resposta == null)
				resposta = v;
			else {
				if (menorDistancia(resposta) > menorDistancia(v))
					resposta = v;
			}
		}
		return resposta;
	}
	
	/**
	 * Retorna a menor distancia do vertice destino a origem, que ja esta mapeada no map "distancia".
	 * @param destino
	 * @return : menor distancia entre o destino e a origem, ou "infinito" caso o vertice destino nao seja alcançavel pela origem.
	 */
	public int menorDistancia(Vertice destino) {
		if (distancia.get(destino) == null)
			return Integer.MAX_VALUE;
		else
			return distancia.get(destino);
	}
	
	/**
	 * A partir da lista de vertices adjacentes ao vertice v em questão, realiza os proximos passos do algoritmo nos adjacentes,
	 * atualizando a distancia, inserindo v como antecessor do novo vertice v2 e adicionando v2 ao conjunto de vertices
	 * a serem visitados, caso necessario.
	 * @param v: vertice atual da busca pelo grafo.
	 */
	public void caminhoMinimo(Vertice v) {
		List<Vertice> adj = getAdjacentes(v);
		for (Vertice v2 : adj) {
			if (menorDistancia(v2) > menorDistancia(v) + distanciaNormal(v, v2))
			{
				distancia.put(v2, menorDistancia(v) + distanciaNormal(v, v2));
				antecessores.put(v2, v);
				naovisitados.add(v2);
			}
		}
	}
	
	/**
	 * Este metodo calcula o peso de uma aresta entre dois vértices, caso exista uma aresta entre os dois vertices.
	 * @param v: primeiro vertice da aresta.
	 * @param v2: segundo vertice da aresta.
	 * @return : peso da aresta que conecta os dois vertices, ou -1 caso nenhuma aresta ligue os dois vertices.
	 */
	public int distanciaNormal(Vertice v, Vertice v2) {
		for (Aresta a : as) {
			if (a.getOrigem().equals(v) && a.getDestino().equals(v2))
				return a.getPeso();
		}
		return -1;
	}
	
	/**
	 * Calcula a lista de vertices adjacentes ao vertice atual da busca, excluindo-se vertices que ja tenham sido visitados.
	 * @param v: vertice atual da busca.
	 * @return : lista de vertices adjacentes ao vertice atual da busca.
	 */
	public List<Vertice> getAdjacentes(Vertice v) {
		List<Vertice> adj = new ArrayList<Vertice>();
		for (Aresta a : as) {
			if (a.getOrigem().equals(v) && (!visitados.contains(a.getDestino())))
				adj.add(a.getDestino());
		}
		return adj;
	}
	
	/**
	 * Calcula o caminho entre o vertice de origem e o vertice de destino, baseando-se no map de antecessores, que relaciona
	 * dois vertices com aresta de menor peso. Inverte a lista ao fim do método para que o caminho retornado esteja na ordem
	 * comum de leitura.
	 * @param destino: vertice a partir do qual sera iniciada a construção do caminho, dele até o vertice origem da busca.
	 * @return : caminho entre o vertice de origem e destino.
	 */
	public LinkedList<Vertice> getCaminho(Vertice destino) {
		LinkedList<Vertice> caminho = new LinkedList<Vertice>();
		Vertice v = destino;
		
		if (antecessores.get(v) == null)
			return null;
		caminho.add(v);
		while(antecessores.get(v) != null) {
			v = antecessores.get(v);
			caminho.add(v);
		}
		Collections.reverse(caminho);
		return caminho;
	}
}
