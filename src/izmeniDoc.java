import java.io.*;

public class izmeniDoc {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()))) {
            while (file.ready()) {
                String str = file.readLine(); //построчное чтение строки
                String x = str.replaceAll("а", "a"); //меняем "." на "!"
                writer.write(x + "\n"); //записываем смененый текст
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
