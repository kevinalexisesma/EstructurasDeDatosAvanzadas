package tallerarbolesanalisis;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestSolution6 {

    public static void main(String[] args) throws IOException {
        // Configuración de las pruebas
        Random random = new Random();
        int numTests = 20;
        int minNodes = 3;
        int maxNodes = 100;
        int maxEdges = 500;

        // Crear las pruebas
        for (int i = 1; i <= numTests; i++) {
            // Generar datos aleatorios para la prueba
            int n = random.nextInt(maxNodes - minNodes + 1) + minNodes;
            int[][] edges = generateRandomEdges(random, n, maxEdges);
            int source = random.nextInt(n);
            int destination = random.nextInt(n);

            // Ejecutar la solución
            Solution6 solution = new Solution6();
            boolean result = solution.validPath(n, edges, source, destination);

            // Escribir los datos de entrada en un archivo
            String inputFilename = "test" + i + "_in.txt";
            FileWriter inputWriter = new FileWriter(new File(inputFilename));
            inputWriter.write(n + " " + edges.length + " " + source + " " + destination + "\n");
            for (int[] edge : edges) {
                inputWriter.write(edge[0] + " " + edge[1] + "\n");
            }
            inputWriter.close();

            // Escribir los datos de salida en un archivo
            String outputFilename = "test" + i + "_out.txt";
            FileWriter outputWriter = new FileWriter(new File(outputFilename));
            outputWriter.write(result ? "true\n" : "false\n");
            outputWriter.close();
        }
    }

    private static int[][] generateRandomEdges(Random random, int n, int maxEdges) {
        int numEdges = random.nextInt(maxEdges + 1);
        int[][] edges = new int[numEdges][2];
        for (int i = 0; i < numEdges; i++) {
            edges[i][0] = random.nextInt(n);
            edges[i][1] = random.nextInt(n);
        }
        return edges;
    }
}
