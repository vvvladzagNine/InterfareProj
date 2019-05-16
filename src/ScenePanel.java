import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScenePanel extends JPanel implements Runnable{

    public static int mouseX=0;
    public static int mouseY=0;
    public static boolean leftMouse;

    public static int WIDTH = 700;
    public static int HEIGHT = 600;
    public static int allY = 300;

    private Thread thread;
    private BufferedImage image;
    private Graphics2D g;

    private int fps;
    private double millisToFPS;
    private long timerFPS;
    private int sleepTime;

    public static Background background;
    public static Env env;
    public static LightSourses lightSourses;
    public static PointLine pointLine;
    public static Screen screen;
    public static Point[] points;
    public static int delta = 1;
    public static int st = 30;
    public static double n = 1.0;


    public ScenePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        addKeyListener(new Listeners());
        addMouseListener(new Listeners());
        addMouseMotionListener(new Listeners());

    }
    //Functions
    public void start(){
        thread= new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        fps=25;
        millisToFPS = 1000/fps;
        sleepTime=0;

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        leftMouse = false;

        background = new Background();
        env=new Env();
        lightSourses = new LightSourses(allY,30);
        pointLine = new PointLine(allY,10);
        screen = new Screen(650,allY,300);

        points = new Point[screen.length/delta];
        st = allY-screen.length/2;
        for(int i =0;i<points.length;i++){

            points[i]=new Point(screen.x,st+delta*i);
        }

        while (true){
            timerFPS = System.nanoTime();

            sceneRender();
            sceneDraw();
            sceneUpdate();

            timerFPS = (System.nanoTime()-timerFPS)/1000000;
            if(timerFPS<fps){
                sleepTime = (int) (millisToFPS-timerFPS);
            }
            else {
                sleepTime=1;
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            timerFPS=0;
            sleepTime=1;
        }

    }

    private void sceneRender(){
        background.draw(g);
        lightSourses.draw(g);
        pointLine.draw(g);
        env.draw(g);
        screen.draw(g);


        g.setStroke(new BasicStroke(delta));

        for (int i=0;i<points.length;i++){
            double r1 = lightSourses.point1.distance(points[i]);
            double r2 = lightSourses.point2.distance(points[i]);
            double dl = (r2-r1)*n;
            double c = Math.cos(2*Math.PI*dl/5);
            c=Math.pow(c,2);
            int aplha = Math.abs((int)(255*c));


            g.setColor(new Color(231,224,81,aplha));

            g.drawLine((int)points[i].getX()-8,(int)points[i].getY(),(int)points[i].getX()+8,(int)points[i].getY());
        }
    }

    private void sceneDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    private void sceneUpdate(){
        background.update();
        lightSourses.update();
        screen.update();
        env.update();

        for(int i =0;i<points.length;i++){

            points[i]=new Point(screen.x,st+delta*i);
        }

        n=(double)(Start.sliderN.getValue())/100;
    }
}
