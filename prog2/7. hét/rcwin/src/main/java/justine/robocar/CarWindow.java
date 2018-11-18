package justine.robocar;

import com.sun.org.apache.xpath.internal.axes.LocPathIterator;
import java.util.HashSet;
import java.util.Set;
import org.jxmapviewer.viewer.Waypoint;

class Traffic {

    public java.util.Set<org.jxmapviewer.viewer.Waypoint> waypoints;
    public String title;

    public Traffic(java.util.Set<org.jxmapviewer.viewer.Waypoint> waypoints, String title) {

        this.waypoints = waypoints;
        this.title = title;
    }  
}

class WaypointPolice implements org.jxmapviewer.viewer.Waypoint {

    org.jxmapviewer.viewer.GeoPosition geoPosition;
    String name;

    public WaypointPolice(double lat, double lon, String name) {
        geoPosition = new org.jxmapviewer.viewer.GeoPosition(lat, lon);
        this.name = name;
    }

    @Override
    public org.jxmapviewer.viewer.GeoPosition getPosition() {
        return geoPosition;
    }

    String getName() {
        return name;
    }
}

class WaypointGangster implements org.jxmapviewer.viewer.Waypoint {

    org.jxmapviewer.viewer.GeoPosition geoPosition;

    public WaypointGangster(double lat, double lon) {
        geoPosition = new org.jxmapviewer.viewer.GeoPosition(lat, lon);
    }

    @Override
    public org.jxmapviewer.viewer.GeoPosition getPosition() {
        return geoPosition;
    }
}

class WaypointCaught implements org.jxmapviewer.viewer.Waypoint {

    org.jxmapviewer.viewer.GeoPosition geoPosition;

    public WaypointCaught(double lat, double lon) {
        geoPosition = new org.jxmapviewer.viewer.GeoPosition(lat, lon);
    }

    @Override
    public org.jxmapviewer.viewer.GeoPosition getPosition() {
        return geoPosition;
    }
}

class Loc {

    double lat, lon;

    public Loc(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}

public class CarWindow extends javax.swing.JFrame {

    org.jxmapviewer.viewer.WaypointPainter<org.jxmapviewer.viewer.Waypoint> waypointPainter
            = new org.jxmapviewer.viewer.WaypointPainter<org.jxmapviewer.viewer.Waypoint>();
    org.jxmapviewer.viewer.GeoPosition[] geopos
            = new org.jxmapviewer.viewer.GeoPosition[4];
    org.jxmapviewer.JXMapViewer jXMapViewer
            = new org.jxmapviewer.JXMapViewer();
    java.util.Map<Long, Loc> lmap = null;
    java.io.File tfile = null;
    java.util.Random rnd = new java.util.Random();
    java.util.Scanner scan = null;

    String hostname = "localhost";
    int port = 10007;

    java.awt.Robot robot;

    public CarWindow(double lat, double lon, java.util.Map<Long, Loc> lmap, String hostname, int port) {

        this.lmap = lmap;
        this.hostname = hostname;
        this.port = port;

        final org.jxmapviewer.viewer.TileFactory tileFactoryArray[] = {
            new org.jxmapviewer.viewer.DefaultTileFactory(
            new org.jxmapviewer.OSMTileFactoryInfo()),
            new org.jxmapviewer.viewer.DefaultTileFactory(
            new org.jxmapviewer.VirtualEarthTileFactoryInfo(org.jxmapviewer.VirtualEarthTileFactoryInfo.MAP)),
            new org.jxmapviewer.viewer.DefaultTileFactory(
            new org.jxmapviewer.VirtualEarthTileFactoryInfo(org.jxmapviewer.VirtualEarthTileFactoryInfo.SATELLITE)),
            new org.jxmapviewer.viewer.DefaultTileFactory(
            new org.jxmapviewer.VirtualEarthTileFactoryInfo(org.jxmapviewer.VirtualEarthTileFactoryInfo.HYBRID))
        };

        Set<Waypoint> waypoints = new HashSet<Waypoint>();
        
        Traffic traffic = new Traffic(waypoints, "Pontok");
        setTitle(traffic.title);

        traffic.waypoints.add(new WaypointPolice(47.543363, 21.640751, "Kassai úti Campus"));
        traffic.waypoints.add(new WaypointPolice(47.549795, 21.608731, "Böszörményi úti Campus"));
        traffic.waypoints.add(new WaypointPolice(47.553664, 21.621471, "Egyetem téri Campus"));

        waypointPainter.setWaypoints(traffic.waypoints);
            
        org.jxmapviewer.viewer.GeoPosition debrecen
                = new org.jxmapviewer.viewer.GeoPosition(lat, lon);

        javax.swing.event.MouseInputListener mouseListener
                = new org.jxmapviewer.input.PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mouseListener);
        jXMapViewer.addMouseMotionListener(mouseListener);
        jXMapViewer.addMouseListener(
                new org.jxmapviewer.input.CenterMapListener(jXMapViewer));
        jXMapViewer.addMouseWheelListener(
                new org.jxmapviewer.input.ZoomMouseWheelListenerCursor(jXMapViewer));
        jXMapViewer.addKeyListener(
                new org.jxmapviewer.input.PanKeyListener(jXMapViewer));

