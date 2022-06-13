import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Classe que executa o método main usando o algoritmo de Dijkstra em um grafo generico informado pelo usuario.
 * @author Guilherme Domingos Faria Silva
 *
 */

public class Executa {
	static ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	static ArrayList<Aresta> arestas = new ArrayList<Aresta>();
	
	public static void main(String[] args) throws IOException {
		int op = 1, distancia;
		Vertice aux, aux2;
		String nome, origem, destino;
		
		System.out.println("Inserindo vertices.");
		do {
			System.out.println("Digite o nome do vertice: ");
			nome = EntradaTeclado.leString();
			Vertice vertice = new Vertice(nome);
			vertices.add(vertice);
			
			System.out.println("Deseja inserir outro vertice? 1- Sim. 2- Nao. ");
			try {
				op = EntradaTeclado.leInt();
			} catch (IllegalArgumentException e) {
				System.out.println("Entrada invalida.");
				System.exit(0);
			}
		} while (op == 1);
		
		op = 1;
		System.out.println("Inserindo arestas.");
		while (op == 1) {
			System.out.println("Digite o nome da aresta: ");
			nome = EntradaTeclado.leString();
			System.out.println("Digite o nome do vertice origem: ");
			origem = EntradaTeclado.leString();
			aux = Graph.procuraVertice(origem, vertices);
			if (aux == null)
			{
				System.out.println("O vertice digitado nao existe.");
				continue;
			}
			System.out.println("Digite o nome do vertice destino: ");
			destino = EntradaTeclado.leString();
			aux2 = Graph.procuraVertice(destino, vertices);
			if (aux2 == null)
			{
				System.out.println("O vertice digitado nao existe.");
				continue;
			}
			System.out.println("Digite a distancia entre os dois vertices: ");
			distancia = EntradaTeclado.leInt();
			
			Aresta nova = new Aresta(nome, aux, aux2, distancia);
			arestas.add(nova);
			
			System.out.println("Deseja adicionar outra aresta ao grafo? 1- Sim. 2- Nao. ");
			try {
				op = EntradaTeclado.leInt();
			} catch (IllegalArgumentException e) {
				System.out.println("Entrada invalida.");
				System.exit(0);
			}
		}
        
		Graph grafo = new Graph(vertices, arestas);
		Dijkstra dij = new Dijkstra(grafo);
		
		do {
		System.out.println("Qual o nome do vertice de origem para a busca?");
		origem = EntradaTeclado.leString();
		aux = Graph.procuraVertice(origem, vertices);
		if (aux == null)
			System.out.println("O vertice nao pertence ao grafo");
		} while (aux == null);
		dij.busca(aux);
		
		do {
		System.out.println("Qual o nome do vertice de destino para a busca?");
		destino = EntradaTeclado.leString();
		aux = Graph.procuraVertice(destino, vertices);
		if (aux == null)
			System.out.println("O vertice nao pertence ao grafo");
		} while (aux == null);
		
		LinkedList<Vertice> caminho = dij.getCaminho(aux);
		if (caminho == null)  {
			System.out.println("Nao existe caminho para o vertice.");
			System.exit(0);
		}
		System.out.println("Caminho mais curto entre os dois vertices: ");
		for (Vertice v : caminho)
			System.out.println(v);
	}
}
