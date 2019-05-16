import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {
    static JFrame frame;
    static ScenePanel scenePanel;
    static JPanel toolPanel;
    static JLabel mouseCord;
    static JSlider sliderD;
    static JSlider sliderS;
    static JSlider sliderN;
    static JButton pointButton;

    public static void main(String[] args) {
        frame = new JFrame("Interference simulator");
        scenePanel = new ScenePanel();
        toolPanel = new JPanel();
        toolPanelBuild();

        frame.getContentPane().add(BorderLayout.CENTER,scenePanel);
        frame.getContentPane().add(BorderLayout.EAST,toolPanel);


        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        scenePanel.start();

        frame.setVisible(true);
    }

    private static void toolPanelBuild(){
        JPanel toolPanel1 = new JPanel();
        toolPanel.setPreferredSize(new Dimension(200,ScenePanel.HEIGHT));
        toolPanel.setLayout(new BoxLayout(toolPanel,BoxLayout.Y_AXIS));
        toolPanel1.setLayout(new FlowLayout());
        mouseCord=new JLabel();

        sliderD = new JSlider(0,20,60,30);
        sliderD.setMajorTickSpacing(10);
        sliderD.setPaintLabels(true);
        sliderD.setOrientation(SwingConstants.VERTICAL);

        sliderS = new JSlider(0,200,680,650);
        sliderS.setMajorTickSpacing(80);
        sliderS.setPaintLabels(true);
        sliderS.setOrientation(SwingConstants.VERTICAL);

        sliderN = new JSlider(0,100,300,100);
        sliderN.setMajorTickSpacing(50);
        sliderN.setPaintLabels(true);
        sliderN.setOrientation(SwingConstants.VERTICAL);

        mouseCord.setText("X: " + ScenePanel.mouseX + " Y: " + ScenePanel.mouseY);
        toolPanel1.add(sliderD);
        toolPanel1.add(sliderS);
        toolPanel1.add(sliderN);
        toolPanel.add(toolPanel1);
        toolPanel.add(mouseCord);




    }
}
