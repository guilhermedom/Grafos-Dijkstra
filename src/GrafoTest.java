import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

/**
 * Classe de teste para as outras classes do algoritmo.
 * @author Guilherme Domingos Faria Silva
 *
 */

public class GrafoTest {
	ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	ArrayList<Aresta> arestas = new ArrayList<Aresta>();

	@Test
	public void test() {
		for (int i = 0; i < 20; i++)
		{
			Vertice v = new Vertice("v" + i);
			vertices.add(v);
		}
		
		Vertice v1 = new Vertice("Ver");
		Vertice v2 = new Vertice("Nome");
		
		Aresta a = new Aresta("Aresta 1", vertices.get(0), vertices.get(1), 100);
		arestas.add(a);
		a = new Aresta("Aresta 2", vertices.get(0), vertices.get(2), 150);
		arestas.add(a);
		a = new Aresta("Aresta 3", vertices.get(1), vertices.get(2), 25);
		arestas.add(a);
		a = new Aresta("Aresta 32", vertices.get(2), vertices.get(1), 25);
		arestas.add(a);
		a = new Aresta("Aresta 4", v2, vertices.get(3), 100);
		arestas.add(a);
		a = new Aresta("Aresta 5", vertices.get(0), vertices.get(4), 100);
		arestas.add(a);
		a = new Aresta("Aresta 6", vertices.get(7), vertices.get(8), 100);
		arestas.add(a);
		a = new Aresta("Aresta 7", vertices.get(1), vertices.get(9), 2);
		arestas.add(a);
		a = new Aresta("Aresta 8", vertices.get(6), vertices.get(1), 50);
		arestas.add(a);
		 
		
        a = new Aresta("Aresta 9", vertices.get(2), vertices.get(7), 100);
        arestas.add(a);
        a = new Aresta("Aresta 10", vertices.get(3), vertices.get(7), 100);
        arestas.add(a);
        a = new Aresta("Aresta 11", vertices.get(4), vertices.get(9), 500);
        arestas.add(a);
        a = new Aresta("Aresta 12", vertices.get(9), vertices.get(10), 400);
        arestas.add(a);
        a = new Aresta("Aresta 13", vertices.get(1), vertices.get(10), 600);
        arestas.add(a);
        a = new Aresta("Aresta 14", vertices.get(4), vertices.get(9), 500);
        arestas.add(a);
		
		Graph grafo = new Graph(vertices, arestas);
		@SuppressWarnings("unused")
		Vertice v3 = Graph.procuraVertice("no", vertices);
		v3 = Graph.procuraVertice("v1", vertices);
		
		Dijkstra dij = new Dijkstra(grafo);
		dij.busca(vertices.get(0));
		LinkedList<Vertice> caminho = dij.getCaminho(vertices.get(4));
		
		for (Vertice v : caminho)
			System.out.println(v);
		
		@SuppressWarnings("unused")
		int aux = dij.distanciaNormal(v1, v2);
		dij.getCaminho(v1);
		
		Object obj = null;
		v1.equals(obj);
	}

	/*@Test
	public void mainTest() throws IOException {
		Executa e;
		Executa.main(null);
	}*/

}
