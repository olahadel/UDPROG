import java.io.File;

public class File_bejaras {
    
    static void bejar(File bejegyzes) {
        File[] elemek = bejegyzes.listFiles();
        for(int i=0; i<elemek.length; i++) {
            //System.out.println(elemek[i].getName());
            if (elemek[i].isDirectory()) {
                System.out.println(elemek[i].getAbsolutePath());
                bejar(elemek[i]);
            }
            else if (elemek[i].isFile()) {
                String s = elemek[i].getName().toLowerCase();  //állomány nevét adja vissza
                if (s.endsWith(".java")) {
                    System.out.println("--" + elemek[i].getName());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        File gyoker = new File("E:\\Multimedia\\Dokumentum\\PTI\\3.felev\\prog2");
        bejar(gyoker);
    }
}
