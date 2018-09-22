#include <iostream>
#include <cmath>
using namespace std;

extern string d16PiHexaJegyek; 

void BBP(int d) {  
    double d16Pi = 0.0d; //szam

    double d16S1t = d16Sj(d, 1); //a
    double d16S4t = d16Sj(d, 4); //b
    double d16S5t = d16Sj(d, 5); //c
    double d16S6t = d16Sj(d, 6); //d

    d16Pi = 4.0d * d16S1t - 2.0d * d16S4t - d16S5t - d16S6t; //szam=4*a-2*b-c-d

    d16Pi = d16Pi - floor(d16Pi); // szam= szam-(nala kisebb egesz szam--őt hatarolo kisebb egesz szam)

    StringBuffer sb = new StringBuffer();

    char hexaJegyek[] = {'A', 'B', 'C', 'D', 'E', 'F'};

    while (d16Pi != 0.0d) {
        int jegy = (int) floor(16.0d * d16Pi); //jegy= 16*szam also egesz hataroloja intre konvertalva

        if (jegy < 10)
            sb.append(jegy);
        else
            sb.append(hexaJegyek[jegy - 10]);

        d16Pi = (16.0d * d16Pi) - floor(16.0d * d16Pi); // szam=szamnak a törtrésze
    }
    d16PiHexaJegyek = sb.toString();
}

double d16Sj(int d, int j) {
        
    double d16Sj = 0.0d;

    for (int k = 0; k <= d; ++k)
        d16Sj += (double) n16modk(d - k, 8 * k + j) / (double) (8 * k + j);

    return d16Sj - floor(d16Sj);
}

long int n16modk(int n, int k) {

    int t = 1;
    while (t <= n)
        t = t * 2;

    long r = 1;

    while (true) {
        if (n >= t) {
            r = (16 * r) % k;
            n = n - t;
        }

        t = t / 2;

        if (t < 1)
            break;

        r = (r * r) % k;
    }
    return r;
}

string toString() {
    return d16PiHexaJegyek;
}
    
int main(){
    cout<<"10^6 db számjegy hexadecimálisan: " << new BBP(1000000)) << endl;
    cout<<"10^7 db számjegy hexadecimálisan: " << new BBP(10000000) << endl;
    cout<<"10^8 db számjegy hexadecimálisan: " << new BBP(100000000);
}
