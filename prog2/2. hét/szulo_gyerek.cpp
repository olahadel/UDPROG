#include <iostream>
using namespace std;

class Szulo{
    public:
        virtual void fuggveny(){
            cout<<"szulo"<<endl;
        };
};

class Gyerek: public Szulo{
    public:
        void fuggveny() {
            cout<<"gyerek"<<endl;
        }
        void ujfuggveny() {
            cout<<"ujfuggveny"<<endl;
        }
};

int main() {
    Szulo *szulo;
    szulo = new Szulo();

    Gyerek *gyerek;
    gyerek = new Gyerek();

    Szulo *ujgyerek;
    ujgyerek = new Gyerek();

    Gyerek *ujszulo;
    //ujszulo = new Szulo(); //Gyerek osztály több mindent tartalmaz a Szülőnél

    szulo->fuggveny();
    gyerek->fuggveny();
    ujgyerek->fuggveny();
    //ujgyerek->ujfuggveny(); //a Szülő classnak nincs ujfuggveny nevű függvénye
    
    return 0;
}
