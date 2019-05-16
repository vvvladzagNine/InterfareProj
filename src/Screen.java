import java.awt.*;

public class Screen {
    public int x;
    public int y;
    public int length;

    public Screen(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    public void draw(Graphics2D g){
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(30));
        g.drawLine(x,y-length/2,x,y+length/2);

    }

    public void update(){
        x=Start.sliderS.getValue();
    }
}
