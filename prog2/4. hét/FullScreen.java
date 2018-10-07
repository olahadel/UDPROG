import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FullScreen extends JFrame{

    static JLabel message = new JLabel("This is a full screen application."); //Alt+F4
    
    public static void main(String[] args) {
        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);   //DisplayMode( x, y, bit depth 8/16/32,monitor frissítési rátája)
        FullScreen b = new FullScreen();
        //b.run(dm);
        b.add(message);
        
        b.setExtendedState(JFrame.MAXIMIZED_BOTH);
        b.setUndecorated(true);
        b.setVisible(true);
    }
    
    /*public void run(DisplayMode dm) {
        setBackground(Color.orange);
        setForeground(Color.white);
        setFont(new Font("Arial", Font.PLAIN, 24));
        
        Screen s = new Screen();
        try {
            s.setFullScreen(dm, this);
            try {
                Thread.sleep(5000);
            }catch(Exception ex) {}
        } finally {
            s.restoreScreen();
        }      
    }
    
    public void paint(Graphics g){  //nem hívtuk meg mégis lefut: ha a JFrame osztállyal dolgozunk az automatikusan meghívja a paint metódust
        g.drawString("This is it.", 200, 200);
    }*/
    
}
