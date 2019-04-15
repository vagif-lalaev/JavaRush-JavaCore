import java.io.*;

public class Probuem_zapisivat {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Вагиф\\YandexDisk\\JAVA\\Проэкты от JavaRush\\Проэкты от JavaRush (полностью рабочая)\\JavaRushTasks\\2.JavaCore\\src\\hi");
        String a = "Hi my friend";
//
//        FileOutputStream fileOutputStream = new FileOutputStream("hi.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//
//        objectOutputStream.write(77);
//
//        objectOutputStream.close();

//        FileInputStream fileInputStream = new FileInputStream(file);
//
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Проверка\n");
        fileWriter.write(a+"\n");
        fileWriter.write("а тут запишим по русски");
//        FileReader fileReader = new FileReader(String.valueOf(fileWriter));
//        BufferedReader bufferedReader = new BufferedReader(fileReader);

//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        fileWriter.close();

//        System.out.println(fileWriter);
    }
}
