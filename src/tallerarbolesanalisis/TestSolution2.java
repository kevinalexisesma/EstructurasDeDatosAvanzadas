package tallerarbolesanalisis;

import com.sun.source.tree.Tree;

import java.util.List;

public class TestSolution2 {
    /**
     * En el static void main, se instancia la raíz y se llena con un método de llenarArbolAscendente.
     * Esto se hace para que al usar el inorderTraversal, lo imprima de manera ascendente.
     * @param args
     */
    public static void main(String[] args) {
        TreeNode raiz = llenarArbolAscendente(1, 8);
        Solution2 solucion = new Solution2();

        //Aquí se usa el método de la solución del problema, y se guarda la lista de interos que devuelve.
        List<Integer> inordertraversal = solucion.inorderTraversal(raiz);

        //La imprimimos
        imprimirInorderTraversal(inordertraversal);

        //Esto es más para validar que el árbol si se imprimió de manera traversal
        System.out.println("Impresión del árbol:");
        TestSolution1 arbol = new TestSolution1();
        arbol.imprimirArbolPorNivelesConFormato(raiz, 0);
    }

    /**
     * Se llena el árbol desde una variable de inicio hasta una de fin.
     * Todo esto se hace para que al imprimirlo de manera inorder se imprima de manera ordenada.
     * @param inicio la hoja que más estará en la izquierda
     * @param fin la hoja que más estará a la derecha
     * @return
     */
    public static TreeNode llenarArbolAscendente(int inicio, int fin) {
        if (inicio > fin) {
            return null;
        }

        int valorMedio = (inicio + fin) / 2;
        TreeNode nodo = new TreeNode(valorMedio);

        nodo.left = llenarArbolAscendente(inicio, valorMedio - 1);
        nodo.right = llenarArbolAscendente(valorMedio + 1, fin);

        return nodo;
    }

    public static void imprimirInorderTraversal(List<Integer> lista){
        System.out.print("["+lista.get(0));
        for (int i = 1; i < lista.size(); i++) {
            System.out.print("," + lista.get(i));
        }
        System.out.print("]");
    }
}
