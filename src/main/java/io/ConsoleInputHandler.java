package io;

import java.util.Scanner;

public class ConsoleInputHandler {

    private final Scanner SCANNER = new Scanner(System.in);

    public String getUserInput() {
        return SCANNER.nextLine();
    }

}