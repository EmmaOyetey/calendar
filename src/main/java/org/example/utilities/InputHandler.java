package org.example.utilities;

import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public String next() {
        return scanner.next();
    }

    public LocalTime nextLocalTime() {
        System.out.print("Enter time (HH:mm): ");
        String timeString = scanner.next();
        return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
    }

    public void close() {
        scanner.close();
    }
}
