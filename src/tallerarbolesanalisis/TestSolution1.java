package tallerarbolesanalisis;

import java.util.LinkedList;
import java.util.Queue;

public class TestSolution1 {

    public static void main(String[] args) {
        //[ [ [ 1,2 ] ] , [3], [4], []]
        int numeroCasos = 4;
        for (int i = 0; i < numeroCasos; i++) {
            // Se pueden insertar N acciones, pero la inicial debe de ser el CBTInserter y la final get_root
            String[] acciones = {"CBTInserter", "insert", "insert", "get_root"};
            //A su vez, la misma cantidad de acciones, debe ser igual a la de nodos.
            int[][] nodos = {{1,2}, {3}, {4}, {}};

            //Se instancia la solution1 que contiene la solución del problema
            Solution1 cBTInserter = null;
            for (int j = 0; j < acciones.length; j++) {

                //En este if, se valida si la accion es de CBTInserter, para insertar la raiz.
                if(acciones[j].equals("CBTInserter")){
                    TreeNode raiz = new TreeNode(nodos[j][0]);
                    if(nodos[j].length > 1){
                        raiz.left = new TreeNode(nodos[j][1]);
                        if (nodos[j].length > 2){
                            raiz.right = new TreeNode(nodos[j][2]);
                        }
                    }
                    //Luego se inserta la raiz como en la solución del problema
                    cBTInserter = new Solution1(raiz);
                }else if(acciones[j].equals("insert")){ //En este si la acción es insert, los inserta por
                    // medio del cBTInserter que se instancio con la raíz en la línea 31.
                    if(cBTInserter != null){
                        cBTInserter.insert(nodos[j][0]);
                    }
                }else{
                    //Si no es ningúno de los dos, es porque es el get_root, entonces se imprime.
                    if(cBTInserter != null){
                        imprimirArbolPorNivelesConFormato(cBTInserter.get_root(), 0);
                        System.out.println("------------------separador-------------------");
                    }
                }
            }
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
