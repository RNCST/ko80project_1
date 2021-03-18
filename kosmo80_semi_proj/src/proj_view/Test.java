package proj_view;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

public class Test extends JFrame {

    List<JButton> buttons;

    public Test() {
        buttons = new ArrayList<>();
        buttons.add(new JButton("1"));
        buttons.add(new JButton("2"));
        buttons.add(new JButton("3"));

        this.setLayout(new FlowLayout());

        for (JButton jButton : buttons) {
            jButton.addMouseListener(new TestMouseInputAdapter1(this));
            this.add(jButton);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,100);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }

    public void setAllButtonModelPressed() {
        for (JButton jButton : buttons) {
            jButton.getModel().setPressed(true);
        }
    }

    public void setAllButtonModelReleased() {
        for (JButton jButton : buttons) {
            jButton.getModel().setPressed(false);
        }
    }
}

class TestMouseInputAdapter1 extends MouseInputAdapter {

    Test test;

    public TestMouseInputAdapter1(Test test) {
        this.test = test;
    }


	public void mousePressed(MouseEvent e) {
        test.setAllButtonModelPressed();
    }

    public void mouseReleased(MouseEvent e) {
        test.setAllButtonModelReleased();
    }
}