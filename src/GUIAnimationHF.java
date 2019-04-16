
import com.sun.prism.Graphics;

import javax.swing.*;
import java.awt.*;

    class SimpleAnimation {
        int x = 70; // создаем два поля в главном классе GUI
        int y = 70; // для координат x и y круга.


        public static void main(String[] args) {
            SimpleAnimation gui = new SimpleAnimation();
            gui.go();

        }

        public void go() {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MyDrawPanel drawPanel = new MyDrawPanel();
// создаем виджеты и помещаем их во фрейм.
            frame.getContentPane().add(drawPanel);
            frame.setSize(300, 300);
            frame.setVisible(true);

            for (int i = 0; i < 130; i++) {
                x++; // увеличиваем координаты
                y++; // увеличиваем координаты

                drawPanel.repaint(); // чтобы панель себя перерисовала (и мы смогли увидеть круг на новом месте)

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        class MyDrawPanel extends JPanel {
            public void paintComponent(java.awt.Graphics g) {
                g.setColor(Color.white); // без этих команд круг будет размазан
                g.fillRect(0,0,this.getWidth(), this.getHeight()); // без этих команд круг будет размазан

                g.setColor(Color.orange);
                g.fillOval(x, y, 40, 40);
            }
        }
    }

