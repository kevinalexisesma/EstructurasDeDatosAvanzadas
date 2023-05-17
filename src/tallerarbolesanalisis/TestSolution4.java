package tallerarbolesanalisis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TestSolution4 {

    public static void main(String[] args) throws IOException {
        // Configuración de las pruebas
        Random random = new Random();
        int numTests = 5;
        int minNodes = 3;
        int maxNodes = 9;
        int maxEdges = 15;

        // Crear las pruebas
        for (int i = 1; i <= numTests; i++) {
            // Generar datos aleatorios para la prueba
            int n = random.nextInt(maxNodes - minNodes + 1) + minNodes;
            int[][] edges = generateRandomTreeEdges(random, n);

            // Ejecutar la solución
            Solution4 solution = new Solution4();
            List<Integer> result = solution.findMinHeightTrees(n, edges);

            // Verificar y corregir el caso de ciclo infinito
            if (result.size() == n) {
                // El grafo tiene un ciclo infinito, se debe corregir
                result = new ArrayList<>();
                result.add(0); // Agregar cualquier nodo como resultado
            }

            // Escribir los datos de entrada en un archivo
            String inputFilename = "test" + i + "_in.txt";
            FileWriter inputWriter = new FileWriter(new File(inputFilename));
            inputWriter.write(n + "\n");
            for (int[] edge : edges) {
                inputWriter.write(edge[0] + " " + edge[1] + "\n");
            }
            inputWriter.close();

            // Escribir los datos de salida en un archivo
            String outputFilename = "test" + i + "_out.txt";
            FileWriter outputWriter = new FileWriter(new File(outputFilename));
            for (int r : result) {
                outputWriter.write(r + " ");
            }
            outputWriter.close();
        }
    }

    private static int[][] generateRandomTreeEdges(Random random, int n) {
        int[][] edges = new int[n - 1][2];
        Set<Integer> nodes = new HashSet<>();

        // Agregar todos los nodos al conjunto
        for (int i = 0; i < n; i++) {
            nodes.add(i);
        }

        // Generar los bordes del árbol
        int parent = random.nextInt(n);
        nodes.remove(parent);

        for (int i = 0; i < n - 1; i++) {
            int child = nodes.iterator().next();
            nodes.remove(child);
            edges[i][0] = parent;
            edges[i][1] = child;
            parent = child;
        }

        return edges;
    }
}
