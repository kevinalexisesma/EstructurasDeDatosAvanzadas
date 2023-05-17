package tallerarbolesanalisis;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution6 {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        System.out.print("Fin solucion 6");
        List<Integer>[] auxLista = new List[n];
        for (int i = 0; i < n; i++) {
            auxLista[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            auxLista[u].add(v);
            auxLista[v].add(u);
        }
    
        boolean[] visited = new boolean[n];
        visited[source] = true;
        Stack<Integer> pila = new Stack<>();
        pila.push(source);
        while (!pila.isEmpty()) {
            int u = pila.pop();
            if (u == destination) {
                return true;
            }
            for (int v : auxLista[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    pila.push(v);
                }
            }
        }
        System.out.print("Fin solucion 6");
        return false;
    }
}