        jXMapViewer.setTileFactory(tileFactoryArray[0]);

        ClassLoader classLoader = this.getClass().getClassLoader();

        final java.awt.Image markerImg
                = new javax.swing.ImageIcon(classLoader.getResource("logo1.png")).getImage();
        final java.awt.Image markerImgPolice
                = new javax.swing.ImageIcon(classLoader.getResource("logo-de.png")).getImage();
        final java.awt.Image markerImgGangster
                = new javax.swing.ImageIcon(classLoader.getResource("logo3.png")).getImage();
        final java.awt.Image markerImgCaught
                = new javax.swing.ImageIcon(classLoader.getResource("logo4.png")).getImage();
        
        waypointPainter.setRenderer(
                new org.jxmapviewer.viewer.WaypointRenderer<org.jxmapviewer.viewer.Waypoint>() {
                    @Override
                    public void paintWaypoint(java.awt.Graphics2D g2d, org.jxmapviewer.JXMapViewer jXMapV,
                            org.jxmapviewer.viewer.Waypoint w) {

                        java.awt.geom.Point2D point = jXMapV.getTileFactory().geoToPixel(
                                w.getPosition(), jXMapV.getZoom());

                        if (w instanceof WaypointPolice) {
                            g2d.drawImage(markerImgPolice, (int) point.getX() - markerImgPolice.getWidth(jXMapV),
                                    (int) point.getY() - markerImgPolice.getHeight(jXMapV), null);

                            g2d.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 14));
                            java.awt.FontMetrics fm = g2d.getFontMetrics();
                            int nameWidth = fm.stringWidth(((WaypointPolice) w).getName());
                            g2d.setColor(java.awt.Color.GRAY);
                            java.awt.Rectangle rect = new java.awt.Rectangle((int) point.getX(), (int) point.getY(), nameWidth + 4, 20);
                            g2d.fill(rect);
                            g2d.setColor(java.awt.Color.CYAN);
                            g2d.draw(rect);
                            g2d.setColor(java.awt.Color.WHITE);
                            g2d.drawString(((WaypointPolice) w).getName(), (int) point.getX() + 2, (int) point.getY() + 20 - 5);

                        } else if (w instanceof WaypointGangster) {
                            g2d.drawImage(markerImgGangster, (int) point.getX() - markerImgGangster.getWidth(jXMapV),
                                    (int) point.getY() - markerImgGangster.getHeight(jXMapV), null);
                        } else if (w instanceof WaypointCaught) {
                            g2d.drawImage(markerImgCaught, (int) point.getX() - markerImgCaught.getWidth(jXMapV),
                                    (int) point.getY() - markerImgCaught.getHeight(jXMapV), null);
                        } else {
                            g2d.drawImage(markerImg, (int) point.getX() - markerImg.getWidth(jXMapV),
                                    (int) point.getY() - markerImg.getHeight(jXMapV), null);
                        }
                    }
                });

        jXMapViewer.setOverlayPainter(waypointPainter);
        jXMapViewer.setZoom(7);
        jXMapViewer.setAddressLocation(debrecen);
        jXMapViewer.setCenterPosition(debrecen);
        
        jXMapViewer.addKeyListener(new java.awt.event.KeyAdapter() {
            int index = 0;

            public void keyPressed(java.awt.event.KeyEvent evt) {

                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
                    jXMapViewer.setTileFactory(tileFactoryArray[++index % 4]);
                    jXMapViewer.repaint();
                    repaint();
                }
            }
        });

        setTitle("Justine - Car Window (log player for Robocar City Emulator, Robocar World Championshin in Debrecen)");
        getContentPane().add(jXMapViewer);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        try {
            robot = new java.awt.Robot(
                    java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getDefaultScreenDevice());
        } catch (java.awt.AWTException e) {
            java.util.logging.Logger.getLogger(
                    CarWindow.class.getName()).log(java.util.logging.Level.SEVERE, "Nem lesz pillanatfelvÃ©tel...", e);
        }  
    }

    public static void main(String[] args) {

        final java.util.Map<Long, Loc> lmap = new java.util.HashMap<Long, Loc>();

        if (args.length == 1) {

            //readMap(lmap, args[0]);
            
            lmap.put(1L, new Loc(47.553664, 21.621471));
            lmap.put(1L, new Loc(47.553664, 21.621471));

            final String hostname = args[0];

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {

                    java.util.Map.Entry<Long, Loc> e = lmap.entrySet().iterator().next();

                  //  new CarWindow(e.getValue().lat, e.getValue().lon, lmap, hostname, 10007).setVisible(true);
                    new CarWindow(47.531512, 21.627615, lmap, hostname, 10007).setVisible(true);
                }
            });
        }
        else {

            System.out.println("java -jar target/site/justine-rcwin-0.0.16-jar-with-dependencies.jar ../../../lmap.txt localhost");
        }
    }
}
