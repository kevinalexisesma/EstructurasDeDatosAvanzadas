package tallerarbolesanalisis;

public class TestSolution3 {

    /**
     * En el main, se instancia la solucion, el árbol y el método de la solución del problema
     * @param args
     */
    public static void main(String[] args) {
        Solution3 solucion = new Solution3();

        //Se crea el árbol, en este caso, usaré el método del TestSolution2 para hacerlo de manera ascendente
        TreeNode raiz = new TestSolution2().llenarArbolAscendente(1, 10);

        //Se valida si es BST
        System.out.println("¿El árbol es BST?: " + solucion.isValidBST(raiz));

        //Imprimo el árbol para saber si está balanceado
        TestSolution1 arbol = new TestSolution1();
        arbol.imprimirArbolPorNivelesConFormato(raiz, 0);
    }
}
