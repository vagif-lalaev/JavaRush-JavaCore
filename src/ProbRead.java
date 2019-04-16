import java.io.*;

public class ProbRead {
    public static void main(String[] args) throws IOException {
        // работа с байтами
        File file = new File("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\hi");
        File file2 = new File("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\cifri");
        // чтение байтов
        FileInputStream fileInputStream = new FileInputStream(file);
        long sum = 0;
        while (fileInputStream.available() > 0 ) { //пока остались непрочитанные байты
            int data = fileInputStream.read(); //прочитать очередной байт
            sum+=data; //добавить его к общей сумме
        }
        //System.out.println(sum);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        while (fileInputStream.available() > 0 ) {
            int data = fileInputStream.read(); // прочитать очередной байт в переменную data
            fileOutputStream.write(data); // и записать его во второй поток
        }
        fileOutputStream.close(); // закрываем поток
        fileInputStream.close(); // закрываем поток
    }
}
