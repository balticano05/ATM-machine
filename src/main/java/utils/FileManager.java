package utils;

import entity.Card;
import exceptions.IncorrectDataFormatInFileException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

public final class FileManager {

    private static ConfigReader configReader = ConfigReader.getInstance();

    private static Path path = Paths.get(configReader.getStringValue("filePath"));

    private FileManager() {}

    public static HashSet<String> readData() {

        HashSet<String> lines = new HashSet<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {

                Checker.validateFormatLine(line);

                lines.add(line);
            }
        } catch (IOException e) {
            handleFileError(e);
        } catch (IncorrectDataFormatInFileException e) {
            handleFormatError(e);
        }

        return lines;

    }

    public static void writeData(HashSet<Card> cards) {

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            for (Card card : cards) {

                Checker.validateFormatLine(card.toString());

                writer.write(card.toString());

                writer.newLine();
            }
        } catch (IOException e) {
            handleFileError(e);
        } catch (IncorrectDataFormatInFileException e) {
            handleFormatError(e);
        }
    }

    private static void handleFileError(IOException e) {

        System.out.println("Ошибка работы с файлом. Аварийное прекращение работы...");

        e.printStackTrace();
        System.exit(2);
    }

    private static void handleFormatError(IncorrectDataFormatInFileException e) {

        System.out.println("Ошибка формата данных. Аварийное прекращение работы...");

        System.exit(3);
    }
}
