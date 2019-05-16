import java.awt.*;

public class Env {
    protected  int red=30;
    protected  int green=168;
    protected  int blue=254;
    protected  int alpha=100;

    private Color color;

    public Env(){
        color = new Color(red,green,blue,alpha);
    }

    public void update(){
        alpha=(int)((Start.sliderN.getValue()-100)*0.5);
        color = new Color(red,green,blue,alpha);
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(0,0,ScenePanel.WIDTH,ScenePanel.HEIGHT);
    }

    public void setColor(Color color){
        this.color = color;

    }
}