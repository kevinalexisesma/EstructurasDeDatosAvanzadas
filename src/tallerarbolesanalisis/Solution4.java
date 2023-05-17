package tallerarbolesanalisis;

import java.util.*;

public class Solution4 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        System.out.print("Inicio solucion 4");
        if (n == 1) {
            List<Integer> lista = new ArrayList<>();
            lista.add(0);
            return lista;
        }

        List<Set<Integer>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            a.get(edge[0]).add(edge[1]);
            a.get(edge[1]).add(edge[0]);
        }

        List<Integer> hojas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a.get(i).size() == 1) {
                hojas.add(i);
            }
        }
        int count = 0; // Contador de iteraciones
        while (n > 2) {
            count++;
            if (count > n) { // Evitar ciclo infinito en red circular
                return hojas;
            }
            n -= hojas.size();
            List<Integer> newHojas = new ArrayList<>();
            for (int hoja : hojas) {
                Set<Integer> vecinos = a.get(hoja);
                if (!vecinos.isEmpty()) {
                    int vecino = vecinos.iterator().next();
                    vecinos.remove(vecino);
                    if (vecinos.size() == 1) {
                        newHojas.add(vecino);
                    }
                    a.get(vecino).remove(hoja);
                    if (a.get(vecino).size() == 1) {
                        newHojas.add(vecino);
                    }
                }
            }
            hojas = newHojas;
        }

        System.out.print("Fin solucion 4");
        return hojas;
    }
}
