import javax.swing.*;
import java.awt.event.*;

public class GUI_HF2 {
    public static class SimpleGui1B implements ActionListener {
        JButton button;

        public static void main (String[] args) {
            SimpleGui1B gui = new SimpleGui1B();
            gui.go();
        }

        public void go() {
            JFrame frame = new JFrame();
            button = new JButton("click me");

            button.addActionListener(this); // регистрируем нашу заинтересованность в кнопке:
            // "Добавь меня к своему списку слушателей".
            // Пекркдаваемый аргумент должне быть объектом класса реализуемого ActionListener!

            frame.getContentPane().add(button);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 700);
            frame.setVisible(true);
        }

        public void actionPerformed(ActionEvent event) { // то метод обработки событий
            button.setText("I ve been clicked!"); // кнопка сигнализирующая о событии
        }

    }
}
