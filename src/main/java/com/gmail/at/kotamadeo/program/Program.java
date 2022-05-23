package com.gmail.at.kotamadeo.program;

import com.gmail.at.kotamadeo.utils.Utils;

import java.io.*;
import java.util.Scanner;

public class Program {
    private final Scanner scanner = new Scanner(System.in);
    private final LeapYear leapYear = new LeapYear();
    private static final String FILE = "score.txt";
    private String maxScore;

    public void start() {
        String input;
        readScore();
        while (true) {
            try {
                printMenu();
                input = scanner.nextLine();
                String[] yearAndDays = input.split(" ");
                var inputYear = Integer.parseInt(yearAndDays[0]);
                var inputDays = Integer.parseInt(yearAndDays[1]);
                leapYear.yearAndDaysCorrect(inputYear, inputDays);
                if (inputDays != leapYear.getDays()) {
                    System.out.println(Utils.ANSI_RED + "Ошибка! Ваш счет: " + leapYear.getScore() + Utils.ANSI_RESET);
                    scanner.close();
                    break;
                } else {
                    writeScore();
                    System.out.printf("%sВерно! В %s годе %s дней.%n%s", Utils.ANSI_GREEN, leapYear.getYear(),
                            leapYear.getDays(), Utils.ANSI_RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(Utils.ANSI_RED + "Ошибка ввода!" + Utils.ANSI_RESET);
            }
        }
    }

    private void printMenu() {
        System.out.println(Utils.ANSI_YELLOW + "В этой игре необходимо угадывать количество дней в году!"
                + Utils.ANSI_RESET);
        System.out.println("Введите год в формате 'yyyy' и количество дней в формате 'ddd' через пробел.");
        System.out.print(">>>>>>>");
    }

    private void writeScore() {
        maxScore = Integer.toString(leapYear.getScore());
        try (var writer = new BufferedWriter(new FileWriter(FILE))) {
            writer.write(maxScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readScore() {
        maxScore = Integer.toString(leapYear.getScore());
        var parse = Integer.parseInt(maxScore);
        try (var reader = new BufferedReader(new FileReader(FILE))) {
            while ((parse = reader.read()) != -1) {
                //System.out.println("ASCII: " + parse);
                System.out.println("Ваш прошлый лучший результат: " + (char) parse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

