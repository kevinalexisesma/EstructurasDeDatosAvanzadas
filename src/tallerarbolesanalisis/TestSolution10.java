import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class TestSolution10 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // Realizar 5 casos de prueba automáticos
        for (int testCase = 1; testCase <= 5; testCase++) {
            out.println("Test Case #" + testCase + ":");

            // Leer la entrada
            int n = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (map.containsKey(x)) {
                    int val = map.get(x);
                    map.put(x, val + 1);
                } else {
                    map.put(x, 1);
                }
            }
            int m = Integer.parseInt(br.readLine());
            int i = 0, j = 0;
            int dif = Integer.MAX_VALUE;
            for (Entry<Integer, Integer> e : map.entrySet()) {
                int key = e.getKey();
                int req = m - key;
                if (req == key) {
                    if (e.getValue() > 1) {
                        dif = 0;
                        i = key;
                        j = key;
                    }
                } else {
                    if (map.containsKey(req)) {
                        int curDif = Math.abs(req - key);
                        if (curDif < dif) {
                            dif = curDif;
                            i = Math.min(key, req);
                            j = Math.max(key, req);
                        }
                    }
                }
            }
            out.println("Peter should buy books whose prices are " + i + " and " + j + ".\n");
            br.readLine(); // Leer la línea en blanco después de cada caso de prueba
        }

        out.flush();
    }
}
