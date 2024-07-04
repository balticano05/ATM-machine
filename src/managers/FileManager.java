package managers;

import entity.cards.Card;
import validation.Checker;
import validation.exceptions.IncorrectDataFormatInFileException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

public class FileManager {
    static ConfigReader configReader = new ConfigReader();
    private static Path path = Paths.get(configReader.getFilePath());
    //private static Path path = Paths.get("src/resources/Data.txt");

    public static HashSet<String> readData() {
        HashSet<String> lines = new HashSet<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Checker.validateFormatLine(line);
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл с карточками не найден. Аварийное прекращение работы...");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом. Аварийное прекращение работы...");
            System.exit(2);
        }catch (IncorrectDataFormatInFileException e){
            System.out.println("Ошибка формата данных. Аварийное прекращение работы...");
            System.exit(3);
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
        } catch (FileNotFoundException e) {
            System.out.println("Файл с карточками не найден. Аварийное прекращение работы...");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом. Аварийное прекращение работы...");
            System.exit(2);
        }catch (IncorrectDataFormatInFileException e){
            System.out.println("Ошибка формата данных. Аварийное прекращение работы...");
            System.exit(3);
        }
    }
}
