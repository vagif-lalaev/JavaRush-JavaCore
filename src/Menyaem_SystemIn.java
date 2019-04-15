import java.io.*;

public class Menyaem_SystemIn {
    public static void main(String[] args) throws IOException {
//        String r = null;
//        int x = 0;
//        System.out.println("2"+1 + 2);
//        System.out.println(r);
//        System.out.println(x+r+5);


//кладем данные в строку
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');
        sb.append("Olya").append('\n');
        sb.append("Anya").append('\n');
        String data = sb.toString();

        //Оборачиваем строку в класс ByteArrayInputStream
        InputStream is = new ByteArrayInputStream(data.getBytes());

        //подменяем in
        System.setIn(is);

        //вызываем обычный метод, который не подозревает о наших манипуляциях
        readAndPrintLine();
    }

    public static void readAndPrintLine() throws IOException
    {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(isr);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader.close();
        //isr.close();



    }
}
