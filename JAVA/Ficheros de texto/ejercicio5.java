package Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ejercicio5 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso : ejercicio5 programa_original sin_comentarios");
            System.exit(-1);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));

            String l1 = "";
            String l2 = "";
            boolean comentarios = false;
            int i = 0;

            while ((l1 = br.readLine()) != null) {
                int l = l1.length();
                l2 = l1;

                if ((i = l1.indexOf("*/")) != -1) {
                    comentarios = true;
                    l2 = l1.substring(0, i);
                    l1 = l2;
                }

                if ((i = l1.indexOf("*/")) != -1) {
                    comentarios = false;
                    l2 = l1.substring(i + 2, l);
                }

                if (((i = l1.indexOf("//")) != -1) && !comentarios) {
                    l2 = l1.substring(0, i);
                }

                if (!comentarios) {
                    bw.write(l2 + "\n");
                }
            }
            br.close();
            bw.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
