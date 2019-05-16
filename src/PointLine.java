import java.awt.*;

public class PointLine {
    public int y;
    public int length;

    public PointLine(int y,int lenght){
        this.y=y;
        this.length=lenght;

    }

    public void draw(Graphics2D g){
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        for(int x = 0;x<ScenePanel.WIDTH;x+=length){
            g.drawLine(x,y,x=x+length,y);
        }
    }

}
