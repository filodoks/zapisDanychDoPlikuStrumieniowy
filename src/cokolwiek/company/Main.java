package cokolwiek.company;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Wywolanie programu: Main nazwa_pliku");
            return;
        }
        BufferedReader brIn = new BufferedReader(
                new InputStreamReader(System.in)
        );

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(args[0], true);
        } catch (IOException e) {
            System.out.println("Nie moge otworzyc wskazanego pliku.");
            return;
        }

        String line = "";

        try {
            while (true) {
                line = brIn.readLine();
                if ("quit".equals(line) || line == null) {
                    break;
                }
                line += "\n";
                fileWriter.write(line, 0, line.length());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("\nBlad I/O.");
            return;
        }
    }
}