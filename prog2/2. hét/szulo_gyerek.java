public class szulo_gyerek {
    
    public static void main(String[] args) {
        Szulo szulo = new Szulo(); //ősosztály Object osztály
        Gyerek gyerek = new Gyerek();
        Szulo ujgyerek= new Gyerek();
        //Gyerek ujszulo = new Szulo(); //Gyerek osztály több mindent tartalmaz a Szülőnél
        szulo.fuggveny();
        gyerek.fuggveny();
        ujgyerek.fuggveny();
        //ujgyerek.ujfuggveny();   //nem hívható meg a metódus
    }
}

    class Szulo{  //nem lehet publikus
        public void fuggveny(){
            System.out.println("szülő");
        };
    }
    
    class Gyerek extends Szulo{

        @Override
        public void fuggveny() {
            System.out.println("gyerek");
            //super.fuggveny(); //ősosztály függvény metódusa
        }
        public void ujfuggveny() {
            System.out.println("ujfuggveny");
        }
            
    }