import javax.swing.*;

import javax.swing.*;

public class GUI_Head_First {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // создаем фрейм
        JButton button = new JButton("click me"); // создаем кнопку

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // для завершении программы (иначе будет работать вечно)

        frame.getContentPane().add(button); // добавить кнопку на панель фрейма

        frame.setSize(400, 600); // присваиваем размер фрейму ( в пикселях)

        frame.setVisible(true); // делаем фрейм видимым

    }
}
