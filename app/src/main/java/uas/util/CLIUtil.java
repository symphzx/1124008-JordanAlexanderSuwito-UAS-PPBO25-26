package uas.util;

import java.util.Scanner;

// import javax.swing.JOptionPane;

public class CLIUtil {
        private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int getInt() {
        return scanner.nextInt();
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static int askForInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static String askForString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    // public static String askForString(String message) {
    //     return JOptionPane.showInputDialog(null, message);
    // }

    // public static int askForInt(String message) {
    //     String input = askForString(message);
    //     if (input == null) {
    //         return 0;
    //     }
    //     try {
    //         return Integer.parseInt(input);
    //     } catch (NumberFormatException e) {
    //         showMessage("Input tidak valid! Harap masukkan angka.");
    //         return 0;
    //     }
    // }
}