package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
/* 
Собираем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> partsName = new TreeSet<>();
        while (true){
            String s = reader.readLine();
            if (s.equals("end")){break;}
            partsName.add(s);
        }

        String ss = partsName.toArray()[0].toString();
        String [] w = ss.split("\\.");
        String filename = w[0]+"."+w[1];
        FileOutputStream fos = new FileOutputStream(filename);

        for (String p : partsName){
            FileInputStream pf = new FileInputStream(p);
            byte [] buffer = new byte[pf.available()];
            pf.read(buffer);
            fos.write(buffer);
            pf.close();
        }
        fos.close();
    }
}
