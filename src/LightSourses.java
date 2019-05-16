import java.awt.*;

public class LightSourses {

    public int d;
    public int x;
    public int y;
    public int r;
    public Point point1;
    public Point point2;
    private Color color;

    public LightSourses(int y,int d){
        color=new Color(240, 209, 35,255);
        this.d = d;
        x=60;
        r=18;
        this.y=y;
        point1 = new Point(x,y+d/2);
        point2 = new Point(x,y-d/2);

    }

    public void update(){
        d=Start.sliderD.getValue();
        point1 = new Point(x,y+d/2);
        point2 = new Point(x,y-d/2);
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(x,y+d/2,r,r);
        g.fillOval(x,y-d/2-r,r,r);


        g.setStroke(new BasicStroke(2));
        g.setColor(color.darker());
        g.drawOval(x,y+d/2,r,r);
        g.drawOval(x,y-d/2-r,r,r);

        g.setStroke(new BasicStroke(1));
    }
}
