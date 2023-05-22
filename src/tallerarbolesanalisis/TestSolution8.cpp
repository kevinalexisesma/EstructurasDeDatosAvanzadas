#include <bits/stdc++.h>
using namespace std;

// Función para generar un número aleatorio en el rango [minValue, maxValue]
int generateRandomNumber(int minValue, int maxValue) {
    random_device rd;
    mt19937 rng(rd());
    uniform_int_distribution<int> uni(minValue, maxValue);
    return uni(rng);
}

int main() {
    ios_base::sync_with_stdio(false);
    string str;
    int n, val;
    vector<pair<string, int>> v;
    multiset<int> ans;

    // Generar 5 casos de prueba aleatorios
    for (int testCase = 1; testCase <= 5; testCase++) {
        v.clear();
        ans.clear();
        n = generateRandomNumber(1, 10); // Generar un número aleatorio entre 1 y 10 para n

        // Generar casos de prueba aleatorios
        for (int i = 0; i < n; i++) {
            int operation = generateRandomNumber(1, 3); // Generar un número aleatorio entre 1 y 3 para seleccionar la operación
            if (operation == 1) {
                str = "insert";
                val = generateRandomNumber(1, 100); // Generar un número aleatorio entre 1 y 100 para el valor
                ans.insert(val);
                v.emplace_back(make_pair(str, val));
            } else if (operation == 2) {
                str = "removeMin";
                auto it = ans.begin();
                if (it != ans.end()) {
                    ans.erase(it);
                } else {
                    v.emplace_back(make_pair("insert", 0));
                }
                v.emplace_back(make_pair(str, 0));
            } else if (operation == 3) {
                str = "getMin";
                val = generateRandomNumber(1, 100); // Generar un número aleatorio entre 1 y 100 para el valor
                auto it = ans.begin();
                if (val == (*it) && it != ans.end()) {
                    v.emplace_back(make_pair(str, val));
                } else {
                    while (!ans.empty()) {
                        it = ans.begin();
                        if (val == (*it) || (val < (*it)))
                            break;
                        v.emplace_back(make_pair("removeMin", 0));
                        ans.erase(it);
                    }
                    if (ans.empty()) {
                        v.emplace_back(make_pair("insert", val));
                        ans.insert(val);
                    } else if ((val < (*it))) {
                        v.emplace_back(make_pair("insert", val));
                        ans.insert(val);
                    }
                    v.emplace_back(make_pair(str, val));
                }
            }
        }

        // Imprimir el caso de prueba
        int sz = (int)v.size();
        cout << sz << endl;
        for (int i = 0; i < sz; i++) {
            if (v[i].first == "removeMin")
                cout << "removeMin" << '\n';
            else
                cout << v[i].first << " " << v[i].second << '\n';
        }

        cout << endl; // Imprimir una línea en blanco después de cada caso de prueba
    }

    return 0;
}
