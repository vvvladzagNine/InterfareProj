import javafx.scene.Scene;

import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        ScenePanel.mouseX = e.getX();
        ScenePanel.mouseY = e.getY();
        Start.mouseCord.setText("X: " + ScenePanel.mouseX + " Y: " + ScenePanel.mouseY);

    }
}
