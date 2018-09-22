public class Liskov {
    public static class Program{
        public static void fgv(Negyszog negyszog) {
            negyszog.kerulet();
     }};
    
    public static class Negyszog {
        void kerulet() {}; //négyszögek kerülete=2*(a+b), 
                           //nem statikus, mert a kerület függvény nem tartozik szorosan a Négyszög osztályhoz
    };

    public static class Teglalap extends Negyszog
    {};

    public static class Negyzet extends Negyszog // négyzet kerülete esetén nincs b, csak 4 a
    {};
    
    public static void main(String[] args) {
     //Program program;
     Negyszog negyszog = new Negyszog();
     Program.fgv(negyszog);

     Teglalap teglalap = new Teglalap();
     Program.fgv(teglalap);

     Negyzet negyzet = new Negyzet();
     Program.fgv(negyzet); // sérül az LSP, mert a négyzet kerületét nem számíthatjuk ki úgy, 
                              // mint a téglalapét, mert mások az adatok
    }
};