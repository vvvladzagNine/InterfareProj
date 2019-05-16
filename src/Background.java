import java.awt.*;

public class Background {
    protected  int red=255;
    protected  int green=255;
    protected  int blue=255;
    protected  int alpha=255;

    private Color color;

    public Background(){
        color = new Color(red,green,blue,alpha);
    }

    public void update(){

    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(0,0,ScenePanel.WIDTH,ScenePanel.HEIGHT);
    }

    public void setColor(Color color){
        this.color = color;

    }
}
