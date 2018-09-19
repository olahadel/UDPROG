#include <iostream>
#include <cmath>
#include <time.h>
#include <cstdlib>

using namespace std;

class PolarGenerator {
    public:
        PolarGenerator(){
            nincsTarolt = true;
        }
        /*PolarGenerator(bool a){
            bool a;
            a = true;
            return a;
        }
        */
        double kovetkezo(bool nincsTarolt, double tarolt) {
            if (nincsTarolt) {
                double u1, u2, v1, v2, w;
                do {
                    u1 = rand();
                    u2 = rand();
                    v1 = 2 * u1 - 1;
                    v2 = 2 * u2 - 1;
                    w = v1 * v1 + v2 * v2;
                } while (w > 1);
                double r = sqrt((-2 * log(w)) / w);
                tarolt = r * v2;
                nincsTarolt = !nincsTarolt;
                return r * v1;
            } else {
                nincsTarolt = !nincsTarolt;
            }
            return tarolt;
        }

        private:
            bool nincsTarolt= true;
            double tarolt;
};


int main(){
    srand(time(NULL));
    bool a=true;
    double b=0;
    PolarGenerator g; // = new PolarGenerator;
    for (int i = 0; i < 10; ++i) {
        cout<<g.kovetkezo(a, b);
    }

}
