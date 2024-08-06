package utils;

import java.io.*;

public class FileHelper {

    private final File _file;

    public FileHelper(String fileName) {
        _file = new File(fileName);
    }

    public void saveToFile(String info) {
        try {
            // Leggi il contenuto esistente del file
            StringBuilder content = new StringBuilder();
            if (_file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(_file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                }
            } else {
                System.out.println("File does not exist");
                System.out.println("Error saveToFile in class Fil");
                System.exit(0);
            }

            // Aggiungi la nuova informazione alla fine del contenuto
            content.append(info).append(System.lineSeparator());

            // Scrivi il contenuto aggiornato nel file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(_file))) {
                bw.write(content.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
