package ap.exercises.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Main_EX2_PM_3_2 extends JFrame implements KeyListener {

    static int k;
    final int boxSize = 7;
    final int width = k * boxSize, height = k * boxSize;
    Point pacmanPoint = new Point();

    public Main_EX2_PM_3_2() {
        addKeyListener(this);
        pacmanPoint.setLocation((width / boxSize) / 2, (height / boxSize) / 2);
        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g.clearRect(0, 0, width, height);
        g2D.setColor(Color.BLUE);
        g2D.fillRect(pacmanPoint.x * boxSize, pacmanPoint.y * boxSize, boxSize, boxSize);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int xMovement = 0;
        int yMovement = 0;

        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("UP");
            xMovement = 0;
            yMovement = -1;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("DOWN");
            xMovement = 0;
            yMovement = +1;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("LEFT");
            xMovement = -1;
            yMovement = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("RIGHT");
            xMovement = 1;
            yMovement = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_Q) {
            System.exit(10);
        } else {
            System.out.println("WARNING");
            xMovement = 0;
            yMovement = 0;
        }
        pacmanPoint.setLocation(pacmanPoint.x + xMovement, pacmanPoint.y + yMovement);
        handleCrossBorder();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void handleCrossBorder() {
        if (pacmanPoint.x < 8 / boxSize) {
            pacmanPoint.x = 8 / boxSize;
        } else if (pacmanPoint.x > (width / boxSize) - 2) {
            pacmanPoint.x = (width / boxSize) - 2;
        }

        if (pacmanPoint.y < 30 / boxSize) {
            pacmanPoint.y = 30 / boxSize;
        } else if (pacmanPoint.y > (height / boxSize) - 2) {
            pacmanPoint.y = (height / boxSize) - 2;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input an integer number for the size of game-field:");
        k = input.nextInt();
        Main_EX2_PM_3_2 frame = new Main_EX2_PM_3_2();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
