public class Yoda {

    public static void main(String[] args) {
        
        String szoveg = "ABCD";
        
        if(szoveg.equals("ABCD"))
            System.out.println("Ezaz.");
        
        szoveg = null;
        
        if(szoveg.equals("ABCD"))
            System.out.println("Ezaz");
        
    }    
}
//// MEGOLDÁS KIKÉNYSZERÍTÉSSEL
/*public static void main(String[] args) {
        int x=2;
        try{
            if (x==2) {
                throw new NullPointerException();
            }
        }
        catch(NullPointerException ex){
            ex.printStackTrace();
        }
        catch(Exception ex){
            System.out.println("hiba");
        }
        finally{ //mindenképp végrehajtja
            System.out.println("vége");
        }
    }
*/