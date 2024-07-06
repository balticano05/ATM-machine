package utils;

import java.util.Scanner;

public final class ScannerSingle {
    private static ScannerSingle instance;
    private final Scanner scanner;

    private ScannerSingle(){
        scanner = new Scanner(System.in);
    }


    public static ScannerSingle getInstance() {
        if (instance == null) {
            instance = new ScannerSingle();
        }
        return instance;
    }

    public Scanner getScanner() {
        return scanner;
    }
}