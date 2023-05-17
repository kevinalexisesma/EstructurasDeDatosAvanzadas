package tallerarbolesanalisis;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestSolution5 {

    public static void main(String[] args) throws IOException {
        // Configuración de las pruebas
        Random random = new Random();
        int numTests = 20;
        int minVal = 1;
        int maxVal = 50;

        // Crear las pruebas
        for (int i = 1; i <= numTests; i++) {
            // Generar datos aleatorios para la prueba
            Solution5 solution = new Solution5();
            Solution5.TreeNode originalRoot = generateRandomTree(random, minVal, maxVal);
            Solution5.TreeNode clonedRoot = cloneTree(originalRoot);
            Solution5.TreeNode targetNode = getRandomNode(originalRoot);

            // Ejecutar la solución
            Solution5.TreeNode result = solution.getTargetCopy(originalRoot, clonedRoot, targetNode);

            // Escribir los datos de entrada en un archivo
            String inputFilename = "test" + i + "_in.txt";
            FileWriter inputWriter = new FileWriter(new File(inputFilename));
            writeTree(inputWriter, originalRoot);
            inputWriter.write(targetNode.val + "\n");
            inputWriter.close();

            // Escribir los datos de salida en un archivo
            String outputFilename = "test" + i + "_out.txt";
            FileWriter outputWriter = new FileWriter(new File(outputFilename));
            if (result != null) {
                outputWriter.write(result.val + "\n");
            } else {
                outputWriter.write("null\n");
            }
            outputWriter.close();
        }
    }

    private static Solution5.TreeNode generateRandomTree(Random random, int minVal, int maxVal) {
        if (random.nextBoolean()) {
            return null;
        }
        int val = random.nextInt(maxVal - minVal + 1) + minVal;
        Solution5.TreeNode node = new Solution5().new TreeNode(val);
        node.left = generateRandomTree(random, minVal, maxVal);
        node.right = generateRandomTree(random, minVal, maxVal);
        return node;
    }

    private static Solution5.TreeNode cloneTree(Solution5.TreeNode node) {
        if (node == null) {
            return null;
        }
        Solution5.TreeNode clone = new Solution5().new TreeNode(node.val);
        clone.left = cloneTree(node.left);
        clone.right = cloneTree(node.right);
        return clone;
    }

    private static Solution5.TreeNode getRandomNode(Solution5.TreeNode root) {
        if (root == null) {
            return null;
        }
        Random random = new Random();
        int targetVal = root.val;
        while (targetVal == root.val) {
            int minVal = 1;
            int maxVal = 50;
            targetVal = random.nextInt(maxVal - minVal + 1) + minVal;
        }
        return findNode(root, targetVal);
    }

    private static Solution5.TreeNode findNode(Solution5.TreeNode node, int targetVal) {
        if (node == null || node.val == targetVal) {
            return node;
        }
        Solution5.TreeNode leftResult = findNode(node.left, targetVal);
        if (leftResult != null) {
            return leftResult;
        }
        return findNode(node.right, targetVal);
    }

    private static void writeTree(FileWriter writer, Solution5.TreeNode node) throws IOException {
        if (node == null) {
            writer.write("null\n");
        } else {

            writer.write(node.val + "\n");
            writeTree(writer, node.left);
            writeTree(writer, node.right);
        }
    }
}
