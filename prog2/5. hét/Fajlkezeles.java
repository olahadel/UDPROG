import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fajlkezeles {
    //c++ban indexof, hátulrol is lehet működik h a pont utáni részt kipásolom és az a kiterjesztés

    public static void main(String[] args) throws IOException {
        File f = new File("valami.txt");
        System.out.println(f.getAbsolutePath());
        //System.setProperty("user.dir", "C:\\temp\\..");
        System.out.println(f.getCanonicalPath());   //feloldja a . .. részeket
        try {
            System.out.println(f.getCanonicalPath());
            f.createNewFile();
            if (f.exists()) {
                System.out.println("letezik");
            }
            if (f.isDirectory()) {
                System.out.println("konyvtar");
            }
            File gyoker = new File("C:\\");
            File[] elemek = gyoker.listFiles();
            for(int i=0; i<elemek.length; i++) {
                System.out.println(elemek[i].getName());
            }
            
            FileFilter szuro = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.isFile()) {
                        String s = pathname.getName().toLowerCase();  //állomány nevét adja vissza
                        if (s.endsWith(".sys")) {
                            return true;
                        }
                    }
                    return false;
                }
            };
            
            System.out.println("Szürt elemek: ");
            gyoker = new File("C:\\");
            elemek = gyoker.listFiles(szuro);
            for(int i=0; i<elemek.length; i++) {
                System.out.println(elemek[i].getName());
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Fajlkezeles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
