class Negyszog {
public:
     virtual void kerulet() {}; //négyszögek kerülete=2*(a+b)
};

class Program {
public:
     void fgv ( Negyszog &negyszog ) {
          negyszog.kerulet();
     }};

class Teglalap : public Negyszog
{};

class Negyzet : public Negyszog // négyzet kerülete esetén nincs b, csak 4 a
{};

int main() {
     Program program;
     Negyszog negyszog;
     program.fgv ( negyszog );

     Teglalap teglalap;
     program.fgv ( teglalap );

     Negyzet negyzet;
     program.fgv ( negyzet ); // sérül az LSP, mert a négyzet kerületét nem számíthatjuk ki úgy, 
                              // mint a téglalapét, mert mások az adatok
     return 0;
}