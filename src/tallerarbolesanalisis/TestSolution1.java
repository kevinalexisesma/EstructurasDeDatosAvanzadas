package tallerarbolesanalisis;

import java.util.LinkedList;
import java.util.Queue;

public class TestSolution1 {

    public static void main(String[] args) {
        //[ [ [ 1,2 ] ] , [3], [4], []]
        int numeroCasos = 4;
        for (int i = 0; i < numeroCasos; i++) {
            String[] acciones = {"CBTInserter", "insert", "insert", "get_root"};
            int[][] nodos = {{1,2}, {3}, {4}, {}};
            Solution1 cBTInserter = null;
            for (int j = 0; j < acciones.length; j++) {
                if(acciones[j].equals("CBTInserter")){
                    TreeNode raiz = new TreeNode(nodos[j][0]);
                    if(nodos[j].length > 1){
                        raiz.left = new TreeNode(nodos[j][1]);
                        if (nodos[j].length > 2){
                            raiz.right = new TreeNode(nodos[j][2]);
                        }
                    }
                    cBTInserter = new Solution1(raiz);
                }else if(acciones[j].equals("insert")){
                    if(cBTInserter != null){
                        cBTInserter.insert(nodos[j][0]);
                    }
                }else{
                    if(cBTInserter != null){
                        imprimirArbolPorNivelesConFormato(cBTInserter.get_root(), 0);
                        System.out.println("------------------separador-------------------");
                    }
                }
            }
        }
    }

    public static void imprimirArbolPorNiveles(TreeNode raiz) {
        if (raiz == null) {
            return;
        }

        Queue<TreeNode> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            int nivelActual = cola.size();

            for (int i = 0; i < nivelActual; i++) {
                TreeNode nodoActual = cola.poll();
                System.out.print(nodoActual.val + " ");

                if (nodoActual.left != null) {
                    cola.add(nodoActual.left);
                }

                if (nodoActual.right != null) {
                    cola.add(nodoActual.right);
                }
            }

            System.out.println();
        }
    }

    public static void imprimirArbolPorNivelesConFormato(TreeNode raiz, int nivel) {
        if (raiz == null) {
            return;
        }

        imprimirArbolPorNivelesConFormato(raiz.right, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("----");
        }

        System.out.println(raiz.val + "<" );

        imprimirArbolPorNivelesConFormato(raiz.left, nivel + 1);
    }
}
